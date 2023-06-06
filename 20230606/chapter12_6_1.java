import java.time.*;
class JavaTime {
	public static void main(String[] args) {
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);

		LocalDate ld = LocalDate.now();
		System.out.println(ld);

		LocalTime lt = LocalTime.now();
		System.out.println(lt);
	}
}
