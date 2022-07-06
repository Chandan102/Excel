package automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class final_excel {

    

    private static final String SimpleDateFormat = null;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\data.txt", "UTF-8");
        try {
    
            FileInputStream file = new FileInputStream("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\read excel\\Book1.xlsx");
    
            //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook (file);
    
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
    
            int rows = sheet.getLastRowNum();

            int columns = sheet.getRow(0).getLastCellNum();

            for (int i=0;i<=rows;i++) {
            
            XSSFRow row = sheet.getRow(i);

                for (int j = 0; j < columns; j++) {

                XSSFCell cell = row.getCell(j);

                /*Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                String dateformat = SimpleDateFormat;
                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyMMddhhmmss");

                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                //java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("HH");
                String changed_date = formatter.format(new Date());
                

                cell.setCellValue(changed_date);*/

                    switch (cell.getCellType()) {
                        case STRING: System.out.print(cell.getStringCellValue());                        
                        writer.println(cell.getStringCellValue());    
                        break;
                
                        case NUMERIC: System.out.print(cell.getNumericCellValue());
                        writer.println(cell.getNumericCellValue());    
                        break;

                        case BOOLEAN: System.out.print(cell.getBooleanCellValue()); 
                        writer.println(cell.getBooleanCellValue());    
                        break;
                       
                }
                
            }
        
        }    
            
            file.close();
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\writedatasamp.txt"));
            workbook.write(out);
            out.close();
    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    
    }
}
