package org.es.version;

import org.elasticsearch.client.internal.node.NodeClient;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.xcontent.XContentBuilder;
import org.elasticsearch.xcontent.XContentFactory;

import java.io.IOException;
import java.util.List;

/**
 * Handles GET /_plugin/ivfpq/version
 */
public class RestGetVersionAction extends BaseRestHandler {
    @Override
    public String getName() {
        return "ivfpq_version";
    }

    @Override
    public List<Route> routes() {
        return List.of(new Route(RestRequest.Method.GET, "/_plugin/ivfpq/version"));
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        return channel -> {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            builder.field("name", "ivfpq");
            builder.field("version", GetVersionPlugin.VERSION);
            builder.endObject();
            channel.sendResponse(new RestResponse(RestStatus.OK, builder));
        };
    }
}
