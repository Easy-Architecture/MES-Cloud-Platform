//package com.easy.mes.gateway.handler;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//public class CustomFilter implements GlobalFilter, Ordered {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        /*
//        这个request对象可以获取更多的内容
//       比如，如果是使用token验证的话，就可以判断它的Header中的Token值了
//       为了演示方便，我就判断了它的参数
//         */
//        ServerHttpRequest request = exchange.getRequest();
//        MultiValueMap<String, String> queryParams = request.getQueryParams();
//        String username = queryParams.getFirst("username");
//        if (!username.equals("admin")) {
//
//            //不允许访问，禁止访问
//            ServerHttpResponse response = exchange.getResponse();
//            response.setStatusCode(HttpStatus.NOT_ACCEPTABLE); //这个状态码是406
//
//            return exchange.getResponse().setComplete();
//        }
//        //放行
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 这是Ordered接口的中的方法
//     * 过滤器有一个优先级的问题，这个值越小，优先级越高
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
