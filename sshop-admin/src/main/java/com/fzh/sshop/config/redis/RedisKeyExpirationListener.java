package com.fzh.sshop.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author fang
 * @date 2019/12/12 16:31
 **/
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Autowired
    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }


    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
//         if(expiredKey.startsWith(RedisUtils.flm_cash)){
//
//             appCashService.cashQuery(expiredKey.replace(RedisUtils.flm_cash,"").trim());
//         }else if(expiredKey.startsWith(RedisUtils.flm_cash_ff)){
//             appCashService.cashQueryForFF(expiredKey.replace(RedisUtils.flm_cash_ff,"").trim());
//         }

    }
}
