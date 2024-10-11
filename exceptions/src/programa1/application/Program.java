package programa1.application;

import programa1.model.entities.Reservation;
import programa1.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            System.out.print("Número do quarto: ");
            int number = sc.nextInt();
            System.out.print("Data do Check-in: (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data do Check-Out: (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number,checkIn,checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println();
            // update reserva
            System.out.println("Dados para atualizar a reserva");

            System.out.print("Nova Data do Check-in: (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Nova Data do Check-Out: (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        // possiveis erros e correção
        catch (ParseException erro){
            System.out.println("Data invalida.");
        }
        catch (DomainException erro ){
            System.out.println("Erro na reserva " + erro.getMessage());
        }
        catch (InputMismatchException erro){
            System.out.println("Erro, Digite apenas números");
        }

        sc.close();

        }
    }


