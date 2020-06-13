package com.fzh.sshop.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(LocalDateTime.now());
    }
}
