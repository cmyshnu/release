import service.wx.GetUrl;

import java.io.IOException;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        GetUrl getUrl = new GetUrl();

        System.out.println(getUrl.geturl("wx"));

    }

}
