package com.helloworld.rest.action;

import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.rest.RestHandler;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.client.internal.node.NodeClient;
import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static org.elasticsearch.rest.RestRequest.Method.GET;

public class HelloWorldAction extends BaseRestHandler {

	@Override
	public String getName() {
		 return "hello_world_handler";
	}
	
	@Override
    public List<Route> routes() {
		 return List.of(
		           new Route(GET, "/_hello"),
		           new Route(GET, "/_hello/{name}")
		       );
    }

	@Override
	public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
		 final String name = request.param("name", "world");
	        
	        return channel -> {
	            try {
	                XContentBuilder builder = channel.newBuilder();
	                builder.startObject();
	                builder.field("hello", name);
	                builder.field("greeting", "Hello " + name + "!");
	                builder.endObject();
	                
	                channel.sendResponse(new RestResponse(RestStatus.OK, builder));
	            } catch (Exception e) {
	                try {
	                    XContentBuilder errorBuilder = channel.newErrorBuilder();
	                    errorBuilder.startObject();
	                    errorBuilder.field("error", "Internal server error");
	                    errorBuilder.field("message", e.getMessage());
	                    errorBuilder.endObject();
	                    channel.sendResponse(new RestResponse(RestStatus.INTERNAL_SERVER_ERROR, errorBuilder));
	                } catch (IOException ioException) {
	                    // Log error if needed
	                }
	            }
	        };
	    }
	}