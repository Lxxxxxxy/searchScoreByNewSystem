package web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.userMapperImpl;
import entity.User;
import mapper.searchCountMapper;
import mapper.userMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class searchScore {

    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    CookieStore cookieStore = new BasicCookieStore();
    public StringBuilder sb;

    public void getScore(String username, String password) throws IOException {
        final String APPLICATION_JSON = "application/json";
        final String CONTENT_TYPE_TEXT_JSON = "text/json";

        Map<String, String> map = new HashMap<String, String>();

        CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
        HttpPost HttpPost = new HttpPost("https://authservercqwu.cqwu.edu.cn/authserver/login?service=http%3A%2F%2F218.194.176.119%2Fc%2Fportal%2Flogin%3Fredirect%3D%252Fgroup%252Fguest%252F%253Famp_sec_version_%253D1%2526gid_%253DSmZrZnJhd3FiM01ZQjE1VFVhTllHRXBpVlF2THBSUk8xa3VzZDdHRTF2OFN1UXJOS2lnMGpDdjlsTXlYU1NkdXBRQ1lGZms2ZXVKRWM2MjRGV1hBSkE9PQ%2526EMAP_LANG%253Dzh%2526THEME%253Dindigo%26p_l_id%3D217671"); // 创建httpget实例
        HttpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // 设置请求头消息User-Agent

        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response1 = httpClient.execute(HttpPost);
        String result = "";
        if (response1 != null) {
            HttpEntity entity = response1.getEntity();  //获取网页内容
            result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("网页内容:" + result);
        }
        String ltRegex = "LT-(.*)-cas";
        Pattern ltP = Pattern.compile(ltRegex);
        Matcher ltM = ltP.matcher(result);
        String ltRes = "";
        if (ltM.find()) {
            ltRes = ltM.group(0);
        } else {
            System.out.println("NO MATCH");
        }
        map.put("dllt", "userNamePasswordLogin");
        map.put("execution", "e1s1");
        map.put("lt", ltRes);
        map.put("username", username);
        map.put("password", password);
        map.put("_eventId", "submit");
        map.put("rmShown", "1");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        HttpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        System.out.println("请求参数：" + nvps.toString());

        HttpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        HttpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");


        String js = "{\"username\":\"13800000002\",\"password\":\"123456\"}";
        StringEntity se = new StringEntity(js);
        se.setContentType(CONTENT_TYPE_TEXT_JSON);

        //执行请求操作,拿到结果，查询状态码
        CloseableHttpResponse res = httpClient.execute(HttpPost);

//        --------------------登录成功--------------------------------


        send1(httpClient, "https://authservercqwu.cqwu.edu.cn/authserver/login?service=https%3a%2f%2fclient.cqwu.edu.cn%2fapi%2fenwas%2fcas%2fgoCallback?state=aHR0cHM6Ly9laGFsbGNxd3UuY3F3dS5lZHUuY24=");
        String value = send1(httpClient, "https://ehallcqwu.cqwu.edu.cn/login?service=https://ehallcqwu.cqwu.edu.cn/new/index.html");
//        send(httpClient, value);
        System.out.println(send(httpClient,"https://266d7afcaeb2ff1b22398f0ca30d270c.cqwu.edu.cn/jwmis/home.aspx"));


    }

    //        String score="";
//        if (res.getStatusLine().getStatusCode() == 302) {
//
//
////            System.out.println(send(httpClient, "https://authserver.cqwu.edu.cn/authserver/index.do"));
////            send(httpClient, "https://266d7afcaeb2ff1b22398f0ca30d270c.cqwu.edu.cn/jwmis/home.aspx");
//
//        }else{
//            return "false";
//        }
    private String send1(CloseableHttpClient httpClient, String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        getCookies(httpClient);
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpGet.setHeader("Referer", "https://authservercqwu.cqwu.edu.cn/authserver/login?service=https%3a%2f%2fclient.cqwu.edu.cn%2fapi%2fenwas%2fcas%2fgoCallback?state=aHR0cHM6Ly9laGFsbGNxd3UuY3F3dS5lZHUuY24=");
        httpGet.setHeader("Host", "authservercqwu.cqwu.edu.cn");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Origin", "https://authservercqwu.cqwu.edu.cn");
        httpGet.setHeader("Cache-Control", "no-cache");
        httpGet.setHeader("Cookie", sb.toString());
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpGet.setHeader("Pragma", "no-cache");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        CloseableHttpResponse execute = httpClient.execute(httpGet);
        String value="";
        try{

            Header location = execute.getFirstHeader("Location");
            value = location.getValue();
        }catch (Exception e){

        }
        return value;
    }

    private String send(CloseableHttpClient httpClient, String url) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        getCookies(httpClient);
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpGet.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
        httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpGet.setHeader("Host", "266d7afcaeb2ff1b22398f0ca30d270c.cqwu.edu.cn");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Cache-Control", "no-cache");
        httpGet.setHeader("Cookie", sb.toString());
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9");
        httpGet.setHeader("Pragma", "no-cache");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        CloseableHttpResponse execute = httpClient.execute(httpGet);
        String result = "";
        if (execute != null) {
            HttpEntity entity = execute.getEntity();  //获取网页内容
            result = EntityUtils.toString(entity, "UTF-8");
        }
        return result;
    }

    public void getCookies(CloseableHttpClient httpClient) throws IOException {
        List<Cookie> cookies1 = cookieStore.getCookies();
        for (int i = 0; i < cookies1.size(); i++) {
            //遍历Cookies
            System.out.println(cookies1.get(i));
            System.out.println("cookiename==" + cookies1.get(i).getName());
            System.out.println("cookieValue==" + cookies1.get(i).getValue());
        }
        sb = new StringBuilder();
        List<Cookie> cookies = cookieStore.getCookies();
        for (int j = 0; j < cookies.size(); j++) {
            sb.append(cookies.get(j).getName() + "=" + cookies.get(j).getValue() + ";");
        }

        System.out.print("成功后的Cookie---->" + sb.toString());

    }
}