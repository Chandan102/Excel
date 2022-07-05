package automation;

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

    public static void main(String[] args) throws IOException {
        
        String file = "C:\\Users\\CharanKumar Thogata\\Downloads\\Vehicle Battery Low Alert.xlsx";
        
        FileInputStream fis = new FileInputStream(file);
        
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("data");

        int rows = sheet.getLastRowNum();

        int columns = sheet.getRow(1).getLastCellNum();

        for (int i=1;i<=rows;i++) {
            
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < 1; j++) {

                XSSFCell cell = row.getCell(j);

                //cell.setCellType(cell.setCellValue("Charan"));

                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                String dateformat = SimpleDateFormat;
                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyMMddhhmmss");

                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                //java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("HH");
                String changed_date = formatter.format(new Date());
                

                cell.setCellValue(changed_date);
                
            }
        }
        
        FileOutputStream fos = new FileOutputStream(file);

        workbook.write(fos);

        fos.close();
    }
    
}
