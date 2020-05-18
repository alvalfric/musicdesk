package aiss.model.resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class MainTest {
	public static void main(String[] args) {
		Locale spanish = new Locale("es", "ES");
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", spanish);
		LocalDateTime date = LocalDateTime.parse("2020-05-18T10:48:49Z", inputFormatter);
		System.out.println(LocalDateTime.now().compareTo(date));

		if (LocalDateTime.now().getYear() > date.getYear()) {
			System.out.println("Hace" + (LocalDateTime.now().getYear() - date.getYear()) + "año");
		} else if (LocalDateTime.now().getDayOfYear() - date.getDayOfYear() >= 7 * 4) {
			System.out.println("Hace 4 semanas");
		} else if (LocalDateTime.now().getDayOfYear() - date.getDayOfYear() >= 7 * 3) {
			System.out.println("Hace 3 semanas");
		} else if (LocalDateTime.now().getDayOfYear() - date.getDayOfYear() >= 7 * 2) {
			System.out.println("Hace 2 semanas");
		} else if (LocalDateTime.now().getDayOfYear() - date.getDayOfYear() >= 7 * 1) {
			System.out.println("Hace 1 semana");
		} else if (LocalDateTime.now().getDayOfYear() == date.getDayOfYear()) {
			if (LocalDateTime.now().getHour() - date.getHour() > 1) {
				System.out.println("Hace " + (LocalDateTime.now().getHour() - date.getHour()) + " horas");
			} else if (LocalDateTime.now().getHour() - date.getHour() == 1
					&& LocalDateTime.now().getMinute() - date.getMinute() >= 0) {
				System.out.println("Hace 1 hora");
			} else {
				if (LocalDateTime.now().getMinute() - date.getMinute() < 60) {
					System.out.println("Hace " + (LocalDateTime.now().getMinute() - date.getMinute()) + " minutos");
				}
			}

			System.out.println(date.format(DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy, HH:mm", spanish)));
		}
	}
}