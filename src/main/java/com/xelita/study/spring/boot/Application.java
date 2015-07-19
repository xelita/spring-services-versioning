package com.xelita.study.spring.boot;

import com.google.common.base.*;
import com.xelita.study.spring.boot.domain.*;
import com.xelita.study.spring.boot.repository.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.builder.*;
import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.*;

@EnableSwagger2
@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Value("${app.env}")
	private String env;

	@Value("${app.env.info}")
	private String envInfo;

	@Autowired
	private UserRepository userRepository;


	@Bean
	public Docket fullApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("full-api")
				.apiInfo(apiInfo())
				.select()
				.paths(apiPaths())
				.build();
	}

	private Predicate<String> apiPaths() {
		return or(
				regex("/api/users"),
				regex("/api/users2")
		);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Services Versioning API")
				.description("")
				.termsOfServiceUrl("http://www.xelita.com")
				.contact("Xelita")
				.license("The MIT License (MIT)")
				.licenseUrl("https://github.com/xelita/spring-services-versioning/blob/master/LICENSE")
				.version("1.0.0")
				.build();
	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder().sources(Application.class).run(args);
	}

	// *************************************************************************
	//
	// Methods from CommandLineRunner interface
	//
	// *************************************************************************

	@Override
	public void run(String... strings) throws Exception {
		LOGGER.info("{}", this.envInfo);
		if ("dev".equalsIgnoreCase(this.env)) {
			this.userRepository.save(new User("user1@spring.io", "password1"));
			this.userRepository.save(new User("user2@spring.io", "password2"));
			this.userRepository.save(new User("user3@spring.io", "password3"));
		}
	}
}

