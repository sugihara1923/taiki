import java.awt.*;
import java.awt.event.*;
class MiniRPG {//起動クラス
	public static void main(String[] args) {
		MyWindowRPG mw = new MyWindowRPG();
		Thread th = new Thread(mw);
		th.start();
	}
}

abstract class Character {//キャラクター用の抽象メソッド
	private int life;//体力
	//ゲームとして重要なパラメータの体力をprivateとし、以下のフィールドは修飾子無しとする
	String name;
	int x, y;//座標
	int steps;//何歩、歩いたか（アニメーションで使用）
	int type;//プレイヤーキャラは1勇者, 2ドラゴン、敵は色を管理
	abstract void move(int left, int top, int right, int bottom);
	abstract int attack(Character[] chr);
	abstract void draw(Graphics g, Image img);
	public int getLife() { return this.life; }//体力値の取得
	public void setLife(int life) { this.life = life; }//体力値のセット
	public int calcLife(int val) {//体力の増減
		this.life += val;
		if(this.life < 0) this.life = 0;
		return this.life;
	}
}

class PlCharacter extends Character {//プレイヤーキャラ用のクラス
	final int[] XP = { 0,  4, 6, 4, 0, -4, -6, -4};//勇者の移動量を８方向で定義
	final int[] YP = {-6, -4, 0, 4, 6,  4,  0, -4};
	static int braveman;//召喚した勇者の数
	static int dragon;//召喚したドラゴンの数
	int xp, yp;//ＸＹ方向の移動量
	PlCharacter(String name, int x, int y, int dir) {
		braveman++;
		this.name = name;
		this.x = x;
		this.y = y;
		this.xp = XP[dir];
		this.yp = YP[dir];
		this.steps = 0;
		this.type = 1;
		setLife(3);//勇者の体力
	}
	PlCharacter(int x, int y) {//コンストラクタのオーバーロード
		dragon++;
		this.name = "ドラゴン";//名前を入れるが使っていない
		this.x = x;
		this.y = y;
		this.xp = -28;
		this.yp = 16;
		this.steps = 0;
		this.type = 2;
		setLife(8);//ドラゴンの体力
	}

	public void move(int left, int top, int right, int bottom) {//移動
		steps++;//歩数をカウント
		if(y < top) { y += steps*steps; return; }//画面半分より上に召喚した場合、画面下まで自由落下
		x += xp;
		y += yp;
		if(x < left || right < x) { x-=xp; xp=-xp; }//左右の画面外で向きを変える
		if(y < top || bottom < y) { y-=yp; yp=-yp; }//上下の画面外で向きを変える
	}

	public int attack(Character[] c) {//攻撃
		for(int i=0; i<c.length; i++) {
			if(c[i] instanceof EmyCharacter) {//敵であれば
				//２点間の距離(√は付けないdx^2+dy^2の値)で判定、接触していれば配列の添え字の値を返す
				//このプログラムでは64ドット以内であれば接触したと判定
				if(((x-c[i].x)*(x-c[i].x)+(y-c[i].y)*(y-c[i].y))<64*64) return i;
			}
		}
		return -1;
	}

	public void draw(Graphics g, Image img) {//描画
		if(type == 1) {//勇者
			int dir = 0;//キャラの絵の向きを決める
			if(xp > 0) dir = 1;
			if(yp > 0) dir = 2;
			if(xp < 0) dir = 3;
			int sx = 1200+(steps%2)*32;//歩数でアニメーション
			int sy = 240+dir*48;
			g.drawImage(img, x-16, y-24, x+16, y+24, sx, sy, sx+32, sy+48, null);
			g.setColor(Color.WHITE);
			g.drawString(name, x+24, y+16);
		}
		if(type == 2) {//ドラゴン
			int sx = 1200;
			int sy = 432;
			g.drawImage(img, x-61, y-48, x+61, y+48, sx, sy, sx+122, sy+96, null);
		}
		for(int i=0; i<getLife(); i++) g.drawImage(img, x+24+i*16, y-16, x+40+i*16, y, 1264, 240, 1280, 256, null);//ライフの表示
	}
}

class EmyCharacter extends Character {//敵キャラ用のクラス
	static int enemy;
	EmyCharacter(int x, int y, int col) {
		enemy++;
		this.name = "ハニワスライム";//名前を入れるが使っていない
		this.x = x;
		this.y = y;
		this.steps = 0;
		this.type = col;
		setLife(col+1);//敵の体力は緑が1、黄色が2、赤が3
	}

	public void move(int left, int top, int right, int bottom) {
		steps++;
		x = x + (int)(Math.random()*11)-5;
		y = y + (int)(Math.random()*11)-5;
		if(x < left) x = left;
		if(x > right) x = right;
		if(y < top) y = top;
		if(y > bottom) y = bottom;
	}

	public int attack(Character[] c) { return -1; }//敵は攻撃しないので-1を返す

	public void draw(Graphics g, Image img) {
		int sx = 1200 + (steps%2)*64;
		int sy = type*80;
		g.drawImage(img, x-32, y-40, x+32, y+40, sx, sy, sx+64, sy+80, null);
	}
}

class MyWindowRPG extends Frame implements Runnable {//ウィンドウ(Frame)＋スレッド(Runnable)
	final int WIDTH = 1200;//画面サイズ
	final int HEIGHT = 800;
	final int PL_MAX = 10;//プレイヤーキャラの最大数
	final int EMY_MAX = 30;//敵の最大数
	final int CHR_MAX = PL_MAX + EMY_MAX;
	private Character[] chr = new Character[CHR_MAX];
	private int score;
	private Image img;//画像読み込み

	MyKeyListener key = new MyKeyListener();//キー入力のオブジェクト
	MyMouseListener mouse = new MyMouseListener();//マウス入力のオブジェクト

	MyWindowRPG() {//ウィンドウのコンストラクタ
		img = getToolkit().getImage("MiniRPG.png");//画像の読み込み
		setSize(WIDTH, HEIGHT);
		setTitle("召喚勇者ＲＰＧ");
		setResizable(false);
		addKeyListener(key);
		addMouseListener(mouse);
		addWindowListener( new MyWinListener() );
		setVisible(true);
	}

	public int rnd(int max) { return(int)(Math.random()*max); }//整数の乱数を返すメソッド

	public void run() {//スレッドでリアルタイム処理
		while(true) {
			if(mouse.click == 1) {//画面クリックでキャラを召喚
				mouse.click = 0;
				for(int i=0; i<PL_MAX; i++) {
					if(chr[i] == null) {//配列に空きがあるなら
						if(key.code == KeyEvent.VK_SPACE) {//スペースキーを押しながら
							chr[i] = new PlCharacter(WIDTH/2, 0);//ドラゴン召喚
						}
						else {
							chr[i] = new PlCharacter("勇者"+i, mouse.x, mouse.y, rnd(8));//勇者召喚
						}
						break;
					}
				}
			}

			if(rnd(1000) < 100) {//敵の出現
				int n = PL_MAX + rnd(EMY_MAX);
				if(chr[n] == null) chr[n] = new EmyCharacter(rnd(WIDTH), HEIGHT/2+rnd(HEIGHT/2), rnd(3));
			}

			for(int i=0; i<CHR_MAX; i++) {//キャラクターの動作
				if(chr[i] != null) {
					chr[i].move(0, HEIGHT/2, WIDTH, HEIGHT);//移動
					int atc = chr[i].attack(chr);//攻撃処理（プレイヤーキャラが攻撃した敵の番号が返る）
					if(atc >= 0) {
						if(chr[i].calcLife(-1) == 0) chr[i] = null;//攻撃側（勇者もしくはドラゴン）の体力を減らし、ゼロになったら消滅
						if(chr[atc].calcLife(-1) == 0) {
							chr[atc] = null;//受け側（敵）の体力を減らし、ゼロになったら消滅
							score++;
						}
					}
				}
			}

			repaint();//描画を要求
			try{ Thread.sleep(100); } catch(Exception e) {}//一定時間スレッドを停止
		}
	}

	public void update(Graphics g) { paint(g); }//画面のちらつきを軽減
	public void paint(Graphics g) {//描画処理
		g.drawImage(img, 0, 0, this);//背景の描画
		g.setColor(Color.GREEN); g.drawString("勇者召喚数 "+PlCharacter.braveman, 60, 60);
		g.setColor(Color.CYAN); g.drawString("ドラゴン召喚数 "+PlCharacter.dragon, 60, 90);
		g.setColor(Color.YELLOW); g.drawString("魔物出現数 "+EmyCharacter.enemy, 60, 120);
		g.setColor(Color.PINK); g.drawString("討伐数 "+score, 60, 150);
		g.setColor(Color.WHITE);
		g.drawString("キー" + key.code + " マウス(" + mouse.x + "," + mouse.y + ")", 1000, 60);
		for(int i=0; i<CHR_MAX; i++) if(chr[i] != null) chr[i].draw(g, img);//全キャラクターの描画
	}
}

class MyWinListener extends WindowAdapter {//ウィンドウを閉じる
	public void windowClosing(WindowEvent e) { System.exit(0); }
}

class MyKeyListener extends KeyAdapter {//押されているキーの値を取得
	int code;//他クラスから直接参照するのでprivateにしない
	public void keyPressed(KeyEvent e) { code = e.getKeyCode(); }
	public void keyReleased(KeyEvent e) { code = 0; }
}

class MyMouseListener extends MouseAdapter {//マウスクリックの座標を取得
	int x, y, click;//他クラスから直接参照するのでprivateにしない
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		click = 1;
	}
}
