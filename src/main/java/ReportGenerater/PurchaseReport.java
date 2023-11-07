package ReportGenerater;

public class PurchaseReport {
    private String PRID;
    private String PRDnT;
    private int PRQuantity;
    private String PRSupplierID;
    private double PRAmount;

    public PurchaseReport(String PRID, String PRDnT, int PRQuantity, String PRSupplierID, double PRAmount) {
        this.PRID = PRID;
        this.PRDnT = PRDnT;
        this.PRQuantity = PRQuantity;
        this.PRSupplierID = PRSupplierID;
        this.PRAmount = PRAmount;
    }

    public String getPRID() {
        return PRID;
    }

    public void setPRID(String PRID) {
        this.PRID = PRID;
    }

    public String getPRDnT() {
        return PRDnT;
    }

    public void setPRDnT(String PRDnT) {
        this.PRDnT = PRDnT;
    }

    public int getPRQuantity() {
        return PRQuantity;
    }

    public void setPRQuantity(int PRQuantity) {
        this.PRQuantity = PRQuantity;
    }

    public String getPRSupplierID() {
        return PRSupplierID;
    }

    public void setPRSupplierID(String PRSupplierID) {
        this.PRSupplierID = PRSupplierID;
    }

    public double getPRAmount() {
        return PRAmount;
    }

    public void setPRAmount(double PRAmount) {
        this.PRAmount = PRAmount;
    }
}
