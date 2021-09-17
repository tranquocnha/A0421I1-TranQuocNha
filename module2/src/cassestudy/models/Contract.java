package cassestudy.models;

public class Contract {
    private Booking booking;
    private int contractCode;
    private int  moneyPaid;
    private int  totalMoney;

    public Contract() {
    }

    public Contract(Booking booking, int contractCode, int moneyPaid, int totalMoney) {
        this.booking = booking;
        this.contractCode = contractCode;
        this.moneyPaid = moneyPaid;
        this.totalMoney = totalMoney;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getContractCode() {
        return contractCode;
    }

    public void setContractCode(int contractCode) {
        this.contractCode = contractCode;
    }

    public int getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(int moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
