import java.io.*;
class Save {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("test.txt");
			fw.write("文字列をテキストファイルに書き込みました");
			fw.close();
		}
		catch(IOException e) {
			System.out.println("ファイルが書き込めません");
		}
	}
}
