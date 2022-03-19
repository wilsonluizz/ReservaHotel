package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int numero = teclado.nextInt();
			System.out.print("Data do Check-In: dd/MM/yyyy ");
			Date checkIn = sdf.parse(teclado.next());
			System.out.print("Data do Check-Out: dd/MM/yyyy ");
			Date checkOut = sdf.parse(teclado.next());

			Reserva reserva =  new Reserva(numero, checkIn, checkOut);
			System.out.println("Dados da reserva: " + reserva);

			System.out.println();
			System.out.println("Entre com as datas para atualizar a sua reserva: ");
			System.out.print("Data do Check-In: dd/MM/yyyy ");
			checkIn = sdf.parse(teclado.next());
			System.out.print("Data do Check-Out: dd/MM/yyyy ");
			checkOut = sdf.parse(teclado.next());

			reserva.updateDates(checkIn, checkOut);
			System.out.println("Dados da reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inv�lido.");
		}
		catch (DomainException e) {
			System.out.println(	e.getMessage());
		}
		
		catch(RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		

		teclado.close();

	}

}
