package com.fzh.sshop.utils;

import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.request.SuperResponse;

import java.util.List;

/**
 * 返回的字符串转换成对象
 * @author  fzh
 */
public class JsonResUtils {

    public static SuperResponse convertTolist(String json, Class<?> clazz){
        SuperResponse response = new SuperResponse();
        JSONObject jsonObject = JSONObject.parseObject(json);
        if(!"200".equals(jsonObject.getString("code"))){
            response.setMessage(jsonObject.getString("msg"));
        }

        return response;
    }


}
