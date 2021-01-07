package com.zdatbit.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;


public class Zuulfilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre"; //pre,route,post,error
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isNotBlank(token)){
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            currentContext.set("isSuccess",true);
        }else{
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(404);
            currentContext.setResponseBody("token is empty");
            currentContext.set("isSuccess",false);
        }
        return null;
    }
}
