package cassestudy.models;

import java.io.Serializable;

public class Booking implements Serializable {
    private int idBooking;
    private String arrivalDate;
    private String lastDay;
    private int idCustomer;
    private String nameService;
    private String typeService;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(int idBooking, String arrivalDate, String lastDay, int idCustomer, String nameService, String typeService) {
        this.idBooking = idBooking;
        this.arrivalDate = arrivalDate;
        this.lastDay = lastDay;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public Booking(int idBooking, String arrivalDate, String lastDay, int idCustomer, String nameService, String typeService, Customer customer, Facility facility) {
        this.idBooking = idBooking;
        this.arrivalDate = arrivalDate;
        this.lastDay = lastDay;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
        this.customer = customer;
        this.facility = facility;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getLastDay() {
        return lastDay;
    }

    public void setLastDay(String lastDay) {
        this.lastDay = lastDay;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
