package org.es.version;

import org.elasticsearch.client.internal.node.NodeClient;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.List;

import static org.elasticsearch.rest.RestRequest.Method.GET;

public class RestGetVersionAction extends BaseRestHandler {
    @Override
    public String getName() {
        return "get_version_action";
    }

    @Override
    public List<Route> routes() {
        return List.of(new Route(GET, "/ivfpq_version"));
    }

    @Override
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        return channel -> {
            XContentBuilder builder = channel.newBuilder();
            builder.startObject();
            builder.field("plugin", "es-ivfpq");
            builder.field("version", "0.0.1");
            builder.endObject();
            channel.sendResponse(new RestResponse(RestStatus.OK, builder));
        };
    }
}