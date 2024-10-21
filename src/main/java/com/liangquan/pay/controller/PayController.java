package com.liangquan.pay.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.liangquan.pay.common.BaseResponse;
import com.liangquan.pay.common.ResultUtils;
import com.liangquan.pay.config.AlipayConfig;
import com.liangquan.pay.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName：PayController
 * @Author: liangquan
 * @Date: 2024/10/21 13:31
 * @Description: PayController
 */

@Controller
public class PayController {
    @Autowired
    private HttpServletResponse httpResponse;

    // 前后端不分离支付接口
    @PostMapping("/alipay")
    public void alipay(OrderInfo orderinfo) throws Exception {
        AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL,
                AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT,
                AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest alipay_request = new AlipayTradeWapPayRequest();
        // 封装请求支付信息
        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        model.setOutTradeNo(orderinfo.getOid());
        model.setSubject(orderinfo.getSubject());
        model.setTotalAmount(orderinfo.getTotal() + "");
        model.setBody(orderinfo.getDesc());
        model.setProductCode(orderinfo.getProductNo());
        alipay_request.setBizModel(model);
        // 设置异步通知地址
        alipay_request.setNotifyUrl(AlipayConfig.notify_url);
        // 设置同步地址
        alipay_request.setReturnUrl(AlipayConfig.return_url);
        AlipayTradeWapPayResponse alipayTradeWapPayResponse =
                client.pageExecute(alipay_request);
        String form = alipayTradeWapPayResponse.getBody();
        httpResponse.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    //    前后端分离支付接口
    @RestController
    public class PayController2 {
        @Autowired
        private HttpServletResponse httpResponse;

        @PostMapping("/alipay2")
        public BaseResponse<String> alipay(@RequestBody OrderInfo orderinfo) throws
                Exception {
            AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL,
                    AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT,
                    AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,
                    AlipayConfig.SIGNTYPE);
            AlipayTradeWapPayRequest alipay_request = new
                    AlipayTradeWapPayRequest();
            // 封装请求支付信息
            AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
            model.setOutTradeNo(orderinfo.getOid());
            model.setSubject(orderinfo.getSubject());
            model.setTotalAmount(orderinfo.getTotal() + "");
            model.setBody(orderinfo.getDesc());
            model.setProductCode(orderinfo.getProductNo());
            alipay_request.setBizModel(model);
            // 设置异步通知地址
            alipay_request.setNotifyUrl(AlipayConfig.notify_url);
            // 设置同步地址
            alipay_request.setReturnUrl(AlipayConfig.return_url);
            AlipayTradeWapPayResponse alipayTradeWapPayResponse =
                    client.pageExecute(alipay_request);
            String form = alipayTradeWapPayResponse.getBody();
            System.out.println(form);
            return ResultUtils.success(form);
        }
    }
}
