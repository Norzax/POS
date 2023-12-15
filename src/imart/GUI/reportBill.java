/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imart.GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import imart.BLL.ctHoaDonBLL;
import imart.BLL.hoaDonBLL;
import imart.BLL.nhanVienBLL;
import imart.BLL.sanPhamBLL;
import imart.DAO.connect;
import java.awt.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class reportBill {
    ctHoaDonBLL cthdbll= new ctHoaDonBLL();
    hoaDonBLL hdbll= new hoaDonBLL();
    sanPhamBLL spbll= new sanPhamBLL();
    nhanVienBLL nvbll= new nhanVienBLL();
    
    private BaseFont bf;
    connect conn= new connect();

    public reportBill (){
        cthdbll.getList();
    }

//    public void printSanPham(int mahd) {
//
//        String uderline = "-";
//        try {
//            JFileChooser chooser = new JFileChooser();
//            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//            chooser.setAcceptAllFileFilterUsed(false);
//            File file;
//            int count = 0;
//            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//                file = new File(chooser.getSelectedFile() + "/bill" + "-" + hdbus.search(mahd).getMaHD() + ".pdf");
//                while (file.exists()) {
//                    String s = "/bill" + "-" + hdbus.search(mahd).getMaHD() + ".pdf";
//                    String[] parts = s.split(".", 2);
//
//                    file = new File(chooser.getSelectedFile() + "/" + "(" + (count++) + ")" + parts[1]);
//                }
//                bf = BaseFont.createFont("./font/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//                Document bill = new Document(PageSize.A4, 15, 15, 10, 10);
//
//                String line = "";
//                for (int i = 0; i < bill.getPageSize().getWidth() / 5; i++) {
//                    line += uderline;
//                }
//                PdfWriter.getInstance(bill, new FileOutputStream(file));
//
//                bill.open();
//
//                Paragraph header = new Paragraph("SIÊU THỊ MINI", new Font(bf, 35));
//                header.setAlignment(1);
//                bill.add(header);
//
//                Paragraph info = new Paragraph("Hóa đơn : " + hdbus.search(mahd).getMaHD()
//                        + "          Ngày : " + hdbus.search(mahd).getNgayLap()
//                        + "                                                     Nhân viên : " + hdbus.search(mahd).getMaNV(), new Font(bf, 15));
//                bill.add(info);
//
//                Paragraph l = new Paragraph(line);
//                l.setAlignment(1);
//                bill.add(l);
//
//                String[] cellHeader = {"Tên SP", "SL", "Đơn Giá (VNĐ)", "Chiết khấu", "Thành tiền"};
//
//                PdfPTable t = new PdfPTable(cellHeader.length);
//                t.setSpacingAfter(5);
//                t.setSpacingBefore(5);
//                int[] relativeWidths = {20, 20, 20, 20, 20};
//                t.setWidths(relativeWidths);
//
//                for (String s : cellHeader) {
//                    t.addCell(createCell(s, new Font(bf, 13)));
//                }
//
//                for (HoaDonDTO hd : hd) {
//                    if (mahd == hd.getMaHD()) {
//                        for (CTHoaDonDTO cthd : cthd) {
//                            for (SanPhamDTO sp1 : sp) {
//                                if (hd.getMaHD() == cthd.getMaHD()) {
//                                    if (cthd.getMaSP().equals(sp1.getMaSP())) {
//                                        t.addCell(createCell(sp1.getTenSP()));
//                                        t.addCell(createCell(String.valueOf(cthd.getSoluong())));
//                                        t.addCell(createCell(String.valueOf(cthd.getGiaban())));
//                                        t.addCell(createCell(String.valueOf(hd.getChietkhau())));
//                                        t.addCell(createCell(String.valueOf(cthd.getThanhtien())));
//
//                                    }
//
//                                }
//
//                            }
//
//                        }
//                    }
//                }
//
//                bill.add(t);
//
//                bill.add(l);
//
//                Paragraph sum = new Paragraph("Thanh toán : " + hdbus.search(mahd).getThanhtoan() + "đ", new Font(bf, 20));
//                sum.setAlignment(Element.ALIGN_RIGHT);
//                bill.add(sum);
//
//                bill.close();
//                JOptionPane.showMessageDialog(null, "In hoàn tất");
//
//            }
//
//        } catch (DocumentException | FileNotFoundException ex) {
//            Logger.getLogger(Bill_pdf.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Bill_pdf.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    
    public static String covertToString(String value) {
        try {
              String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
              Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
              return pattern.matcher(temp).replaceAll("");
        } catch (Exception ex) {
              ex.printStackTrace();
        }
        return null;
    }
    
    public void printHoaDon(String idhd) {
        SimpleDateFormat Date_Format = new SimpleDateFormat("dd-MM-yyyy"); 
        String uderline = "-";
        try {
            JFileChooser chooser = new JFileChooser("C:\\Users\\BaoLuan\\Desktop");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            File file;
            int count = 0;
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                
                file = new File(chooser.getSelectedFile() + "/bill" + "-" + idhd + ".pdf");
                while (file.exists()) {
                    String s = "/bill" + "-" + idhd + ".pdf";
                    String[] parts = s.split(".", 2);

                    file = new File(chooser.getSelectedFile() + "/" + "(" + (count++) + ")" + parts[1]);
                }
                bf = BaseFont.createFont("arial.ttf", BaseFont.WINANSI, false);
                Document bill = new Document(PageSize.A4, 15, 15, 10, 10);

                String line = "";
                for (int i = 0; i < bill.getPageSize().getWidth() / 5; i++) {
                    line += uderline;
                }
                PdfWriter.getInstance(bill, new FileOutputStream(file));

                bill.open();
                
                String date=null;
                String nv=null;
                for(int i=0;i<hdbll.getList().getHoadon().size();i++){
                    if(hdbll.getList().getHoadon().get(i).getId().equalsIgnoreCase(idhd)){
                        date = Date_Format.format(Date.valueOf(hdbll.getList().getHoadon().get(i).getNgaylap()));
                        nv= covertToString(nvbll.getNameFromID(hdbll.getList().getHoadon().get(i).getMa_nv()));
                    }
                }
                
                Paragraph header = new Paragraph("I Mart", new Font(bf, 35));
                header.setAlignment(1);
                bill.add(header);

                    Paragraph info = new Paragraph("            Bill: "+idhd+"             Date: "+date+"          Cashier: "+nv+"", new Font(bf, 15));
                bill.add(info);

                Paragraph l = new Paragraph(line);
                l.setAlignment(1);
                bill.add(l);

                String[] cellHeader = {"San pham", "So luong", "Don gia (VND)", "Thanh tien"};

                PdfPTable t = new PdfPTable(cellHeader.length);
                t.setSpacingAfter(5);
                t.setSpacingBefore(5);
                int[] relativeWidths = {20, 20, 20, 20};
                t.setWidths(relativeWidths);

                for (String s : cellHeader) {
                    t.addCell(createCell(s, new Font(bf, 13)));
                }
                
                int sum=0;
                for(int a=0;a<cthdbll.getCTHoaDonList().size();a++) {
                    if(cthdbll.getList().getCthoadon().get(a).getMa_hd().equalsIgnoreCase(idhd)){
                        t.addCell(createCell(spbll.getSPNameByID(cthdbll.getList().getCthoadon().get(a).getMa_sp())));
                        t.addCell(createCell(String.valueOf(cthdbll.getList().getCthoadon().get(a).getSoluong())));
                        t.addCell(createCell(String.valueOf((int)cthdbll.getList().getCthoadon().get(a).getDongia())));                                      
                        t.addCell(createCell(String.valueOf((int)cthdbll.getList().getCthoadon().get(a).getThanhtien())));
                    }
                }
                
                for(int i=0;i<hdbll.getList().getHoadon().size();i++){
                    if(hdbll.getList().getHoadon().get(i).getId().equalsIgnoreCase(idhd)){
                        sum = (int) hdbll.getList().getHoadon().get(i).getTongtien();
                    }
                }
                
                bill.add(t);

                bill.add(l);

                Paragraph sum2 = new Paragraph("Thanh toan : " + sum +" " + "VND", new Font(bf, 20));
                sum2.setAlignment(Element.ALIGN_RIGHT);
                bill.add(sum2);

                bill.close();
                //JOptionPane.showMessageDialog(null, "In hóa đơn hoàn tất");

            }

        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(reportBill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(reportBill.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      
    public PdfPCell createCell(String s) {
        PdfPCell cell = new PdfPCell(new Phrase(s, new Font(bf, 13)));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);

        return cell;
    }

    public PdfPCell createCell(String s, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(s, font));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPaddingBottom(10);
        return cell;
    }
    
    public static void main(String[] args) {
        reportBill r= new reportBill();
        r.printHoaDon("HD0015");
    }
    
}
