package com.helloworld.plugin;

import org.junit.Test;
import com.helloworld.rest.action.HelloWorldAction;



import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.junit.Assert.*;

public class HelloWorldActionTest {

    private HelloWorldAction action = new HelloWorldAction();

    @Test
    public void testGetName() {
        String name = action.getName();
        System.out.println("Handler name: " + name);
        assertEquals("hello_world_handler", name);
    }

    @Test
    public void testRoutes() {
        System.out.println("Testing routes...");
        assertEquals(2, action.routes().size());
        
        System.out.println("Route 1: " + action.routes().get(0).getPath() + " [" + action.routes().get(0).getMethod() + "]");
        assertEquals("/_hello", action.routes().get(0).getPath());
        assertEquals(GET, action.routes().get(0).getMethod());
        
        System.out.println("Route 2: " + action.routes().get(1).getPath() + " [" + action.routes().get(1).getMethod() + "]");
        assertEquals("/_hello/{name}", action.routes().get(1).getPath());
        assertEquals(GET, action.routes().get(1).getMethod());
        
        System.out.println("All routes test passed!");
    }
}