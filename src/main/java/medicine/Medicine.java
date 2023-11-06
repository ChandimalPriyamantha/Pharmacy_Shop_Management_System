package medicine;

public class Medicine {
    private String medicineID;
    private String medicineName;
    private int medicineQuantity;
    private String medicineManufacturer;
    private String medicinePrice;
    private double medicineExpireDate;


    public Medicine(String medicineID, String medicineName, int medicineQuantity, String medicineManufacturer, String medicinePrice, double medicineExpireDate) {
        this.medicineID = medicineID;
        this.medicineName = medicineName;
        this.medicineQuantity = medicineQuantity;
        this.medicineManufacturer = medicineManufacturer;
        this.medicinePrice = medicinePrice;
        this.medicineExpireDate = medicineExpireDate;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(int medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public String getMedicineManufacturer() {
        return medicineManufacturer;
    }

    public void setMedicineManufacturer(String medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }


    public double getMedicineExpireDate() {
        return medicineExpireDate;
    }

    public void setMedicineExpireDate(double medicineExpireDate) {
        this.medicineExpireDate = medicineExpireDate;
    }
}
