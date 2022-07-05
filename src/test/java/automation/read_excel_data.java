package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

@Test

public class read_excel_data {
    
    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\CharanKumar Thogata\\Downloads\\Vehicle Battery Low Alert.xlsx";

        FileInputStream fis = new FileInputStream(file);
        
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("data");

        int rows = sheet.getLastRowNum();

        int columns = sheet.getRow(1).getLastCellNum();
        
        for (int i=0;i<=rows;i++) {
            
            XSSFRow row = sheet.getRow(i);

            for (int j=0;j<columns;j++) {
                
                XSSFCell cell = row.getCell(j);

                switch (cell.getCellType()) {
                    case STRING: System.out.print(cell.getStringCellValue());                        
                        break;
                
                    case NUMERIC: System.out.print(cell.getNumericCellValue());
                        break;

                    case BOOLEAN: System.out.print(cell.getBooleanCellValue());    
                }System.out.print(" | ");

            }System.out.println();
        }
        
    }

    public void write_excel() throws FileNotFoundException {

        String file = "C:\\Users\\CharanKumar Thogata\\Downloads\\Vehicle Battery Low Alert.xlsx";

        FileOutputStream fis = new FileOutputStream(file);
        
    }
}
