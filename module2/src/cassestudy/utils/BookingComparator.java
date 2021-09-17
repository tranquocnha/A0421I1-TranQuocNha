package cassestudy.utils;

import cassestudy.models.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startdate1 = LocalDate.parse(o1.getArrivalDate(),formatter);
        LocalDate startdate2 = LocalDate.parse(o2.getArrivalDate(),formatter);
        LocalDate endday1 = LocalDate.parse(o1.getLastDay(),formatter);
        LocalDate endday2 = LocalDate.parse(o1.getLastDay(),formatter);

        if (startdate1.compareTo(startdate2)>0){
            return 1;
        }else if (startdate1.compareTo(startdate2)<0){
            return -1;
        }else {
            if (endday1.compareTo(endday2)>0){
                return -1;
            }else if (endday1.compareTo(endday2) <0){
                return -1;
            }else {
                return 0;
            }
        }
    }
}
