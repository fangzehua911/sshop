package com.fzh.sshop.utils;

import java.util.UUID;

/**
 * @author  fzh
 */

public class IdUtils {

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
