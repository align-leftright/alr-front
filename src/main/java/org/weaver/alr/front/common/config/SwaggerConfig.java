package org.weaver.alr.front.common.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.host}")
	private String swaggerHost;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(new ApiInfo("ALR Front Server",
				"Support RestFul APIs for ALR client",
				"0.1",
				"https://github.com/align-leftright/alr-front",
				new Contact("sungtaek", "https://github.com/align-leftright/alr-front", "leesungtaek@gmail.com"),
				"Apache License Version 2.0",
				"http://www.apache.org/licenses/"
				))
		.tags(new Tag("News", "retrieve, update, delete news"))
		.host(swaggerHost)
		.select()
		.apis(RequestHandlerSelectors.basePackage("org.weaver.alr.front"))
		.paths(PathSelectors.any())
		.build();
	}

}
