package com.hcl.microservicepoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.hcl.microservicepoc.web")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("AssetCatalog - Microservice APIs")
				.description("APIs for AssetCatalog - Microservice ").version("1.0.0").build();
	}
}