import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class StartRESTServer {
	public static void main(String[] args) {
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9876).build();
		ResourceConfig config = new ResourceConfig(CalcREST.class);
		JdkHttpServerFactory.createHttpServer(baseUri, config, true);
		System.out.println("Server started");
	}
}
