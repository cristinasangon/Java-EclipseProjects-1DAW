package listas;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EstudioFechas {

	public EstudioFechas() {
			//FECHA
			LocalDate fecha = LocalDate.now();
			System.out.println(fecha);
			
			//DIA, MES Y AÑO
			System.out.println(fecha.getYear());
			System.out.println(fecha.getMonthValue());
			System.out.println(fecha.getDayOfMonth());
			
			//CONVERTIR FECHAS
			try {
				fecha = LocalDate.of(2003, 12, 13);
				System.out.println(fecha);
				
				LocalDate fecha2 = LocalDate.parse("2020-02-29");
				System.out.println(fecha2);
				
				DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyy/M/d");
				LocalDate fecha3 = LocalDate.parse("2020/2/29", FORMATTER);
				System.out.println(fecha3);
				
			} catch (DateTimeException e) {
				System.out.println(e.getMessage());
			}
			
			//FECHA Y HORA
			LocalDateTime fecha_y_hora = LocalDateTime.now();
			System.out.println(fecha_y_hora);
			
			fecha_y_hora = LocalDateTime.of(2022, 10, 15, 15, 30);
			System.out.println(fecha_y_hora);
			
			fecha_y_hora = LocalDateTime.of(LocalDate.now(), LocalTime.now());
			System.out.println(fecha_y_hora);
			
	}

}
