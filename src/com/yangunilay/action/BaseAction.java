package com.yangunilay.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/30/13
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseAction extends ActionSupport implements SessionAware {
    protected Map<String,Object> session;
    @Override
    public void setSession(Map<String, Object> stringObjectMap) {
        session = stringObjectMap;
    }
}
