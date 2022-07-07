package automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.text.DateFormatter;

public class edit_Text_File {
    
    private static final String SimpleDateFormat = null;

    public static void main(String[] args) throws IOException {
        
        String filepath = "C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\read excel\\Activitypacket.txt";

        FileInputStream fis = new FileInputStream(filepath);
        
        File filetobemodified = new File(filepath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        byte[] byteArray = new byte[(int)filepath.length()];
            fis.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("\r\n");
            System.out.println("Number of lines in the file are ::"+stringArray.length);

        try {
            reader = new BufferedReader(new FileReader(filetobemodified));

            String line = reader.readLine();

            String l1 = line.substring(0, 45);
            String l2 = line.substring(46, 58);
            String l3 = line.substring(58, 175);

            while (l2 !=null) {
                
                oldContent = oldContent + l2 +System.lineSeparator();
                l2 = reader.readLine();
            }

            String oldString = line.substring(46, 58);;
            
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            String dateformat = SimpleDateFormat;
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyMMddhhmmss");
            String newString = "220707112955";
            String newContent = oldContent.replaceFirst(oldString, newString);
            writer = new FileWriter(filetobemodified);
            writer.write(newContent);

            System.out.println(line);
            System.out.println(l1);
            System.out.println(newContent);
            System.out.println(l3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                reader.close();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
