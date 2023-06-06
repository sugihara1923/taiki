import java.util.*;
class CalSample2 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println("年 "+c.get(Calendar.YEAR));
		System.out.println("月 "+(c.get(Calendar.MONTH)+1));
		System.out.println("日 "+c.get(Calendar.DATE));
		System.out.println("曜日 "+c.get(Calendar.DAY_OF_WEEK));
		System.out.println("時(12H) "+c.get(Calendar.HOUR));
		System.out.println("時(24H) "+c.get(Calendar.HOUR_OF_DAY));
		System.out.println("分 "+c.get(Calendar.MINUTE));
		System.out.println("秒 "+c.get(Calendar.SECOND));
	}
}
