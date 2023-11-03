package SalesTransaction;

public class MedicineData {
    private String medicineID;
    private String name;
    private int quantity;
    private double price;

    public MedicineData(String medicineID, String name, int quantity, double price) {
        this.medicineID = medicineID;
        this.name = name;
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

