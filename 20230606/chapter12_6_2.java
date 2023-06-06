import java.time.*;
class JavaTime2 {
	public static void main(String[] args) {
		LocalTime lt = LocalTime.now();
		System.out.println(lt.getHour()+":"+lt.getMinute()+":"+lt.getSecond());
	}
}
