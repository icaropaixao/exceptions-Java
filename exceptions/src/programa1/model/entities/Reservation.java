package programa1.model.entities;

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
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
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
    public void updateDates(Date checkIn, Date checkOut){

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // fazer fomatação para exibir os dados
    @Override
    public  String toString(){
         return "Room"
                 + roomNumber
                 + sdf.format(checkIn)
                 + ", Checkout"
                 + sdf.format(checkOut)
                 + ", duration"
                 + duration()
                 + "nights";
    }

}
