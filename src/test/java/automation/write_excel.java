package automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class write_excel {

    private static final String SimpleDateFormat = null;

    public static void main(String[] args) throws IOException, InterruptedException {
        
        String file = "C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\read excel\\Book1.xlsx";
        
        FileInputStream fis = new FileInputStream(file);
        
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();

        int columns = sheet.getRow(1).getLastCellNum();

        for (int i=0;i<=rows;i++) {
            
            XSSFRow row = sheet.getRow(i);

            for (int j = 1; j < 2; j++) {

                XSSFCell cell = row.getCell(j);

                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                String dateformat = SimpleDateFormat;
                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyMMddhhmmss");

                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                //java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("HH");
                String changed_date = formatter.format(new Date());
                

                cell.setCellValue(changed_date);
                Thread.sleep(10000);
                
            }
        }
        
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\Book1.xlsx"));

        workbook.write(fos);

        fos.close();
    }
    
}
