import java.io.*;
class Save2 {
	public static void main(String[] args) {
		String kaigyo = System.getProperty("line.separator");
		FileWriter fw = null;
		try {
			fw = new FileWriter("test2.txt");
			for(int i=1; i<=100; i++) {
				fw.write(""+i+"行目の書き込み");
				fw.write(kaigyo);
			}
			fw.flush();
		}
		catch(IOException e) {
			System.out.println("ファイルが書き込めません");
		}
		finally {
			if(fw != null) {
				try { fw.close(); } catch(IOException e) {}
			}
		}
	}
}
