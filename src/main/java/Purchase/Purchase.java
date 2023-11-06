package Purchase;


public class Purchase {
    private String ppsupplierIDtxt;
    private String ppName = null;
    private String ppCmpnyRegNo = null;
    private String ppContactNo = null;
    private String ppAddress = null;

    private String medicineID;
    private String MediName;

    private  int quantity;

    public Purchase(String MedicineID, String Name, int quantity) {
        this.medicineID=MedicineID;
        this.MediName=Name;
        this.quantity=quantity;


    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    public String getPpsupplierIDtxt() {
        return ppsupplierIDtxt;
    }

    public void setPpsupplierIDtxt(String ppsupplierIDtxt) {
        this.ppsupplierIDtxt = ppsupplierIDtxt;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public String getPpCmpnyRegNo() {
        return ppCmpnyRegNo;
    }

    public void setPpCmpnyRegNo(String ppCmpnyRegNo) {
        this.ppCmpnyRegNo = ppCmpnyRegNo;
    }

    public String getPpContactNo() {
        return ppContactNo;
    }

    public void setPpContactNo(String ppContactNo) {
        this.ppContactNo = ppContactNo;
    }

    public String getPpAddress() {
        return ppAddress;
    }

    public void setPpAddress(String ppAddress) {
        this.ppAddress = ppAddress;
    }





    }







