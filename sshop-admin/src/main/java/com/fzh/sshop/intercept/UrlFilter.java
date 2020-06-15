package com.fzh.sshop.intercept;

import java.util.ArrayList;

public class UrlFilter {


    //TODO 允许无TOKEN访问的URL前缀
    static ArrayList<String> list = new ArrayList<String>(){{
        add("/swagger");
        add("/app");
        add("/error");
        add("/v2/api-docs");
        add("/webjars/");
        add("/admin/login");
        add("/admin/login/verifyCode");
    }};


    public static Boolean checkUrl(String url){
        Boolean flag = false;
        for(String s:list){
            if(url.equals(s)||url.startsWith(s)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
