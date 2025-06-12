package com.helloworld.plugin;


import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.rest.RestHandler;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.common.io.stream.NamedWriteableRegistry;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.features.NodeFeature;
import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import com.helloworld.rest.action.HelloWorldAction;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class HelloWorldPlugin extends Plugin implements ActionPlugin{
	public String name() {
        return "hello-world";
    }

    public String description() {
        return "Hello World Plugin";
    }
    
    @Override
    public Collection<RestHandler> getRestHandlers(Settings settings,
                                                 NamedWriteableRegistry namedWriteableRegistry,
                                                 RestController restController,
                                                 ClusterSettings clusterSettings,
                                                 IndexScopedSettings indexScopedSettings,
                                                 SettingsFilter settingsFilter,
                                                 IndexNameExpressionResolver indexNameExpressionResolver,
                                                 Supplier<DiscoveryNodes> nodesInCluster,
                                                 Predicate<NodeFeature> clusterSupportsFeature) {
        return Collections.singletonList(new HelloWorldAction());
    }
    
}
