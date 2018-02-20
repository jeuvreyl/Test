package xspeedit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import xspeedit.domain.Crate;

public class App {

    public static void main(String[] args) throws Exception {
	ResourceConfig config = new ResourceConfig();
	config.packages("xspeedit");
	ServletHolder servlet = new ServletHolder(new ServletContainer(config));
	servlet.setInitParameter("jersey.config.server.provider.package",
		"com.fasterxml.jackson.jaxrs");
	servlet.setInitParameter("jersey.config.server.provider.classnames",
		"org.glassfish.jersey.media.multipart.MultiPartFeature");

	Server server = new Server(2222);
	ServletContextHandler context = new ServletContextHandler(server, "/*");
	context.addServlet(servlet, "/*");

	try {
	    server.start();
	    server.join();
	} finally {
	    server.destroy();
	}

    }

    public static List<Crate> arrangeCrates(List<Integer> articles) {
	List<Crate> result = new ArrayList<>();
	Collections.sort(articles, Collections.reverseOrder());
	int crateSize = 10;

	for (Integer article : articles) {
	    boolean putItem = false;
	    int crateNumber = 0;
	    while (!putItem) {
		if (crateNumber == result.size()) {
		    result.add(new Crate(article));
		    putItem = true;
		} else {
		    Crate currentCrate = result.get(crateNumber);
		    if (article <= (crateSize - currentCrate.getTakenRoom())) {
			currentCrate.addArticle(article);
			putItem = true;
		    } else {
			crateNumber++;
		    }
		}
	    }
	}
	return result;
    }
}
