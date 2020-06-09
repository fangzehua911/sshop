package com.fzh.sshop.gateway.config.jwt.interceptor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.synchronoss.cloud.nio.multipart.util.IOUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author fang
 * @version 1.0
 * @date 2020-6-6 13:19
 */
@Component
public class TokenFilter implements GlobalFilter, Ordered{

    Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        return 10;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("TokenFilter开始............");

        getAllParamtersRequest(exchange.getRequest());
        getAllHeadersRequest(exchange.getRequest());


        //拦截的逻辑。根据具体业务逻辑做拦截。
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (token == null || token.isEmpty()) {
            logger.info("token is empty...");
//			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//			return exchange.getResponse().setComplete();

            //设置status和body
            return Mono.defer(() -> {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//设置status
                final ServerHttpResponse response = exchange.getResponse();
                byte[] bytes = "{\"code\":\"99999\",\"message\":\"token error\"}".getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                response.getHeaders().set("aaa", "bbb");//设置header
                logger.info("TokenFilter拦截非法请求，没有检测到token............");
                return response.writeWith(Flux.just(buffer));//设置body
            });
        }

        //没有被if条件拦截，就放行
        return chain.filter(exchange);
    }


    private Map getAllParamtersRequest(ServerHttpRequest request) {
        logger.info("getAllParamtersRequest开始............");
        Map map = new HashMap();
        MultiValueMap<String, String> paramNames = request.getQueryParams();
        Iterator it= paramNames.keySet().iterator();
        while (it.hasNext()) {
            String paramName = (String) it.next();

            List<String> paramValues = paramNames.get(paramName);
            if (paramValues.size() >= 1) {
                String paramValue = paramValues.get(0);
                logger.info("request参数："+paramName+",值："+paramValue);
                map.put(paramName, paramValue);
            }
        }
        return map;
    }

    private Map getAllHeadersRequest(ServerHttpRequest request) {
        logger.info("getAllHeadersRequest开始............");
        Map map = new HashMap();
        HttpHeaders hearders = request.getHeaders();
        Iterator it= hearders.keySet().iterator();
        while (it.hasNext()) {
            String keyName = (String) it.next();
            List<String> headValues = hearders.get(keyName);
            if (headValues.size() >= 1) {
                String kvalue = headValues.get(0);
                logger.info("request header的key："+keyName+",值："+kvalue);
                map.put(keyName, kvalue);
            }
        }
        return map;
    }


}