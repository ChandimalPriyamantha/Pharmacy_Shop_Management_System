package ReportGenerater;

public class ReportCreator {
    private String saleID;
    private String saleDate;
    private int saleQuantity;
    private double saleAmount;

    private String saleType;

    public ReportCreator(String saleID, String saleDate, int saleQuantity, double saleAmount, String saleType) {
        this.saleID = saleID;
        this.saleDate = saleDate;
        this.saleQuantity = saleQuantity;
        this.saleAmount = saleAmount;
        this.saleType = saleType;
    }

    public String getSaleID() {
        return saleID;
    }

    public void setSaleID(String saleID) {
        this.saleID = saleID;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }
}
