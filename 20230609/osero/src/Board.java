public class Board {
  static boolean game = true;

  // 8*8のオセロ版を管理する多次元配列
  static String[][] board = new String[8][8];

  // オセロの駒を表示させるための変数宣言
  static final String EMPTY = "";
  static final String BLACK = "●";
  static final String WHITE = "◯";

  static String stone;
  static String rev_stone;

  static public void initialize() {
  // オセロ版をリセットする処理：for文の入れ子構造
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = EMPTY;
      }
    }

  //　ゲーム開始時の初期状態の配置
  board[3][3] = BLACK;
  board[3][4] = WHITE;
  board[4][3] = WHITE;
  board[4][4] = BLACK;

  //　ゲーム進行時の次打つ駒の設定
  stone = BLACK;
  rev_stone = WHITE;
  
  //ゲーム実行中フラグ
  game = true;
}

// オセロ版の設定
static public void showBoard() {
  //空いている座標があるかの確認
  boolean existempty = false;
  //黒い駒の数集計用
  int cnt_black = 0;
  //白い駒の数集計用
  int cnt_white = 0;

  //オセロ版を描写するプログラム
  int i = 0;
  System.out.println(" |0 |1 |2 |3 |4 |5 |6 |7 |");
  System.out.println("――――――――――――――");
  for (String[] sarr : board) {

    System.out.print(i + " |");
    for (String s : sarr) {

        System.out.print(s);
        System.out.print("|");

        //空いている座標があるか、各駒数の集計
        if (s.equals(EMPTY)) {
          existempty = true;
        } else if (s.equals(BLACK)) {
          cnt_black++;
        } else if (s.equals(WHITE)) {
          cnt_white++;
        }
      }
      System.out.println();
      System.out.println("――――――――――――――");

      i++;

    }
    // ラウンド毎の盤面表示
    System.out.println(BLACK + ":" + cnt_black);
    System.out.println(WHITE + ":" + cnt_white);
    System.out.println("――――――――――――――");

    // 空いている駒があるかで条件分岐
    if (existempty) {
      System.out.println(stone + "のターンです");
    } else {
      System.out.println(stone + "ゲーム終了！");
      game = false;
    }
  }

  static public void setStone(int x, int y) {

    // 範囲外のX,Y軸を指定した場合
    if (x > 7 || y > 7) {
      System.out.println("その位置に駒は置けません");
    }

    // 駒を配置できる場合
    if (board[y][x].equals(EMPTY)) {
      board[y][x] = stone;

      // 駒をひっくり返す処理
      turnStone(x, y);

      // 次うつ駒の設定
      String next_rev_storn = stone;
      stone = rev_stone;
      rev_stone = next_rev_storn;

      // オセロ版の描写
      showBoard();

    // 駒を配置できない場合
    }else{
      System.out.println("その位置に駒は置けません");
    }
  }
     
    
    static public void turnStone(int x, int y) {

      // 8方向（上下左右斜め）の駒の配置を確認し、ひっくり返す
  
      turnLeftUp(x, y);
      turnUp(x, y);
      turnRightUp(x, y);
      turnLeft(x, y);
      turnRight(x, y);
      turnLeftDown(x, y);
      turnDown(x, y);
      turnRightDown(x, y);
  
    }

  // 全方向分の処理をそれぞれ追加する
    static public void turnLeftUp(int x, int y) {
      if (y > 1 && x > 1) {
  
        // となりの駒
        String next = board[y - 1][x - 1];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (x - i < 0 || y - i < 0 || board[y - i][x - i].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y - i][x - i].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y - t][x - t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnUp(int x, int y) {
      if (y > 1) {
  
        // となりの駒
        String next = board[y - 1][x];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (y - i < 0 || board[y - i][x].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y - i][x].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y - t][x] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnRightUp(int x, int y) {
      if (y > 1 && x < 6) {
  
        // となりの駒
        String next = board[y - 1][x + 1];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (x + i > 7 || y - i < 0 || board[y - i][x + i].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y - i][x + i].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y - t][x + t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnDown(int x, int y) {
      if (y < 6) {
  
        // となりの駒
        String next = board[y + 1][x];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (y + i > 7 || board[y + i][x].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y + i][x].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y + t][x] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnRight(int x, int y) {
      if (x < 6) {
  
        // となりの駒
        String next = board[y][x + 1];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (x + i > 7 || board[y][x + i].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y][x + i].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y][x + t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnLeftDown(int x, int y) {
      if (y < 6 && x > 1) {
  
        // となりの駒
        String next = board[y + 1][x - 1];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (x - i < 0 || y + i > 7 || board[y + i][x - i].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y + i][x - i].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y + t][x - t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnLeft(int x, int y) {
      if (x > 1) {
  
        // となりの駒
        String next = board[y][x - 1];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (x - i < 0 || board[y][x - i].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y][x - i].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y][x - t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
    static public void turnRightDown(int x, int y) {
      if (y < 6 && x < 6) {
  
        // となりの駒
        String next = board[y + 1][x + 1];
  
        // となりの駒が裏駒の場合
        if (next.equals(rev_stone)) {
  
          // さらにその一つとなりから順に確認
          for (int i = 2; true; i++) {
  
            if (x + i > 7 || y + i > 7 || board[y + i][x + i].equals(EMPTY)) {
              // 駒がない場合終了
              break;
            } else if (board[y + i][x + i].equals(stone)) {
              // 自駒の場合
  
              // あいだの駒をすべて自駒にひっくりかえす
              for (int t = 1; t < i; t++) {
                // 配列の要素を上書き
                board[y + t][x + t] = stone;
              }
              break;
            }
          }
        }
  
      }
    }
  
  }