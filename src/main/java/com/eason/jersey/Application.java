package com.eason.jersey;


import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.eason.jersey.jackson.MyObjectMapperProvider;

public class Application extends ResourceConfig {
	public Application() {
		super(
				// register Jackson ObjectMapper resolver
				MyObjectMapperProvider.class,
				JacksonFeature.class,
				MultiPartFeature.class);

	}

}
