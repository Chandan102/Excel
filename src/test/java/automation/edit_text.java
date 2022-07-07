package automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;

public class edit_text {

    private static final String SimpleDateFormat = null;

    public static void main(String[] args) throws IOException {
        
        String file = "C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\read excel\\activity.txt";

        String outputfile = "C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\data.txt";

        //PrintWriter writer = new PrintWriter("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\data.txt", "UTF-8");

        FileInputStream fis = new FileInputStream(file);

        File filetobemodified = new File(file);

        String oldcontent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(filetobemodified));

            int LineNumber = reader.readLine().length();
            //System.out.println("Number of lines in the file are : "+LineNumber);

            for (int i = 0; i < LineNumber; i++) {           

            String Line = reader.readLine();
            
            String[] strings_List = Line.split(",");
            int No_Of_Strings = strings_List.length;
            //System.out.println("Number of strings in the file are : "+No_Of_Strings);


            String string_6 = strings_List [6];

                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                String dateformat = SimpleDateFormat;
                java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyMMddhhmmss");

                formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
                //java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("HH");
                String changed_date = formatter.format(new Date());           

            String replacedString = string_6.replaceAll(strings_List [6], changed_date);

            /*for (String Line_String : strings_List) {
                //System.out.println(Line_String);
            }*/

            //System.out.println();
            //System.out.println(string_6);

            //System.out.println();
            //System.out.println(replacedString);

            String finalString =strings_List [1]+","+strings_List [2]+","+strings_List [3]+","+strings_List [4]+","+strings_List [5]+","+
                                replacedString +","+strings_List [7]+","+strings_List [8]+","+strings_List [9]+","+
                                strings_List [10]+","+strings_List [11]+","/*+strings_List [1]+","*/+strings_List [12]+","+
                                strings_List [13]+","+strings_List [14]+","+strings_List [15]+","+strings_List [16]+","+strings_List [17]+","+
                                strings_List [18]+","+strings_List [19]+","+strings_List [20]+","+strings_List [21]+","+strings_List [22]+","+
                                strings_List [23]+","+strings_List [24]+","+strings_List [25]+","+strings_List [26]+","+strings_List [27]+","+
                                strings_List [28]+","+strings_List [29]+","+strings_List [30]+","+strings_List [31]+","+strings_List [32]+","+
                                strings_List [33]+","+strings_List [34]+","+strings_List [35]+","+strings_List [36]+","+strings_List [37]+","+
                                strings_List [38]+","+strings_List [39]+","+strings_List [40]+","+strings_List [41]+","+strings_List [42]+","+
                                strings_List [43]+","+strings_List [44]+","+strings_List [45]+","+strings_List [46]+","+strings_List [47]+","+
                                strings_List [48]+","+strings_List [49]+","+strings_List [50]+","+strings_List [51]+","/*+strings_List [52]+","*/;

                                //String newContent = finalString;
                                
                                System.out.println(finalString);
                                Thread.sleep(10000);
                                
                                
                                writer = new FileWriter(filetobemodified);
                                writer.write(finalString);
                                

        }

        //FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\CharanKumar Thogata\\Desktop\\Excel\\write excel\\writedatasample.txt"));


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
