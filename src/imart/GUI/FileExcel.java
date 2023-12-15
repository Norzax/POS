package imart.GUI;

/**
 *
 * @author Admin'
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JTable;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Admin'
 */
public class FileExcel {
    public static final int masp         = 0;
    public static final int tensp      = 1;
    public static final int nsx     = 2;
    public static final int hsd   = 3;
    public static final int dongia      = 4;
    public static final int soluong   = 5;
    public static final int maloai   = 6;
    private static CellStyle cellStyleFormatNumber = null;
    
    public static void main(String[] args) throws IOException{
        createExcel("E:\\Thongke.xls");
        JTable tbhd2=new JTable();
        tbhd2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null,4,4,null},
                {null, null, null, null,4,4,null},
                {null, null, null, null,4,4,null},
                {null, null, null, null,4,4,null}
            },
            new String [] {
                "Mahd", "Manv", "NgayXuat", "TongTien", "MaSale","ThanhTien","ChucNang"
            }
        ));
        writeExcel(tbhd2,"E:\\Thongke.xls" );
    }
    public static void createExcel(String excelFilePath) throws FileNotFoundException, IOException{
        Workbook wb = new HSSFWorkbook();
        
    //tạo một file excel tại vị trí đã định
    OutputStream fileOut = new FileOutputStream(excelFilePath);
    System.out.println("File Excel đã được tạo thành công.");
    //đóng stream
    //đóng workbook
    }
    public static void writeExcel(JTable a,String excelFilePath) throws IOException {
        // Create Workbook
        Workbook workbook = getWorkbook(excelFilePath);
 
        // Create sheet
        Sheet sheet = workbook.createSheet("Books"); // Create sheet with sheet name
 
        int rowIndex = 0;
         
        // Write header
        writeHeader(a,sheet, rowIndex);
 
        // Write data
        rowIndex++;
        for (int i=0;i<a.getRowCount();i++) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(a, row,i);
            rowIndex++;
        }
         
        // Write footer
        
 
        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
 
        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }
    private static Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook workbook = null;
 
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
    private static void writeHeader(JTable a,Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);
         
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        for(int i=0;i<a.getColumnCount();i++){
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(a.getColumnName(i));
        }
       
        
    }
    private static void writeBook(JTable a, Row row,int j) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workbook.createDataFormat();
            // short format = df.getFormat("#,##0");
             
            //Create CellStyle
            Workbook workbook = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workbook.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }
         
        Cell cell ;
        for(int i=0;i<a.getColumnCount();i++){
            if(i==5){
                cell = row.createCell(i);
                cell.setCellValue(Double.parseDouble(String.valueOf(a.getValueAt(j, i))));
                cell.setCellStyle(cellStyleFormatNumber);
            }
            else
            if(i==4){
                cell = row.createCell(i);
                cell.setCellValue(Integer.parseInt(String.valueOf(a.getValueAt(j, i))));
                cell.setCellStyle(cellStyleFormatNumber);
            }
            else {
                cell = row.createCell(i);
                cell.setCellValue(String.valueOf(a.getValueAt(j, i)));
            }
        }
 
        
    }
    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman"); 
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color
 
        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }
     
    // Write footer
    
     
    // Auto resize column width
    private static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }
     
    // Create output file
    private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
        }
    }
}

