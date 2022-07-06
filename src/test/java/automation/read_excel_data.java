package automation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

@Test

public class read_excel_data {
    
    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\read excel\\Book1.xlsx";

        FileInputStream fis = new FileInputStream(file);

        BufferedReader bufRdr  = new BufferedReader(new FileReader(file));
        
        String line = null;

        line = bufRdr.readLine();
        
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

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
                        break;

                    case _NONE: System.out.println(cell.getErrorCellString());
                        break;
                            
                }System.out.print(" | ");

            }System.out.println();
        }
        
    }
}
