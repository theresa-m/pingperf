package hotswap.test.jaxrs.ping;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;

import javax.inject.Inject;

import static io.vertx.core.http.HttpMethod.GET;

public class PingResource {

    /* Snapshot the application after the first ping. */
    static boolean performSnapshot = true;

    static void snapshot() {}

    @Inject
    private Statistics statistics;

    @Route(path = "/ping/simple", methods = GET)
    void getSimple(RoutingContext context) {
        //statistics.updateStatistic(0);
        context.response().setStatusCode(200).end();

	if (true == performSnapshot) {
		System.out.println("Snapshot application");
		performSnapshot = false;
		snapshot();
		System.out.println("continue waiting for requests");
	}
    }
}
