package medicine;

public class Medicine {
    private String medicineID;
    private String medicineName;
    private String medicineQuantity;
    private String medicineManufacturer;
    private String medicinePrice;
    private String medicineExpireDate;


    public Medicine(String medicineID, String medicineName, String medicineQuantity, String medicineManufacturer, String medicinePrice, String medicineExpireDate) {
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

    public String getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(String medicineQuantity) {
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


    public String getMedicineExpireDate() {
        return medicineExpireDate;
    }

    public void setMedicineExpireDate(String medicineExpireDate) {
        this.medicineExpireDate = medicineExpireDate;
    }
}
