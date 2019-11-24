package top.myideas.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author myideas
 * @data 2019/11/24 - 18:28
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers (ResourceHandlerRegistry registry) {
		registry.addResourceHandler ("/root/**").
				addResourceLocations ("file:/root/photo/");
	}
}
