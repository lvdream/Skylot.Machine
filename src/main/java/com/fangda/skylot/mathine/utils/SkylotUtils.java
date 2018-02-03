/***********************************************************************
 * Module:  SkylotUtils.java
 * Author:  saul
 * Purpose: Defines the Class SkylotUtils
 ***********************************************************************/

package com.fangda.skylot.mathine.utils;

import com.fangda.skylot.mathine.service.impl.BaseCommandUtils;
import com.fangda.skylot.mathine.utils.exception.SkyLotException;
import com.google.common.collect.Maps;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.skyscreamer.jsonassert.JSONParser;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.fangda.skylot.mathine.utils.constant.Constant.*;


/**
 * 项目常用方法
 *
 * @pdOid 45e69dfb-0b93-4a7f-8336-09fa9c7ae0d5
 */
public class SkylotUtils {

    /**
     * 获取静态的imaID
     */
    public final static String imaId = GetProperties.getProperties("system.properties", "skylot.machine.id");
    /**
     * 执行PLC指令,查询状态,超时时间
     */
    public final static String opeartionTimeout = GetProperties.getProperties("system.properties", "skylot.plc.operation.timeout");

    /**
     * **************************************************************** 大小写
     * * 相关工具方法
     * ****************************************************************
     * 获取搜索条件对应类的首字母大写
     *
     * @param fildeName 待搜索的字段
     * @pdOid 3536884a-0426-4c7b-aaf3-af05d7ba6564
     */
    public static java.lang.String getMethodName(java.lang.String fildeName) {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }

    /**
     * 依据传递来的搜索参数，需要操作的模型类，搜索辅助类，创建搜索条件
     *
     * @param fields   搜索字段封装类
     * @param clazz    模型对象
     * @param criteria 搜索模型条件类
     * @throws SecurityException
     * @throws Exception
     * @pdOid 97dbd208-b843-41df-b3b4-1df5bb3b3d63
     */
    public static void setClass(List<SearchField> fields, Object clazz, Object criteria) throws SecurityException, Exception {
        try {
            Field[] fieldArray = clazz.getClass().getDeclaredFields();
            //clazz.getClass().newInstance();//?
            for (Field field : fieldArray) {
                String genericType = field.getGenericType().toString();
                if (genericType.equals("class java.lang.String")
                        || genericType.equals("class java.lang.Integer")
                        || genericType.equals("int")) {
                    for (SearchField searchField : fields) {
                        String name = field.getName();
                        if (name.equals(searchField.getField())) {
                            String op = searchField.getOp();
                            String value = searchField.getValue();
                            Method m;
                            try {
                                if (op.equals("greaterorequal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "GreaterThanOrEqualTo"), String.class);
                                } else if (op.equals("lessorequal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "LessThanOrEqualTo"), String.class);
                                } else if (op.equals("equal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "EqualTo"), String.class);
                                } else if (op.equals("notequal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "NotEqualTo"), String.class);
                                } else if (op.equals("in")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "In"), List.class);
                                } else if (op.equals("notIn")) {//add by rick.wang at 2016/03/10
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "NotIn"), List.class);
                                } else if (op.equals("like")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "Like"), String.class);
                                } else if (op.equals("isnull")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "IsNull"), null);
                                } else if (op.equals("greaterthan")) {//add by rick.wang at 2016/02/25
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "GreaterThan"), String.class);
                                } else {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "NotLike"), String.class);
                                }
                            } catch (Exception e) {
                                if (op.equals("greaterorequal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "GreaterThanOrEqualTo"), Integer.class);
                                } else if (op.equals("lessorequal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "LessThanOrEqualTo"), Integer.class);
                                } else if (op.equals("equal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "EqualTo"), Integer.class);
                                } else if (op.equals("notequal")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "NotEqualTo"), Integer.class);
                                } else if (op.equals("in")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "In"), List.class);
                                } else if (op.equals("notIn")) {//add by rick.wang at 2016/03/10
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "NotIn"), List.class);
                                } else if (op.equals("like")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "Like"), Integer.class);
                                } else if (op.equals("isnull")) {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "IsNull"), null);
                                } else if (op.equals("greaterthan")) {//add by rick.wang at 2016/02/25
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "GreaterThan"), Integer.class);
                                } else {
                                    m = (Method) criteria.getClass().getMethod("and"
                                            + getMethodName(name + "NotLike"), Integer.class);
                                }
                            }
                            if (op.equals("like")) {
//   								m.invoke(criteria,getLikeParameter(value));
                            } else if (op.equals("in") || op.equals("notIn")) {//modify by rick.wang at 2016/03/10
                                String[] vids = StringUtils.split(value.toString(), ",");
                                if (vids.length == 0) {
                                    vids = StringUtils.split("-1", ",");
                                }
                                List<String> vidList = Arrays.asList(vids);
                                m.invoke(criteria, vidList);
                            } else if (op.equals("isnull")) {
                                m.invoke(criteria, null);//对于空参数的处理
                            } else {
                                if (searchField.getType().equals("int")) {
                                    m.invoke(criteria, NumberUtils.toInt(value));
                                } else {
                                    m.invoke(criteria, value);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new SkyLotException("Exception-setClass" + e.getMessage(), e.getCause());
        }
    }

    /**
     * ************************************************************
     * *                    日期 相关工具方法
     * * ****************************************************************
     * 获取当前日期字符串 yyyy-MM-dd HH:mm:ss
     *
     * @pdOid 142ee2ec-ea62-40d7-bf4c-c15a3764cde1
     */
    public static String getStrDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    /**
     * 获取当前日期字符串 yyMMdd
     *
     * @pdOid 3821b12a-533c-4906-b939-470e6105b77f
     */
    public static String getSixStrDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        return dateFormat.format(new Date());
    }

    /**
     * 获取格式化日期
     *
     * @param format 默认"yyyyMMddHHmmss"
     * @return
     * @pdOid e86789c4-616b-4174-a370-d42b07ba2a27
     */
    public static String getFormatDate(String format) {
        format = (format == null || format == "") ? "yyyyMMddHHmmss" : format;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * *************************************************************
     * *                    JSON 相关工具方法
     * * ****************************************************************
     *
     * @param json
     * @throws SkyLotException
     * @pdOid 2140376d-fbe8-40aa-b524-b0848d9af5c3
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> jsonToMap(String json) throws SkyLotException {
        try {
            Object expected = JSONParser.parseJSON(json);
            Map<String, String> result = new HashMap<String, String>();
            if (!StringUtils.isBlank(json)) {
                result = SingletonObjectMapper.getInstance().readValue(json, Map.class);
            }
            return result;
        } catch (Exception e) {
            if (!StringUtils.isBlank(json)) {
                try {
                    List datalist = SingletonObjectMapper.getInstance().readValue(json, List.class);
                    return (Map<String, String>) datalist.get(0);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            throw new SkyLotException("PMSUtil-Exception-jsonToMap", e.getCause());
        }
    }

    /**
     * bean转Map公用方法
     *
     * @param obj
     * @return
     * @pdOid 1290e30f-3062-49b6-ac34-6257e7c46915
     * @author gs
     * @time 2015--10-22
     */
    public static Map<String, Object> beanToMap(Object obj) {
        Map<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * bean转Map公用方法
     *
     * @param obj
     * @return
     * @pdOid 18aefd61-7275-4657-8e2f-e8e4993c0f09
     * @author gs
     * @time 2015--10-22
     */
    public static HashMap<String, Object> beanToHashMap(Object obj) {
        HashMap<String, Object> params = new HashMap<String, Object>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }


    /**
     * 转换Request Map里面的参数
     *
     * @param jsonArr request map获取的参数数组
     * @param list    需要转换成的list对象
     * @throws @exception      SkyLotException@exception SkyLotException
     * @throws SkyLotException
     * @pdOid 078e4120-b5d3-4477-9ec1-6f570f16bc23
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void populateFromJSON(String[] jsonArr, List list) throws SkyLotException {
        try {
            if (jsonArr.length > 0) {
                String JSONstr = Arrays.toString(jsonArr);//数组转为字符串
                JSONstr = StringUtils.replace(JSONstr, "[[", "[");
                JSONstr = StringUtils.replace(JSONstr, "]]", "]");

                List<LinkedHashMap<String, Object>> tempList =
                        SingletonObjectMapper.getInstance().readValue(JSONstr, List.class);

                for (LinkedHashMap<String, Object> linkedHashMap : tempList) {
                    list.add(linkedHashMap);
                }
            }
        } catch (Exception e) {
            throw new SkyLotException("Exception-populateFromJSON", e.getCause());
        }
    }

    /**
     * AES加密 author by saul
     *
     * @param content  需要被加密的字符串
     * @param password 加密需要的密码
     * @return 加密之后的密文
     * @throws SkyLotException
     * @pdOid 7c762928-2d2c-432f-9185-083a0ac50e1f
     * @date oct.18.2016
     */
    public static String aESencrypt(String content, String password) throws SkyLotException {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者

            kgen.init(128, new SecureRandom(password.getBytes()));// 利用用户密码作为随机数初始化出
            // 128位的key生产者
            // 加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行

            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥

            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回
            // null。

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥

            Cipher cipher = Cipher.getInstance("AES");// 创建密码器

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器

            byte[] result = cipher.doFinal(byteContent);// 加密

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < result.length; i++) {
                String hex = Integer.toHexString(result[i] & 0xFF);
                if (hex.length() == 1) {
                    hex = '0' + hex;
                }
                sb.append(hex.toUpperCase());
            }
            return sb.toString();

        } catch (Exception e) {
            throw new SkyLotException("Exception-aESencrypt", e.getCause());
        }
    }

    /**
     * 解密AES加密过的字符串 author by saul
     *
     * @param content  AES加密过过的内容
     * @param password 加密时的密码
     * @return 明文
     * @throws SkyLotException
     * @pdOid 3382996e-13c2-4f2f-ac64-2f09afd09dc7
     * @date oct.19.2016
     */
    public static String aESdecrypt(String content, String password) throws SkyLotException {

        if (content.length() < 1)
            return null;
        byte[] resultword = new byte[content.length() / 2];
        for (int i = 0; i < content.length() / 2; i++) {
            int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
            resultword[i] = (byte) (high * 16 + low);
        }
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化为解密模式的密码器
            byte[] result = cipher.doFinal(resultword);
            return new String(result, "utf-8"); // 明文
        } catch (Exception e) {
            throw new SkyLotException("Exception-aESdecrypt", e.getCause());
        }

    }

    /**
     * 字符串转十六进制
     *
     * @param str
     * @return
     * @author Damon
     */
    public static String convertToHexStr(String str) throws SkyLotException {
        String result = "";
        try {
            for (int i = 0; i < str.length(); i++) {
                int ch = str.charAt(i);
                String s = Integer.toHexString(ch);
                result += s;
            }
            return result;
        } catch (Exception e) {
            throw new SkyLotException("SkylotUtils - Exception:converToStr", e.getCause());
        }
    }

    /**
     * 十进制数转十六进制（含负数）
     */
    public static String convertDecToHex(int num) throws SkyLotException {
        try {
            if (num < 0) {
                int numOfAbs = -num;
                String numOf = Integer.toBinaryString(numOfAbs);
            }

            return Integer.toHexString(num);
        } catch (Exception e) {
            throw new SkyLotException("", e.getCause());
        }
    }

    /**
     * 十六进制转车牌
     *
     * @param hexStr
     * @return
     * @author Damon
     */
    public static String convertHexToCh(String hexStr) throws SkyLotException {
        String hexString = "0123456789ABCDEF";
        String strOfCh = "\\u" + hexStr.substring(0, 4);
        strOfCh = decodeUnicode(strOfCh);
        String strOfEn = hexStr.substring(4, 16);
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(strOfEn.length() / 2);
            // 将每2位16进制整数组装成一个字节
            for (int i = 0; i < strOfEn.length(); i += 2) {
                baos.write((hexString.indexOf(strOfEn.charAt(i)) << 4 | hexString
                        .indexOf(strOfEn.charAt(i + 1))));
            }
            strOfEn = new String(baos.toByteArray());

            hexStr = strOfCh + strOfEn;
            return hexStr;
        } catch (Exception e) {
            throw new SkyLotException("SkylotUtils - Exception:converHexToStr", e.getCause());
        }
    }

    /**
     * unicode转换
     *
     * @param dataStr
     * @return
     */
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }

    /**
     * PLC指令：停车
     *
     * @param carCode
     * @return
     * @author Damon
     */
    public static StringBuilder commandOfPark(String carCode) throws SkyLotException {
        StringBuilder command = new StringBuilder();
        String carCodeOfHex = null;
        try {
            command.append("46494E53000000300000000200000000800002000100004200000102820BB800000B0001");
            carCodeOfHex = SkylotUtils.convertToHexStr(carCode);
            char[] carCodeOfArray = carCodeOfHex.toCharArray();
            for (int i = 0; i < carCodeOfArray.length; i += 2) {
                command.append("00" + carCodeOfArray[i] + carCodeOfArray[i + 1]);
            }
            command.append("00000000");
            return command;
        } catch (Exception e) {
            throw new SkyLotException("SkylotUtils - Exception:commandOfPark", e.getCause());
        }
    }

    /**
     * PLC指令：取车
     *
     * @param carport 车位（1~12）
     * @return
     * @author Damon
     */
    public static StringBuilder commandOfPull(String carport) throws SkyLotException {
        StringBuilder command = new StringBuilder();
        try {
            command.append("46494E530000001C0000000200000000800002000100004200000102820FA0000001");
            if (carport.length() == 1) {
                command.append("000" + carport);
            }
            if (carport.length() == 2) {
                command.append("00" + carport);
            }
            return command;
        } catch (Exception e) {
            throw new SkyLotException("SkylotUtils - Exception:commandOfPull", e.getCause());
        }
    }

    /**
     * PLC指令：读取PLC信息
     *
     * @param
     * @author Damon
     */
    public static StringBuilder commandOfSyncPlc() throws SkyLotException {
        StringBuilder command = new StringBuilder();
        try {
            command.append("46494E530000001A00000002000000008000020001000042000001018203E800007B");
            return command;
        } catch (Exception e) {
            throw new SkyLotException("SkylotUtils - Exception:commandOfSync", e.getCause());
        }
    }

    /**
     * 十六进制转二进制
     *
     * @param hexStr
     */
    public static String convertHexToBinary(String hexStr) throws SkyLotException {
        try {
            if (hexStr == null || hexStr.length() % 2 != 0)
                return null;
            String bString = "", tmp;
            for (int i = 0; i < hexStr.length(); i++) {
                tmp = "0000"
                        + Integer.toBinaryString(Integer.parseInt(hexStr
                        .substring(i, i + 1), 16));
                bString += tmp.substring(tmp.length() - 4);
            }
            return bString;
        } catch (Exception e) {
            throw new SkyLotException("SkylotUtils - Exception:convertHexToBinary", e.getCause());
        }
    }

    /**
     * 获取本地ip地址，有可能会有多个地址, 若有多个网卡则会搜集多个网卡的ip地址
     */
    public static Set<InetAddress> resolveLocalAddresses() {
        Set<InetAddress> addrs = new HashSet<InetAddress>();
        Enumeration<NetworkInterface> ns = null;
        try {
            ns = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            // ignored...
        }
        while (ns != null && ns.hasMoreElements()) {
            NetworkInterface n = ns.nextElement();
            Enumeration<InetAddress> is = n.getInetAddresses();
            while (is.hasMoreElements()) {
                InetAddress i = is.nextElement();
                if (!i.isLoopbackAddress() && !i.isLinkLocalAddress() && !i.isMulticastAddress()
                        && !isSpecialIp(i.getHostAddress())) addrs.add(i);
            }
        }
        return addrs;
    }

    /**
     * 获取本机的IP
     *
     * @return Ip地址
     */

    public static Set<String> resolveLocalIps() {
        Set<InetAddress> addrs = resolveLocalAddresses();
        Set<String> ret = new HashSet<String>();
        for (InetAddress addr : addrs)
            ret.add(addr.getHostAddress());
        return ret;
    }

    private static boolean isSpecialIp(String ip) {
        if (ip.contains(":")) return true;
        if (ip.startsWith("127.")) return true;
        if (ip.startsWith("169.254.")) return true;
        if (ip.equals("255.255.255.255")) return true;
        if (!StringUtils.contains(ip, StringUtils.substringBeforeLast(GetProperties.getProperties("system.properties", "skylot.plc.ip"), ".")))
            return true;
        return false;
    }

    /**
     * 获取搜索对象的首字母小写
     *
     * @param old 搜索对象
     * @pdOid d75634ee-8ee8-49ee-bd13-eb52ab876ac0
     */
    public java.lang.String getMethodNameLower(java.lang.String old) {
        String str = old.substring(0, 1).toLowerCase() + old.substring(1);
        return str;
    }

    /**
     * 移除Map对象里面Null的Key
     *
     * @param map
     */
    public static Map removeNullValue(Map map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object obj = (Object) iterator.next();
            Object value = (Object) map.get(obj);
            remove(value, iterator);
        }
        return map;
    }

    /**
     * 移除map中的空值
     * <p>
     * Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。
     * Iterator 被创建之后会建立一个指向原来对象的单链索引表，当原来的对象数量发生变化时，这个索引表的内容不会同步改变，
     * 所以当索引指针往后移动的时候就找不到要迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出 java.util.ConcurrentModificationException 异常。
     * 所以 Iterator 在工作的时候是不允许被迭代的对象被改变的。
     * 但你可以使用 Iterator 本身的方法 remove() 来删除对象， Iterator.remove() 方法会在删除当前迭代对象的同时维护索引的一致性。
     *
     * @param obj
     * @param iterator
     */
    private static void remove(Object obj, Iterator iterator) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (isEmpty(str)) {  //过滤掉为null和""的值 主函数输出结果map：{2=BB, 1=AA, 5=CC, 8=  }
//            if("".equals(str.trim())){  //过滤掉为null、""和" "的值 主函数输出结果map：{2=BB, 1=AA, 5=CC}
                iterator.remove();
            }

        } else if (obj instanceof Collection) {
            Collection col = (Collection) obj;
            if (col == null || col.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Map) {
            Map temp = (Map) obj;
            if (temp == null || temp.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            if (array == null || array.length <= 0) {
                iterator.remove();
            }
        } else {
            if (obj == null) {
                iterator.remove();
            }
        }
    }

    public static boolean isEmpty(Object obj) {
        return obj == null || obj.toString().length() == 0;
    }


    /**
     * 验证取车二维码正确性
     *
     * @param Qcode 二维码解析字符串
     * @return map
     */
    public static Map verifyCode(String Qcode) {
        Map map = Maps.newHashMap();
        String decodeStr = null;
        try {
            decodeStr = BaseCommandUtils.decode(Qcode);
            if (!StringUtils.contains(decodeStr, ":00")) {
                decodeStr = Qcode;
            }
        } catch (Exception e) {
            decodeStr = Qcode;
        }
        String[] strings = StringUtils.split(decodeStr, "|");
        if (strings.length != 7) {
            return null;
        } else {
            map.put(MAP_QRCODE_MCID, strings[0]);
            map.put(MAP_QRCODE_CARCODE, strings[1]);
            map.put(MAP_QRCODE_MAID, strings[2]);
            map.put(MAP_QRCODE_IMAID, strings[3]);
            map.put(MAP_QRCODE_PHYSICALCODE, strings[4]);
            map.put(MAP_QRCODE_PASSWORD, strings[5]);
            map.put(MAP_QRCODE_ENDDATE, strings[6]);
        }
        return map;
    }


}