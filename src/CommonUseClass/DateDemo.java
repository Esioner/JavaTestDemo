package CommonUseClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	public static void main(String args[]) {
//		Date date= new Date();
//		System.out.println(date);
//		Calendar calendar = Calendar.getInstance();
//		System.out.println(calendar.get(Calendar.MILLISECOND));
//		String formt = "yyyy-MM-dd- HH:mm:ss:SSS";
//		SimpleDateFormat dateFormat = new SimpleDateFormat(formt);
//		System.out.println(dateFormat.format(new Date()));
		
		String strDate = "2017-11-30 14:26:32:666";
		String pat = "yyyy-MM-DD HH:mm:ss:SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(pat);
		try {
			Date date = sdf.parse(strDate);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
