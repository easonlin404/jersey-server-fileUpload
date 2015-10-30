package com.eason.jersey;


import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {
	public Application() {
		super(
				MultiPartFeature.class);

	}

}
