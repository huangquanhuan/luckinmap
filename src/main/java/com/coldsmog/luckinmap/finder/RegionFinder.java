package com.coldsmog.luckinmap.finder;

import com.alibaba.fastjson.JSONObject;
import com.coldsmog.luckinmap.model.entity.Region;
import com.coldsmog.luckinmap.service.RegionService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.soap.Addressing;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 热力图爬虫
 * @Author: quanhuan.huang
 * @Date: 2020/3/23 15:08
 */
public class RegionFinder {
    private static CloseableHttpClient httpClient = null;
    private static CloseableHttpResponse response = null;
    private static HttpGet httpGet = null;

    @Autowired
    private RegionService regionService;

    /**
     * 爬取所有省份
     *
     * @return 省份列表
     */
    public static List<String> getProvince() {
        //请求url
        String url = "https://heat.qq.com/api/getAllProvince.php?sub_domain=";
        //构造httpClient和httpGet对象
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
        List<String> provinces = new ArrayList<String>();
        try {
            //发起请求
            response = httpClient.execute(httpGet);
            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                //响应json字符串
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                List<String> list = new ArrayList<String>();
                list = JSONObject.parseArray(content, String.class);
                for (String s : list) {
//                    provinces.add(s.substring(13,s.lastIndexOf("\"")));
                    System.out.println(s.substring(13, s.lastIndexOf("\"")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinces;
    }

    /**
     * 爬取所有城市
     *
     * @return 城市列表
     */
    public static List<String> getCity(String province) {
        //请求url
        String url = "https://heat.qq.com/api/getCitysByProvince.php?province=" + province + "&sub_domain=";
        //构造httpClient和httpGet对象
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
        List<String> provinces = new ArrayList<String>();
        try {
            //发起请求
            response = httpClient.execute(httpGet);
            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                //响应json字符串
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                List<String> list = new ArrayList<String>();
                list = JSONObject.parseArray(content, String.class);
                for (int i = 1; i < list.size(); ++i) {
                    String s = list.get(i);
//                    provinces.add(s.substring(9, s.lastIndexOf("\"")));
                    System.out.println(s.substring(9, s.lastIndexOf("\"")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return provinces;
    }

    /**
     * 爬取所有区域
     *
     * @return 区域列表
     */
    public static List<Region> getRegion(String province, String city) {
        List<Region> regions = new LinkedList<Region>();
        Region region = new Region();
        //请求url
        String url = "https://heat.qq.com/api/getRegionsByCity.php?province=" + province + "&city=" + city + "&sub_domain=";
        //构造httpClient和httpGet对象
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
        List<String> provinces = new ArrayList<String>();
        try {
            //发起请求
            response = httpClient.execute(httpGet);
            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                //响应json字符串
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(content);
//                List<region> list = new ArrayList<>();
//                list = JSONObject.parseArray(content, region.class);
//                for (region r : list) {
//                    region.setArea(r.name);
//                    region.setRegionId(r.id);
//                    regions.add(region);
//                    System.out.println(r.id + " " + r.name);
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
    }

    /**
     * 爬取数据,保存到数据库
     */
    public void dowmload() {
        List<Region> regions = new LinkedList<Region>();
        List<String> provices = getProvince();
        for (String province : provices) {
            List<String> citys = getCity(province);
            for (String city : citys) {
                regions.addAll(getRegion(province, city));
            }
        }
        regionService.insertBatchByProperty(regions);
    }
}


