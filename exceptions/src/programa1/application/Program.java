package programa1.application;

import programa1.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
s
public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int number = sc.nextInt();

        System.out.print("Data do Check-in: (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("Data do Check-Out: (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        // testando se a data de check-out é depois do check-in
        if (!checkOut.after(checkIn)) {
            System.out.print("Erro. A data de check-out não pode ser posterior a data de check-in ");
        }
        else {
            Reservation reservation = new Reservation(number,checkIn,checkOut);
            System.out.println("Reserva: " + reservation);

            System.out.println();

            // update reserva
            System.out.println("Dados para atualizar a reserva");

            System.out.print("Nova Data do Check-in: (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Nova Data do Check-Out: (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            // regra para atualizar as novas datas
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Erro: as datas de reservas para atualização devem ser datas futuras!");
            }
            else if (!checkOut.after(checkIn)){
                System.out.println("Erro: as datas de reservas para atualizarção devem ser datas futuras!");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reserva: " + reservation);
            }

        }

        sc.close();
    }
}
