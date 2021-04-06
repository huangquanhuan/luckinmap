package com.coldsmog.luckinmap.finder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coldsmog.luckinmap.model.entity.Heatdata;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Description: 热力图爬虫
 * @Author: quanhuan.huang
 * @Date: 2020/3/23 15:08
 */
public class LocaltionFinder {
    private static CloseableHttpClient httpClient = null;
    private static CloseableHttpResponse response = null;
    private static HttpGet httpGet = null;
    //岳麓山中心经纬度
    private final static double center_lat = 28.183744046866305;
    private final static double center_lng = 112.93703449390313;

    /**
     * 爬取数据
     *
     * @param datetime 时间
     * @param hour     粒度
     * @return 热力图数据列表
     */
    public static List<Heatdata> getHeatDataByTime(String datetime, String hour) {
        //请求url
        String url = "https://heat.qq.com/api/getHeatDataByTime.php?region_id=1619&datetime=" + datetime + "+" + hour + "%3A00%3A00&sub_domain=";
        //构造httpClient和httpGet对象
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
        //热力图数据
        List<Heatdata> heatDateList = new ArrayList<>();

        try {
            //发起请求
            response = httpClient.execute(httpGet);
            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                //响应json字符串
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                //转为json对象
                JSONObject data = JSON.parseObject(content);
                //取出所有键
                Set<String> keys = data.keySet();
                //解密坐标
                for (String key : keys) {
                    Heatdata heatData = new Heatdata();
                    //取出权重
                    Integer weight = (Integer) data.get(key);
                    heatData.setCount(weight);
                    String[] split = key.split(",");
                    //解码后纬度
                    Double lat = (10000 * center_lat + Integer.parseInt(split[0])) / 10000;
                    //解码后经度
                    Double lng = (10000 * center_lng + Integer.parseInt(split[1])) / 10000;
                    heatData.setLatitude(lat);
                    heatData.setLongitude(lng);
                    heatData.setTime(new Date(datetime + "-" + hour));
                    heatDateList.add(heatData);
                    //System.out.println(lat+","+lng+":"+weight);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return heatDateList;
    }
}
