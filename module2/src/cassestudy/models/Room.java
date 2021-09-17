package cassestudy.models;

public class Room extends Facility {
    private String extraService;

    public Room() {
    }

    public Room(String extraService) {
        this.extraService = extraService;
    }

    public Room(String serviceId, String serviceName, double usableArea, float rentCost, int maxCustomer, String rentType, String extraService) {
        super(serviceId, serviceName, usableArea, rentCost, maxCustomer, rentType);
        this.extraService = extraService;
    }

    public String getExtraService() {
        return extraService;
    }

    public void setExtraService(String extraService) {
        this.extraService = extraService;
    }
}
