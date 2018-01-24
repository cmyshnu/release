package common;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import pojo.Cabins;
import pojo.FlightInfoSimpleList;
import pojo.WxSreachBean;
import service.wx.GetWxResponse;
import service.wx.TestEarliestFlight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxAnalyzeBean {
    String WxFlightSearchResponse =null;
    public Map<FlightInfoSimpleList,Cabins> wxAnalyzeBean() throws IOException {
        GetWxResponse getWxResponse = new GetWxResponse();
        Map<FlightInfoSimpleList,Cabins> map = new HashMap<FlightInfoSimpleList, Cabins>();
        WxFlightSearchResponse = getWxResponse.getresponse().toString();
        WxSreachBean wxSreachBean = JSON.parseObject(WxFlightSearchResponse,WxSreachBean.class);
        List<FlightInfoSimpleList> list = wxSreachBean.getFlightInfoSimpleList();
        for (int i =0;i<list.size();i++){
            FlightInfoSimpleList flightInfoSimpleList = new FlightInfoSimpleList();

            flightInfoSimpleList.setOriginAirportCode(list.get(i).getOriginAirportCode());
            flightInfoSimpleList.setArriveAirportCode(list.get(i).getArriveAirportCode());
            flightInfoSimpleList.setFlyOffOnlyTime(list.get(i).getFlyOffOnlyTime());
            flightInfoSimpleList.setAirCompanyCode(list.get(i).getAirCompanyCode());
            flightInfoSimpleList.setFlightNo(list.get(i).getFlightNo());

            List<Cabins> list1=list.get(i).getCabins();
            for (int j = 0;j<list1.size();j++){
                Cabins cabins = new Cabins();
                cabins.setRealRoomCode(list1.get(j).getRealRoomCode());
                cabins.setFProductCode(list1.get(j).getFProductCode());
                cabins.setMid(list1.get(j).getMid());
                cabins.setFpoid(list1.get(j).getFpoid());
                cabins.setFat(list1.get(j).getFat());

                map.put(flightInfoSimpleList,cabins);


            }

        }

        return map;
    }

}
