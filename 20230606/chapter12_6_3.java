import java.time.*;
class JavaTime3 {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println(ld.getYear()+"/"+ld.getMonthValue()+"/"+ld.getDayOfMonth());
		System.out.println(ld.getMonth());
		System.out.println(ld.getDayOfWeek());
	}
}
