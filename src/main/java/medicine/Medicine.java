package medicine;

public class Medicine {


    private String medicineID;
    private  String name;
    private  int quantity;
    private String manufacture;

    private  String expireDate;

    private  Double price;

    public Medicine(String medicineID, String name, int quantity, String manufacture, String expireDate, Double price) {
        this.medicineID = medicineID;
        this.name = name;
        this.quantity = quantity;
        this.manufacture = manufacture;
        this.expireDate = expireDate;
        this.price = price;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
