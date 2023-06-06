import java.io.*;
class Load2 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("sample2.txt");
			BufferedReader br = new BufferedReader(fr);
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				System.out.println(str);
			}
			br.close();
			fr.close();
		}
		catch(IOException e) {
			System.out.println("ファイルが読み込めません");
		}
	}
}
