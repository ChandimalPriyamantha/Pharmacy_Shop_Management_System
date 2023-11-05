package RemortCustomer;

public class RemoteCustomerOrderShippingDetails {


    private String RCOID;
    private String medicineID;

    private  String quantity;

    private String medicineName;

    private Double price;

    public RemoteCustomerOrderShippingDetails(String RCOID, String medicineID, String quantity, String medicineName, Double price) {
        this.RCOID = RCOID;
        this.medicineID = medicineID;
        this.quantity = quantity;
        this.medicineName = medicineName;
        this.price = price;
    }

    public String getRCOID() {
        return RCOID;
    }

    public void setRCOID(String RCOID) {
        this.RCOID = RCOID;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
