package com.fangda.skylot.mathine.utils;

import com.fangda.skylot.mathine.model.utils.InterfaceReturn;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    private static HttpClientUtil instance = null;
    private RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(15000)
            .setConnectTimeout(15000)
            .setConnectionRequestTimeout(15000)
            .build();

    private HttpClientUtil() {
    }

    public static HttpClientUtil getInstance() {
        if (instance == null) {
            instance = new HttpClientUtil();
        }
        return instance;
    }


    /**
     * 发送 post请求
     *
     * @param httpUrl 地址
     * @param maps    参数
     */
    public String sendHttpPost(String httpUrl, Map maps) throws IOException, SkyLotException, InvocationTargetException, IllegalAccessException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(httpUrl);
        httpPost.setConfig(requestConfig);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (StringUtils.equals(httpUrl, GetProperties.getProperties("system.properties", "skylot.webservice.parking"))) {
            List datalist = Lists.newArrayList();
            datalist.add(maps);
            params.add(new BasicNameValuePair("parkingLog", SingletonObjectMapper.getInstance().writeValueAsString(datalist)));
        } else {
            Iterator it = maps.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                params.add(new BasicNameValuePair(String.valueOf(pair.getKey()), String.valueOf(pair.getValue())));
                it.remove(); // avoids a ConcurrentModificationException
            }
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
        httpPost.setEntity(entity);
//        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        try {
            CloseableHttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                String resu = EntityUtils.toString(httpEntity);//取出应答字符串
                InterfaceReturn interfaceReturn = InterfaceReturn.builder().build();
                BeanUtils.populate(interfaceReturn, SkylotUtils.jsonToMap(resu));
                client.close();
                return interfaceReturn.isResultType() ? "0" : "2";
            } else {
                return "1";
            }
        } catch (Exception e) {
            throw new SkyLotException(e);
        } finally {
            client.close();
        }
    }


}
