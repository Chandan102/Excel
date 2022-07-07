package automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_to_text {
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\data.txt", "UTF-8");
        try {
    
            FileInputStream file = new FileInputStream(new File("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\read excel\\Book1.xlsx"));
    
            //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook (file);
    
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
    
    
            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) {
                Row row = rowIterator.next();
    
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
    
                    Cell cell = cellIterator.next();
    
                    switch(cell.getCellType()) {
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue());
                            writer.print(cell.getBooleanCellValue());
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue());
                            writer.print(cell.getNumericCellValue());
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue()); // here i am writing the data to the text file.
                            writer.print(cell.getStringCellValue());
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
            FileOutputStream out = 
                new FileOutputStream(new File("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\writedatasamp.txt"));
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
