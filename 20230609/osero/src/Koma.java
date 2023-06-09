public class Koma{
    private String state; // オセロの色が黒…B、白…W、空…E
    private int x;
    private int y;

    public Koma(int x,int y){
        this.state = "E";
        this.x = x;
        this.y = y;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public int[] getPosition(){
        int[]pos = {this.x, this.y};
        return pos;
    }
}

