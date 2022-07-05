package automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_To_Word {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("D:\\data.txt", "UTF-8");
        try {
    
            FileInputStream file = new FileInputStream(new File("C:\\Users\\CharanKumar Thogata\\Downloads\\Vehicle Battery Low Alert.xlsx"));
    
            //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook (file);
    
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
    
            int rows = sheet.getLastRowNum();

            int columns = sheet.getRow(1).getLastCellNum();

            for (int i=1;i<=rows;i++) {
            
            XSSFRow row = sheet.getRow(i);

                for (int j = 0; j < columns; j++) {

                XSSFCell cell = row.getCell(j);

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
                        case BLANK:
                            break;
                        case ERROR:
                            break;
                        case FORMULA:
                            break;
                        case _NONE:
                            break;
                        default:
                            break;
                }
                
            }
        
        }    
            
            file.close();
            FileOutputStream out = new FileOutputStream(new File("D:\\writedatasamp.txt"));
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
