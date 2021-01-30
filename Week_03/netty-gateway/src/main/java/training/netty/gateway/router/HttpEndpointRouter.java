package training.netty.gateway.router;

import java.util.List;

/**
 * 路由
 * 路由负载均衡 实现不同算法的路由
 * 常见的算法 随机 轮询 带权重 hash算法
 *
 * @author ping.zhang
 */
public interface HttpEndpointRouter {

    String route(List<String> endpoints);

}
