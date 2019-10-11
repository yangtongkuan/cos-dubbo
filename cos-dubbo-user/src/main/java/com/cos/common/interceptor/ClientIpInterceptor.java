package com.cos.common.interceptor;

import com.cos.cloud.common.tools.AjaxResult;
import com.cos.cloud.common.tools.ClientIpUtils;
import com.cos.cloud.user.service.ip.BanClientIpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2019/8/30 9:57
 * @Classname: ClientIpInterceptor
 * @To change this template use File | Settings | File Templates.
 */
@Component
@Slf4j
public class ClientIpInterceptor extends HandlerInterceptorAdapter {

    private static final String SYS_CUSTOMER_CONTENT = "sysCustomer";

    @Autowired
    private BanClientIpService banClientIpService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String[]> map = request.getParameterMap();
        String[] sysCustomers = map.get(SYS_CUSTOMER_CONTENT);
        if (sysCustomers != null && sysCustomers.length > 0) {
            String clientIp = ClientIpUtils.getClientIp(request);
            String sysCustomer = sysCustomers[0];
            if (checkIpCanVisit(sysCustomer, clientIp)) {
                return true;
            } else {
                this.output(response, AjaxResult.errorBanIpResult(clientIp));
                return false;
            }
        }
//        else {
//            this.output(response, AjaxResult.errorResult("客户端标识不能为空"));
//            return false;
//        }
        return true;
//        return super.preHandle(request, response, handler);
    }

    /**
     * ip 是否可以访问
     *
     * @param sysCustomer
     * @param clientIp
     * @return
     */
    private boolean checkIpCanVisit(String sysCustomer, String clientIp) {
        System.out.println(sysCustomer);
        Set<String> banIpSet = banClientIpService.listOfBanClientIp(sysCustomer);
        if (Optional.ofNullable(banIpSet).isPresent() && banIpSet.contains(clientIp)) {
            return false;
        }
        return true;
    }

    // ip 被禁止的话 直接返回
    private void output(HttpServletResponse response, String result) throws Exception {
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.close();
    }

}
