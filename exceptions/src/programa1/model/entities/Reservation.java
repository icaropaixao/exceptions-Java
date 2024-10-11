package programa1.model.entities;

import programa1.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    // formato de como as datas vão ser exibidas
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // construtores
    public Reservation(){

    }
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
        if (!checkOut.after(checkIn)){
            // outra excepetion
            throw new DomainException("Erro: as datas de reservas para atualizarção devem ser datas futuras!") ;
        }

        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    // gets e sets
    public Integer getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }

    // methods
    // metodo para calcular a duração das datas
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();

        // converter segundos para dias
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    // alterar as datas
    public void updateDates(Date checkIn, Date checkOut) throws DomainException{

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)){
            // lançando excepetion caso a acondição seja verdadeira
            throw new DomainException("Erro: as datas de reservas para atualização devem ser datas futuras!") ;
        }
         if (!checkOut.after(checkIn)){
             // outra excepetion
            throw new DomainException("Erro: as datas de reservas para atualização devem ser datas futuras!") ;
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }

    // fazer fomatação para exibir os dados
    @Override
    public  String toString(){
         return "Quarto: "
                 + roomNumber
                 + ", Check in: "
                 + sdf.format(checkIn)
                 + ", Checkout: "
                 + sdf.format(checkOut)
                 + ", duração: "
                 + duration()
                 + " noites.";
    }

}
