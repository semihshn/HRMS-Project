package kodlamaio.hrms;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;

@SpringBootApplication
public class HrmsApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsApplication.class, args);
		//System.out.println(uploadResult.get("url"));
	}
	

}
