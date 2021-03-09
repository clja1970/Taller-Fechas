package es.studium.CalendarioGregoriano;

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
public class CalendarioGregoriano
{
public static void main(String[] args)
{
Scanner teclado = new Scanner(System.in);
String fechaProbable = "", fechaNacimiento = "", anyoCalendario = "";
Date ahora, fechaInicial, fechaFinal;
int numColumnas;
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
// Mostrar días entre dos fechas dadas comprobando que fecha 1 < fecha 2
// Si no, mostrar error
try
{
formateador = new SimpleDateFormat("dd/MM/yyyy");
do
{
System.out.println("Dame una primera fecha (dd/mm/aaaa):");
fechaProbable = teclado.next();
}while(!validarFecha(fechaNacimiento));
fechaInicial = formateador.parse(fechaProbable);
do
{
System.out.println("Dame una segunda fecha (dd/mm/aaaa):");
fechaProbable = teclado.next();
}while(!validarFecha(fechaNacimiento));
fechaFinal=formateador.parse(fechaProbable);
int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
System.out.println("Hay "+dias+" días de diferencia");
}
catch (ParseException e)
{
e.printStackTrace();
}
// Obtener un calendario anual dando el año
System.out.println("Dame el año del calendario:");
anyoCalendario = teclado.next();
System.out.println("Dame el número de columnas para el calendario:");
numColumnas = teclado.nextInt();
imprimirCalendario(Integer.parseInt(anyoCalendario), numColumnas);
teclado.close();


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
public static void imprimirCalendario(int year, int nCols)
{
if (nCols < 1 || nCols > 12)
throw new IllegalArgumentException("Numero de columnas incorrecto!!");
Calendar date = new GregorianCalendar(year, 0, 1);
int nRows = (int) Math.ceil(12.0 / nCols);
int offs = date.get(Calendar.DAY_OF_WEEK) - 2;
int w = nCols * 24;
String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
String[][] mons = new String[12][8];
for (int m = 0; m < 12; m++)
{
String name = monthNames[m];
int len = 11 + name.length() / 2;
String format = MessageFormat.format("%{0}s%{1}s", len, 21 - len);
mons[m][0] = String.format(format, name, "");
mons[m][1] = " Lu Ma Mi Ju Vi Sa Do";
int dim = date.getActualMaximum(Calendar.DAY_OF_MONTH);
for (int d = 1; d < 43; d++) 

{
boolean isDay = d > offs && d <= offs + dim;
String entry = isDay ? String.format(" %2s", d - offs) : " ";
if (d % 7 == 1)
mons[m][2 + (d - 1) / 7] = entry;
else
mons[m][2 + (d - 1) / 7] += entry;
}
offs = (offs + dim) % 7;
date.add(Calendar.MONTH, 1);
}
System.out.printf("%" + (w / 2 + 10) + "s%n", "[[ Calendario ]]");
System.out.printf("%" + (w / 2 + 4) + "s%n%n", year);
for (int r = 0; r < nRows; r++)
{
for (int i = 0; i < 8; i++)
{
for (int c = r * nCols; c < (r + 1) * nCols && c < 12; c++)
System.out.printf(" %s", mons[c][i]);
System.out.println();
}
System.out.println();
}
}
}