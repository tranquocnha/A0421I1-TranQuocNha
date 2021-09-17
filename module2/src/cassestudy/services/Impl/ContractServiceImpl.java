package cassestudy.services.Impl;

import cassestudy.data.ReadAndWrite;
import cassestudy.models.Booking;
import cassestudy.models.Contract;
import cassestudy.models.Customer;
import cassestudy.services.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void addNewContracts() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().getBookingSet();
        bookingQueue.addAll(bookingSet);
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();
            System.out.println("Tao hop dong cho: " + booking);
            System.out.println("Dang tao hop dong cho Booking co thong tin: " + booking.toString());
            System.out.println("Dang tao hop dong cho Booking co thong tin: " + customer.toString());
            System.out.println("Nhap ma hop dong: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("So tien tra truoc: ");
            int moneyPaid = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhap tong chi phi: ");
            int totalMoney = Integer.parseInt(scanner.nextLine());

            Contract contract = new Contract(booking, id, moneyPaid, totalMoney);
            contractList.add(contract);
            System.out.println("Da tao hop dong thanh cong: " + contract.toString());
            ReadAndWrite.write(contractList, "src\\casestudy\\data\\contract.csv");
        }
    }

    @Override
    public void displayListContracts() {

    }
    @Override
    public void editContracts() {

    }
}
