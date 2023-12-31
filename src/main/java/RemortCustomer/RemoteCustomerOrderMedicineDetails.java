package RemortCustomer;

public class RemoteCustomerOrderMedicineDetails {


    private String orderID;
    private String name;
    private String address;
    private String phoneNo;
    private String DateTime;

    private Double price;

    public static String RCO_ID;

    public static String path;

    public RemoteCustomerOrderMedicineDetails(String orderID, String name, String address, String phoneNo, String dateTime, Double price) {
        this.orderID = orderID;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.DateTime = dateTime;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}
