package automation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class utc {

    public static void main(String[] args) throws ParseException {
        
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = utcFormat.parse("yyyy-MM-dd HH:mm:ss");

        DateFormat format = new SimpleDateFormat("yymmddhhmmss");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        System.out.println(utcFormat.format(date));
    }
    
}
