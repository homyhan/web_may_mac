package model;

public class InformationDeliverModel {
    int id, idOrder;
    String districtTo, warTo;
    public InformationDeliverModel(int id, int idOrder, String districtTo, String warTo) {
        this.id = id;
        this.idOrder = idOrder;
        this.districtTo = districtTo;
        this.warTo = warTo;
    }
    public InformationDeliverModel() {
    }
    public InformationDeliverModel(int idOrder, String districtTo, String warTo) {
        this.idOrder = idOrder;
        this.districtTo = districtTo;
        this.warTo = warTo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    public String getDistrictTo() {
        return districtTo;
    }
    public void setDistrictTo(String districtTo) {
        this.districtTo = districtTo;
    }
    public String getWarTo() {
        return warTo;
    }
    public void setWarTo(String warTo) {
        this.warTo = warTo;
    }
}