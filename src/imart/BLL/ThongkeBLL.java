package imart.BLL;

import imart.DTO.Thongke;
import imart.DTO.ctHoaDon;
import imart.DTO.hoaDon;
import imart.DTO.khachHang;
import imart.DTO.loaiHang;
import imart.DTO.nhanVien;
import imart.DTO.sanPham;
import java.util.ArrayList;

/**
 *
 * @author Admin'
 */
public class ThongkeBLL {
    public ArrayList<Thongke> listtk=new ArrayList<>(); 
    public void addthongkesp(String dateS,String dateE,hoaDonBLL a,sanPhamBLL b,ctHoaDonBLL c,loaiHangBLL d,String loai){
        int check=0;
        
        for(hoaDon i:a.getHoaDonList()){
            if(a.CheckKhoangDay(dateS, dateE, i.getNgaylap()))
                for(ctHoaDon j:c.getCTHoaDonList()){
                    check=0;
                                
                    if(i.getId().equals(j.getMa_hd())){
                        System.out.println(j.getMa_sp());
                        for(Thongke k:listtk){
                            if(j.getMa_sp().equals(k.getID()))
                            {
                                
                                check=1;
                                k.setSoluong(k.getSoluong()+j.getSoluong());
                                k.setPrice(k.getPrice()+j.getThanhtien());
                                break;
                            }
                        }
                        if(check==0)
                            for(sanPham t:b.getSanPhamList())
                                if(t.getId().equals(j.getMa_sp())){
                                     System.out.println(t.getMa_loai());
                                    for(loaiHang v:d.list.getLoaiHang()){
                                        if(t.getMa_loai().equals(String.valueOf(v.getId()))){
                                            System.out.println("add::::"+j.getMa_sp());
                                            if(loai!="Loai")
                                            {
                                                if(loai.equals(v.getTen_loai()))
                                                    listtk.add(new Thongke(j.getMa_sp(),v.getTen_loai(),t.getTensp(),j.getSoluong(),j.getThanhtien()));
                                            }
                                            else 
                                            listtk.add(new Thongke(j.getMa_sp(),v.getTen_loai(),t.getTensp(),j.getSoluong(),j.getThanhtien()));
                                            break;
                                        }
                                    }
                                    break;
                                }
                    }
                }
            
        }
        System.out.println("  ");
        System.out.println("List::::"+listtk.size());
        System.out.println("  ");
    }
    public void addthongkenv(String dateS,String dateE,hoaDonBLL a,nhanVienBLL b,ctHoaDonBLL c){
        int check=0;
        int tong=0;
        for(hoaDon i:a.getHoaDonList()){
            if(a.CheckKhoangDay(dateS, dateE, i.getNgaylap())){
                tong=0;
               for(ctHoaDon t:c.getCTHoaDonList()){
                   if(i.getId().equals(t.getMa_hd())){
                       tong+=t.getSoluong();
                   }
               }
               
               for(nhanVien j:b.getNhanVienList()){
                   check=0;
                   if(i.getMa_nv().equals(j.getId()))
                   {
                       for(Thongke k:listtk){
                            if(k.getID().equals(j.getId()))
                            {
                                check=1;
                                k.setSoluong(k.getSoluong()+tong);
                                k.setPrice(k.getPrice()+i.getTongtien());
                                break;
                            }
                        }
                      if(check==0)
                      {
                          listtk.add(new Thongke(j.getId(),j.getHo(),j.getTen(),tong,i.getTongtien()));
                      }
                      break;
                   }
               }
            }
        }
    }
    public void addthongkekh(String dateS,String dateE,hoaDonBLL a,khachHangBLL b,ctHoaDonBLL c){
        int check=0;
        int tong=0;
        for(hoaDon i:a.getHoaDonList()){
            if(a.CheckKhoangDay(dateS, dateE, i.getNgaylap())){
                tong=0;
               for(ctHoaDon t:c.getCTHoaDonList()){
                   if(i.getId().equals(t.getMa_hd())){
                       tong+=t.getSoluong();
                   }
               }
               
               for(khachHang j:b.getKhachHangList()){
                   check=0;
                   if(i.getMa_kh().equals(j.getId()))
                   {
                       for(Thongke k:listtk){
                            if(k.getID().equals(j.getId()))
                            {
                                check=1;
                                k.setSoluong(k.getSoluong()+tong);
                                k.setPrice(k.getPrice()+i.getTongtien());
                                break;
                            }
                        }
                      if(check==0)
                      {
                          listtk.add(new Thongke(j.getId(),j.getHo(),j.getTen(),tong,i.getTongtien()));
                      }
                      break;
                   }
               }
            }
        }
    }
}
