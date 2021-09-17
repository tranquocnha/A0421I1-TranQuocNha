package cassestudy.services.Impl;

import cassestudy.models.Facility;
import cassestudy.models.House;
import cassestudy.models.Room;
import cassestudy.models.Villa;
import cassestudy.services.FacilityService;
import cassestudy.utils.RegexData;
import cassestudy.utils.Validation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    public static final String REGEX_STR ="[A-z][a-z]+";
    public static final String REGEX_VILLA_ID = "(SVVL)[-][0-9]{4}";
    public static final String REGEX_HOUSE_ID = "(SVHO)[-][0-9]{4}";
    public static final String REGEX_ROOM_ID = "(SVRO)[-][0-9]{4}";
    public static final String REGEX_MAX_CUSTOMER = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^[3-9]\\d[1-9]\\d{2,})$";

    public static Map<Facility,Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);



    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element: facilityIntegerMap.entrySet()){
            System.out.println("Service " + element.getKey() + "So lan da thuc hien: " + element.getValue());
        }
    }

    @Override
    public void displayMaintain() {

    }

    @Override
    public void addNewVilla() {
        System.out.println("Nhap id: ");
        String id = scanner.nextLine();
        String service = scanner.nextLine();
//        System.out.println("Nhap dich vu: ");
//        String service = scanner.nextLine();
        System.out.println("Nhap phong da thue ");
        Double usedArea= Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap gia cho thue ");
        Float rentPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhap loai tien: ");
        int rentType = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap tieu chuan phong: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Mo ta tien ich: ");
        String utilityDescription = scanner.nextLine();
        System.out.println("Nhap dien tich ho boi: ");
        Double poolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap so tang: ");
        int floors = Integer.parseInt(inputTotalPay());
         Villa villa = new Villa(id,usedArea,rentPrice,rentType,roomStandard,utilityDescription,poolArea,floors);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Them thanh cong");
    }

    private String inputTotalPay() {
        System.out.println("Nhap dien tich: ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT, "Ban da nhap sai dinh dang, so tien phai la so duong");
    }

    @Override
    public void addNewHouse() {
        String houseId;
        do {
            System.out.println("Enter House service id: ");
            houseId = inputHouseId();
            if (checkExist(houseId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(houseId) != null);
        System.out.println("Enter House name: ");
        String name = inputServiceName();
        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(inputArea());
        System.out.println("Enter rent cost: ");
        float rentCost = Float.parseFloat(inputInt());
        System.out.println("Enter max customer: ");
        int maxCustomer = Integer.parseInt(inputMaxCustomer());
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter standard: ");
        String standard = scanner.nextLine();
        System.out.println("Enter floor number: ");
        int floorNumber = Integer.parseInt(inputInt());
        facilityIntegerMap.put(new House(houseId,name,usableArea,rentCost,maxCustomer,rentType,standard,floorNumber), 0);
        System.out.println("Add success!");
    }

    private Object checkExist(String houseId) {
        for (Map.Entry<Facility, Integer> facility : facilityIntegerMap.entrySet()) {
            if (houseId.equals(facility.getKey().getServiceId())) {
                return facility.getKey();
            }
        }
        return null;
    }

    @Override
    public void addNewRoom() {
        String roomId;
        do {
            System.out.println("Enter Room service id: ");
            roomId = inputRoomId();
            if (checkExist(roomId) != null) {
                System.out.println("Id service existed!");
            }
        } while (checkExist(roomId) != null);
        System.out.println("Enter Room name: ");
        String name = inputServiceName();
        System.out.println("Enter usable area: ");
        double usableArea = Double.parseDouble(inputArea());
        System.out.println("Enter rent cost: ");
        float rentCost = Float.parseFloat(inputInt());
        System.out.println("Enter max customer: ");
        int maxCustomer = Integer.parseInt(inputMaxCustomer());
        System.out.println("Enter rent type: ");
        String rentType = scanner.nextLine();
        System.out.println("Enter free service: ");
        String freeService = scanner.nextLine();
        facilityIntegerMap.put(new Room(roomId, name, usableArea, rentCost, maxCustomer, rentType, freeService), 0);
        System.out.println("Add success!");
    }
    private String inputVillaId() {
        return Validation.checkInput(scanner.nextLine(), REGEX_VILLA_ID, "Invalid format, id must be: SVVL-XXXX!");
    }

    private String inputHouseId() {
        return Validation.checkInput(scanner.nextLine(), REGEX_HOUSE_ID, "Invalid format, id must be: SVHO-XXXX!");
    }

    private String inputRoomId() {
        return Validation.checkInput(scanner.nextLine(), REGEX_ROOM_ID, "Invalid format, id must be: SVRO-XXXX!");
    }

    private String inputServiceName() {
        return Validation.checkInput(scanner.nextLine(), REGEX_STR, "Invalid format, service name must be a String with uppercase character!");
    }

    private String inputArea() {
        return Validation.checkInput(scanner.nextLine(), REGEX_AREA, "Invalid format, area must be greater than 30!");
    }

    private String inputInt() {
        return Validation.checkInput(scanner.nextLine(), REGEX_INT, "Invalid format, cost must be a number greater than 0!");
    }

    private String inputMaxCustomer() {
        return Validation.checkInput(scanner.nextLine(), REGEX_MAX_CUSTOMER, "Invalid format, id must be greater than 0 and less than 20!");
    }
}
