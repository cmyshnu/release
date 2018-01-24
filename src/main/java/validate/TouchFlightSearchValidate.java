package validate;

import JavaBean.TouchFlightSearch;
import com.alibaba.fastjson.JSON;
import common.Log;
import exceldata.DataProviderSet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.wx.GetTFlightSearchResponse;

import java.util.HashMap;

public class TouchFlightSearchValidate {
    //private static Logger logger = Logger.getLogger(TouchFlightSearchValidate.class);
    GetTFlightSearchResponse getTFlightSearchResponse;
    String TFlightSearchResponseStr ;
    @Test(dataProvider="testTFlightSearch",dataProviderClass = DataProviderSet.class)
    public   void  ValidateBaseInfo(HashMap<String, String> data)throws Exception
    {
      //  PropertyConfigurator.configure(".\\src\\properties\\log4j.properties");
        // 记录info级别的信息
      /*  Log logger=  new Log();
        logger.getLogger().info("This is info message.");*/
        Log.getLogger().info("This is info message.");
        Log.getLogger().error("This is info message.");
        System.out.println("请求参数：--->>>"+data);
        getTFlightSearchResponse = new GetTFlightSearchResponse();
        TFlightSearchResponseStr=getTFlightSearchResponse.getResponse(data);
        TouchFlightSearch touchFlightSearch = JSON.parseObject(TFlightSearchResponseStr, TouchFlightSearch.class);
        System.out.println("验证起飞机场：--->>>"+touchFlightSearch.getFlyOffCode());
        System.out.println("验证抵达机场：--->>>"+touchFlightSearch.getArriveCityCode());
        Assert.assertEquals("SHA", touchFlightSearch.getFlyOffCode());
        Assert.assertEquals("上海", touchFlightSearch.getFlyOffCity());
    }
}
