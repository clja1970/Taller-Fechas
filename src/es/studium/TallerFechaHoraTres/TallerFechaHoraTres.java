package es.studium.TallerFechaHoraTres;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
public class TallerFechaHoraTres
{
	public static void main(String[] args)
	{
		Scanner teclado = new Scanner(System.in);
		String fechaProbable = "", fechaNacimiento = "";
		Date ahora;
		SimpleDateFormat formateador;
		// Mostrar fecha actual tal cual
		ahora = new Date();
		System.out.println("Fecha original: " + ahora);
		// Formateando la fecha
		formateador = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println ("Fecha formato europeo: " + formateador.format(ahora));
		// Formateando la hora hasta milisegundos
		formateador = new SimpleDateFormat("HH:mm:ss.S");
		System.out.println ("Hora con milisegundos: " + formateador.format(ahora));
		// Validar mediante función si la fecha introducida por teclado es correcta o no
		// Seguir pidiendo hasta fecha correcta...
		do
		{
			System.out.println("Escribe una fecha correcta (dd/mm/aaaa):");
			fechaProbable = teclado.next();
		}while(!validarFecha(fechaProbable));
		System.out.println("Fecha CORRECTA!");
		// Dada una fecha de nacimiento, calcular cuántos años, meses, días tienes
		do
			
			{
			System.out.println("Dame tu fecha de nacimiento (dd/mm/aaaa):");
			fechaNacimiento = teclado.next();
			}while(!validarFecha(fechaNacimiento));
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate esteInstante = LocalDate.now();
		Period periodo = Period.between(fechaNac, esteInstante);
		System.out.printf("Tu edad es: %s años, %s meses y %s días",
				periodo.getYears(), periodo.getMonths(), periodo.getDays());
		System.out.println();
		teclado.close();
	}
	public static boolean validarFecha(String fecha)
	{
		try
		{
			SimpleDateFormat formatoFecha = new
					SimpleDateFormat("dd/MM/yyyy");
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
