package imart.DTO;

/**
 *
 * @author Admin'
 */
public class Thongke {
    private String id;
    private String ten;
    private String chuoi;
    private int slban;
    private double doanhthu;
    public Thongke(String id,String st,String ten,int slban,double doanhthuT){
        this.id=id;
        this.chuoi=st;
        this.ten=ten;
        this.slban=slban;
        this.doanhthu=doanhthuT;
    }
    public String getID(){
        return id;
    }
    public void setID(String id){
        this.id=id;
    }
    public String getChuoi(){
        return chuoi;
    }
    public void setChuoi(String st){
        this.chuoi=st;
    }
    public String getTen(){
        return ten;
    }
    public void setTen(String ten){
        this.ten=ten;
    }
    public int getSoluong(){
        return slban;
    }
    public void setSoluong(int sluong){
        this.slban=sluong;
    }
    public double getPrice(){
        return doanhthu;
    }
    public void setPrice(double price){
        this.doanhthu=price;
    }
    
}
