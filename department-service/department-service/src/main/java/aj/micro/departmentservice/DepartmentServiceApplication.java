package aj.micro.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentServiceApplication {
	//java -jar -Dserver.port=8083 department-service-0.0.1-SNAPSHOT.jar
	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
