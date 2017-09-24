package com.loski.share.quartz.utils;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

public class ScheduleRunnable implements Runnable {
    private Object target;
            
    private Method method;
            
    private String params;
    
    public ScheduleRunnable(String beanName, String methodName, String params) throws Exception{
        try {
            this.target = Class.forName(beanName).newInstance();
            this.params = params;
            if(StringUtils.isNotBlank(params)){
                    this.method = target.getClass().getDeclaredMethod(methodName, String.class);
            }else{
                    this.method = target.getClass().getDeclaredMethod(methodName);
            }
        } catch (NullPointerException e) {
            throw new Exception("“" + beanName + "”空异常。");
        } catch (InstantiationException e) {
            throw new Exception("“" + beanName + "”实例化失败。");
        } catch (IllegalAccessException e) {
            throw new Exception("非法访问类“" + beanName + "”的“" + methodName + "”方法。");
        } catch (ClassNotFoundException e) {
            throw new Exception("找不到类“" + beanName + "”");
        } catch (NoSuchMethodException e) {
            throw new Exception("“" + beanName + "”的“" + methodName + "”方法未找到");
        } catch (SecurityException e) {
            throw new Exception("安全异常");
        }
    }

    @Override
    public void run() {
        try {
            if(StringUtils.isNotBlank(params)){
                    method.invoke(target, params);
            }else{
                    method.invoke(target);
            }
        }catch (Exception e) {
                e.printStackTrace();
        }
    }
}
