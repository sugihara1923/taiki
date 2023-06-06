import java.util.*;
import java.text.*;
class DateSample2 {
	public static void main(String[] args) {
		Date d = new Date();
		DateFormat dformat;

		dformat = DateFormat.getDateInstance();
		String dat = dformat.format(d);
		System.out.println("日付を取り出す "+dat);

		dformat = DateFormat.getTimeInstance();
		String tim = dformat.format(d);
		System.out.println("時間を取り出す "+tim);

		dformat = DateFormat.getDateTimeInstance();
		String dt = dformat.format(d);
		System.out.println("日付と時間を取り出す "+dt);
	}
}
