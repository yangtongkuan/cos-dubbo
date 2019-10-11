package com.cos.common.tools.wx;

import com.cos.cloud.common.tools.MD5Utils;
import com.cos.cloud.common.tools.RandomCharsUtils;
import com.cos.cloud.common.tools.XMLUtils;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @desc: 微信获取签名
 * @User: @Created by yangtk
 * @Date: @Date 2019/9/24 13:00
 * @Classname: WXSignUtils
 * @To change this template use File | Settings | File Templates.
 */
public class WXSignUtils {
    private static final String trade_type = "APP";

    public static void getSign(String appId, String mchId, String apiKey, String out_trade_no, Double payMoney, String notify_url, String body, String detail, int activeTime) {
        SortedMap<String, Object> params = new TreeMap<String, Object>();
        params.put("appid", appId);
        params.put("mch_id", mchId);
        params.put("nonce_str", RandomCharsUtils.getRandomChar(16));
        params.put("body", body);
        if (StringUtils.isNotEmpty(detail)) {
            params.put("detail", detail);
        }
        params.put("out_trade_no", out_trade_no);
        params.put("total_fee", calculateMoney(payMoney));
        params.put("spbill_create_ip", "127.0.0.1");
        params.put("time_start", RandomCharsUtils.timeStart());
        params.put("time_expire", RandomCharsUtils.timeExpire(activeTime));
        params.put("notify_url", notify_url);
        params.put("trade_type", trade_type);
        String sign = createSign(apiKey, "UTF-8", params);
        params.put("sign", sign);
        Map<String,String > v = new HashMap<>();
        String requestXml = XMLUtils.createXmlByMap("xml", params,true,true);
        System.out.println(requestXml);
    }

    public static void main(String[] args) {
        getSign("123","456","789","20190924",10.0d,"","test","商品",30);
    }


    public static String createSign(String apiKey, String characterEncoding, SortedMap<String, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet(); //所有参与传参的参数按照accsii排序
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + apiKey);
        //解决-提交中文，签名错误
//        String sign = MD5Utils.encoderByMd5(new String(sb.toString().getBytes("UTF-8"), "UTF-8"), characterEncoding).toUpperCase();
        String sign = MD5Utils.encoderByMd5(sb.toString(), characterEncoding).toUpperCase();
        return sign;
    }

    // 由元转成分
    private static Integer calculateMoney(Double money) {
        BigDecimal val1 = new BigDecimal(Double.toString(money));
        BigDecimal val2 = new BigDecimal(Double.toString(100));
        return (int) val1.multiply(val2).doubleValue();
    }


}
