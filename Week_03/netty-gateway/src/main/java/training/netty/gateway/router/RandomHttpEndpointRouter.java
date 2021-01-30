package training.netty.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * 随机算法
 *
 * @author ping.zhang
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
