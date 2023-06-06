import java.io.*;
class Load {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("sample.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			System.out.println(str);
			br.close();
			fr.close();
		}
		catch(IOException e) {
			System.out.println("ファイルが読み込めません");
		}
	}
}
