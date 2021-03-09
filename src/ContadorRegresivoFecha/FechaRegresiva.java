package ContadorRegresivoFecha;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FechaRegresiva
{

	public static void main(String[] args)
	{
		Scanner teclado = new Scanner(System.in);
		String fechaProbable = "", fechaVacaciones = "", anyoCalendario = "";
		Date ahora, fechaInicial, fechaFinal;
		//fechaFinal=28/03/2021;
		
		do
		{
		//System.out.println("Dame tu fecha de nacimiento (dd/mm/aaaa):");
		fechaVacaciones = "28/03/2021";
		}while(!validarFecha(fechaVacaciones));
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaVacaciones, fmt);
		LocalDate esteInstante = LocalDate.now();
		Period periodo = Period.between(esteInstante,fechaNac);
		System.out.printf("Quedan: %s días para vacasione",
				 periodo.getDays());
		System.out.println();
		// Mostrar días entre dos fechas dadas comprobando que fecha 1 < fecha 2
		// Si no, mostrar error

	}
	public static boolean validarFecha(String fecha)
	{
		try
		{
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(fecha);
		}
		catch (ParseException e)
		{
			return false;
		}
		return true;
	}

}


