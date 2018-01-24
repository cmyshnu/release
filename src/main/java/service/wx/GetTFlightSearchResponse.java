package service.wx;

//import common.DepDate;
import common.HttpRequests;


import jxl.read.biff.BiffException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class GetTFlightSearchResponse {
/*    @DataProvider(name="testTFlightSearch")
    public Object[][] Numbers() throws BiffException, IOException {
        ExcelData e=new ExcelData("TFlightSearchData", "TFlightSearch");
        return e.getExcelData();
    }*/

    public  String getResponse(HashMap<String, String> data) throws IOException {
       //获取url
        GetUrl url= new GetUrl();
        String urlTouchStr= url.geturl("touch");
        //获取请求参数

        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        c.add(Calendar.DAY_OF_YEAR, 2);
        String DepartureDate=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
      /*  DepDate dataTouch= new DepDate();
        String DepartureDate=dataTouch.getDate();*/
        String Departure=data.get("Departure");
        String Arrival=data.get("Arrival");
        String userIp=data.get("userIp");
        String flat=data.get("flat");
        String producttype=data.get("producttype");
        String params="Departure=" + Departure + "&Arrival=" +
                Arrival + "&DepartureDate=" +DepartureDate+"&userIp="
                +userIp+"&flat="+flat+"&producttype=" + producttype;
        System.out.println("Touchrequest请求参数:--->>>"+params);
        System.out.println("Touchrequest请求报文:--->>>"+urlTouchStr+"?"+params);
        //获取响应报文
        HttpRequests HttpRequest = new HttpRequests();
        String  responseTouch =HttpRequest.getRequests(urlTouchStr,params);
        System.out.println("Touchrequestxi响应报文:--->>>"+responseTouch);
        return  responseTouch;
    }

    /*@Test(dataProvider="testTFlightSearch")
    public void testTouchFlightSearch(HashMap<String, String> data) throws IOException {
        System.out.println(data.toString());
        String  respionse=getResponse(data);
        String  Departure=data.get("Departure");
        Assert.assertEquals("SHA", Departure);
    }*/
}
