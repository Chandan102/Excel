package automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class edit_Text_File {
    
    public static void main(String[] args) {
        
        String filepath = "C:\\Users\\CharanKumar Thogata\\Downloads\\charan.txt";
        
        File filetobemodified = new File(filepath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

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
            String newString = "2002";
            String newContent = oldContent.replaceAll(oldString, newString);
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
