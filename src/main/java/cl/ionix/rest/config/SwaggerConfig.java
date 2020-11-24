package cl.ionix.rest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.ionix.rest.domain.EndPoint;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
    public Docket newApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .paths(regex(EndPoint.VERSION_1+ "/.*"))
                .build();
        }
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Rest API")
                .contact("Jorge Landero D.")
                .version("1.0")
                .build();
    }
	
}
