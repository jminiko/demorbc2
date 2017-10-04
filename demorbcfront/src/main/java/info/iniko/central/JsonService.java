package info.iniko.central;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.catalina.WebResource;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class JsonService {

	Client client;
	private WebTarget target;

	@PostConstruct
	protected void init() {

		client = (Client) ClientBuilder.newClient();

		target = client.target("http://localhost:8090/list");
		assert target != null;

	}

	

	public List<Object> getRobotDTO() {
		WebResource res = (WebResource) client
				.target("http://localhost:8090/list")
				;
				
		return null;
	}
}