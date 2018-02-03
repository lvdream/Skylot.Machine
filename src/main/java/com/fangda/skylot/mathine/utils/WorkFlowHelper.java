/* 
 * 文件名：WorkFlowHelper.java 
 * 版权：
 * 描述： 
 */
package com.fangda.skylot.mathine.utils;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.springframework.stereotype.Service;

import com.fangda.skylot.mathine.utils.exception.SkyLotException;

/**
 * 流程引擎服务Helper
 *
 * @author rick.wang
 * @time 2015年12月8日 下午3:12:59
 */
@Service
public class WorkFlowHelper {

    private static final String propFile = "";
    private static final String propKey = "";

    /**
     * 创建流程实例
     *
     * @param paramMap
     * @return
     * @throws SkyLotException
     * @author rick.wang
     * @time 2015年12月8日 下午3:22:52
     */
    public String createProcessInstance(Map<String, Object> paramMap) throws SkyLotException {
        Client client = getClient();
        try {

            String usercode = MapUtils.getString(paramMap, "usercode");// 当前操作用户编号
            String username = MapUtils.getString(paramMap, "username");// 当前操作用户名字
            if (StringUtils.isNotBlank(usercode) && StringUtils.isNotBlank(username)) {
                String paramJson = SingletonObjectMapper.getInstance().writeValueAsString(paramMap);
                Object[] resultArr = client.invoke("createProcess", usercode, username, paramJson, MapUtils.getString(paramMap,null));
                return getResultValue(resultArr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkyLotException("WorkFlowHelper-Exception-createProcessInstance", e.getCause());
        } finally {
            closeClient(client);
        }
    }

    /**
     * 执行流程实例节点任务
     *
     * @param paramMap
     * @return
     * @throws SkyLotException
     * @author rick.wang
     * @time
     */
    public String startAndCompleteProcessTask(Map<String, Object> paramMap) throws SkyLotException {
        Client client = getClient();
        try {

            String usercode = MapUtils.getString(paramMap, "usercode");// 当前操作用户编号
            String username = MapUtils.getString(paramMap, "username");// 当前操作用户名字
            String pId = MapUtils.getString(paramMap, "pId");// 流程实例Id
            if (StringUtils.isNotBlank(usercode) && StringUtils.isNotBlank(pId)) {
                String paramJson = SingletonObjectMapper.getInstance().writeValueAsString(paramMap);
                Object[] resultArr = client.invoke("goTonext", pId, usercode, username, paramJson);
                return getResultValue(resultArr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkyLotException("WorkFlowHelper-Exception-startAndCompleteProcessTask", e.getCause());
        } finally {
            closeClient(client);
        }
    }

    /**
     * 获取用户待办流程
     *
     * @param paramMap
     * @return
     * @throws SkyLotException
     * @author rick.wang
     * @time 2015年12月8日 下午3:22:52
     */
    public static String getProcessInstancesByUser(String type, Map<String, Object> paramMap) throws SkyLotException {
        Client client = getClient();
        try {

            String methodName = "";
            if (StringUtils.equals(type, null)) {
                methodName = null;
            } else if (StringUtils.equals(type, null)) {
                methodName = null;
            }

            String usercode = MapUtils.getString(paramMap, "usercode");// 当前操作用户编号
            String username = MapUtils.getString(paramMap, "username");// 当前操作用户名字
            String pageNum = MapUtils.getString(paramMap, "pageNum");
            String pageLength = MapUtils.getString(paramMap, "pageLength");
            String where = MapUtils.getString(paramMap, "where");
            if (StringUtils.isNotBlank(usercode) && StringUtils.isNotBlank(username)) {
                Object[] resultArr = client.invoke(methodName, usercode, pageNum, pageLength, where);
                return getResultValue(resultArr);
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkyLotException("WorkFlowHelper-Exception-getProcessInstancesByUser", e.getCause());
        } finally {
            closeClient(client);
        }
    }

    /**
     * 依据
     *
     * @param id
     * @return
     * @throws SkyLotException
     */
    public String getProcessInstancesById(String id, boolean getperview) throws SkyLotException {
        Client client = getClient();
        try {
            Object[] resultArr = client.invoke("getProcessInstanceByID", id, getperview ? "1" : "0");
            return getResultValue(resultArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeClient(client);
        }
    }

    /**
     * 依据变量序号,返回变量对象
     *
     * @param id
     * @return
     * @throws SkyLotException
     */
    public String getVariableById(String id) throws SkyLotException {
        Client client = getClient();
        try {
            Object[] resultArr = client.invoke("getVariableById", id);
            return getResultValue(resultArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeClient(client);
        }
    }

    private static Client getClient() {
        // 方式：调用Webservice方法

        DynamicClientFactory factory = DynamicClientFactory.newInstance();
        String wsdlUrl = GetProperties.getProperties(propFile, propKey);
        Client client = factory.createClient(wsdlUrl);

        return client;
    }

    private static void closeClient(Client client) {
        if (client != null) {
            client.destroy();
        }

        client = null;
    }

    private static String getResultValue(Object[] resultArr) {
        // 返回结果
        if (resultArr != null) {
            if (resultArr[0] != null) {
                return resultArr[0].toString();
            }
        }
        return null;
    }

    /**
     * 终止一个流程
     *
     * @param paramMap
     * @return
     * @throws SkyLotException
     * @author gs
     * @time 2015年12月29日 17:41:18
     */
    public String abortProcessInstance(Map<String, Object> paramMap) throws SkyLotException {
        Client client = getClient();
        try {

            String usercode = MapUtils.getString(paramMap, "usercode");// 当前操作用户编号
            String username = MapUtils.getString(paramMap, "username");// 当前操作用户名字
            String pId = MapUtils.getString(paramMap, "pId");// 流程实例Id
            if (StringUtils.isNotBlank(usercode) && StringUtils.isNotBlank(username) && StringUtils.isNotBlank(pId)) {
                Object[] resultArr = client.invoke("abortProcess", pId, usercode, username);
                return getResultValue(resultArr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkyLotException("WorkFlowHelper-Exception-startAndCompleteProcessTask", e.getCause());
        } finally {
            closeClient(client);
        }
    }

    /**
     * 代理当前流程实例节点的任务处理人
     *
     * @param paramMap
     * @return 1：success
     * @throws SkyLotException
     * @author saul
     * @time 2015年12月31日 17:41:18
     */
    public String delegateTaskByprocessInstanceId(Map<String, Object> paramMap) throws SkyLotException {
        Client client = getClient();
        try {

            String ProcessInstanceID = MapUtils.getString(paramMap, "processInstanceID");// 当前操作用户编号
            String processDealuser = MapUtils.getString(paramMap, "processDealuser");// 当前操作用户名字
            String processStartuser = MapUtils.getString(paramMap, "processStartuser");// 原始处理用户
            if (StringUtils.isNotBlank(ProcessInstanceID) && StringUtils.isNotBlank(processDealuser)) {
                Object[] resultArr = client.invoke("delegateCurrentTask", ProcessInstanceID, processStartuser,
                        processDealuser);
                return getResultValue(resultArr);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SkyLotException("WorkFlowHelper-Exception-delegateTaskByprocessInstanceId", e.getCause());
        } finally {
            closeClient(client);
        }
    }

    /**
     * 提交草稿数据
     *
     * @param businessType
     * @param businessID
     * @param businessData
     * @pdOid ecaed668-2de7-48cb-91e6-d9337171cdfd
     */
    public String draftProcess(String businessType, String businessID, String businessData) {
        Client client = getClient();
        try {
            Object[] resultArr = client.invoke("draftWFprocess", businessType, businessID, businessData);
            return getResultValue(resultArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeClient(client);
        }
    }

}