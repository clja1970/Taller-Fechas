package es.studium.TallerFechaHoraDos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class TallerFechasDos
{
public static void main(String[] args)
{
Scanner teclado = new Scanner(System.in);
String fechaProbable = "";
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
teclado.close();
}

public static boolean validarFecha(String fecha)
{
try
{
SimpleDateFormat formatoFecha = new
SimpleDateFormat("dd/MM/yyyy");
//setLenient no permisivo, no permite fechas incorrectas
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