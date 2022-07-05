package automation;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class timestamp {

    private static final String SimpleDateFormat = null;

    public static void main(String[] args) {
        
        //Date current_UTC_Time = Date.from(Instant.now());

        //System.out.println(current_UTC_Time);
        

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        String dateformat = SimpleDateFormat;
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyMMddhhmmss");

        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String changed_date = formatter.format(new Date());
        System.out.println(formatter.format(new Date()));

        
    }
    
}
