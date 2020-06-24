package com.fzh.sshop.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 随机数工具类
 * @author fzg
 *
 */
public class UUIDUtils {



    /**
     * 生成商品编号 14位
     * @return
     */
    public synchronized static String getNum14() {
        String rabdomStr = String.valueOf((Math.random() * 9 + 1) * 1000);
        LocalDateTime ldt = LocalDateTime.now();
        String dataStr =  ldt.format(DateTimeFormatter.ofPattern("yMMdHH"));
        String numStr = rabdomStr.substring(0, 4);
        numStr = dataStr + numStr;
        return numStr;
    }


}
