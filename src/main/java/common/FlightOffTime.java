package common;

import java.util.Calendar;

/**
 * 获取起飞日期
 * @author fy39919
 */
public class FlightOffTime {
    public String getDate(){
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        // 取当前日期的后一天
        cal.add(Calendar.DAY_OF_MONTH, +0);
        return format.format(cal.getTime());
    }
}
