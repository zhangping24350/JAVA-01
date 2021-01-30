package training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import training.netty.gateway.server.NettyServer;

import java.sql.SQLOutput;

/**
 * @author ping.zhang
 */
@SpringBootApplication
public class NettyGatewayApplication {

	public static void main(String[] args) {
		try {
			System.out.println("启动Nett服务···········");
			new NettyServer(8052).run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
