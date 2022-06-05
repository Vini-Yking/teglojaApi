package br.com.tegloja.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swaggerconfig {

		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.tegloja.controller"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(apiInfo());
		}
		
		private ApiInfo apiInfo() {
			ApiInfo apiInfo = new ApiInfoBuilder()
					.title("API - Tegloja")
					.description("Api REST da TEGLOJA.")
					.license("Apache License 2.0")
					.termsOfServiceUrl("")
					.version("1.01")
					.contact(new Contact("Serratec", "www.serratec.org", "contato@serratec.org"))
					.build();
			return apiInfo;
		}
}
