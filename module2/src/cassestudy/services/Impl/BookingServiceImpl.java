package cassestudy.services.Impl;

import cassestudy.data.ReadAndWrite;
import cassestudy.models.Booking;
import cassestudy.models.Customer;
import cassestudy.models.Facility;
import cassestudy.services.BookingService;
import cassestudy.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    static List<Customer> customerList = new ArrayList<>();
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void disPlayListBooking() {
        ReadAndWrite.read("D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\booking.csv");
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    @Override
    public void addBooking() {
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.println("Nhap id: ");
        int id1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Ngay bat dau thue: ");
        String arrivalDate = scanner.nextLine();
        System.out.println("Nhap ngay tra phong: ");
        String lastDay = scanner.nextLine();
        Booking booking = new Booking(id1,arrivalDate,lastDay,customer,facility);
        bookingSet.add(booking);
        System.out.println("Da booking thanh cong!");
        ReadAndWrite.write(bookingSet, "D:\\A0421I1_Tran_Quoc_Nha\\module1\\module2\\src\\cassestudy\\data\\booking.csv");
    }

    public static Customer chooseCustomer() {
        System.out.println("Danh sach khach hang: ");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.println("Nhap id: ");
        boolean check = true;
        String customerCode = "";
        try {
            customerCode = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Sai id, nhap lai !");
        }
        while (check) {
            for (Customer customer : customerList) {
                if (customer.getId().equals(customerCode)) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("Nhap id khach hang: ");
                try {
                    customerCode = scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Sai id, nhap lai ");
                }
            }
        }
        return null;
    }
    public static Facility chooseFacility(String service) {
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (service.equals(entry.getKey().getServiceId())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static Customer chooseCustomer(String customerCode) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(customerCode)) {
                return customer;
            }
        }
        return null;
    }
    public static Facility chooseFacility() {
        System.out.println("Danh sach dich vu ");
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println("Nhap lai id dich vu");
        boolean check = true;

        String serviceName = scanner.nextLine();
        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                if (serviceName.equals(entry.getKey().getServiceId())) {
                    check = false;
                    return entry.getKey();
                }
            }
            if (check) {
                System.out.println("Ban da nhap sai, nhap lai id dich vu");
                serviceName = scanner.nextLine();
            }
        }
        return null;
    }
    @Override
    public void editBooking() {

    }

    public static Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public static void setBookingSet(Set<Booking> bookingSet) {
        BookingServiceImpl.bookingSet = bookingSet;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        BookingServiceImpl.customerList = customerList;
    }

    public static Map<Facility, Integer> getFacilityIntegerMap() {
        return facilityIntegerMap;
    }

    public static void setFacilityIntegerMap(Map<Facility, Integer> facilityIntegerMap) {
        BookingServiceImpl.facilityIntegerMap = facilityIntegerMap;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        BookingServiceImpl.scanner = scanner;
    }
}
