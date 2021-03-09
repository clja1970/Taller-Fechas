package es.studium.TallerFechaHora;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TallerFechaHora
{

	public static void main(String[] args)
	{
		Date ahora;
		SimpleDateFormat formateador;
		//Mostrar la fecha actual
		ahora=new Date();
		System.out.println("Fecha original: "+ahora);
		//Formateando la fecha
		formateador = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Fecha formato europeo:"+ formateador.format(ahora));
		//Formateando la hora hasta milisegundos
		formateador = new SimpleDateFormat("HH:mm:ss:S");
		System.out.println("Hora con milisegundos: "+formateador.format(ahora));

	}

}
