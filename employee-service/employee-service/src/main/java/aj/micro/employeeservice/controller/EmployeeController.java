package aj.micro.employeeservice.controller;

import aj.micro.employeeservice.dto.APIResponceDto;
import aj.micro.employeeservice.dto.EmployeeDto;
import aj.micro.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee-Service REST APIs",
                description = "This is Employee-Service REST APIs documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Abhishek Jaiswal",
                        email = "abhishekjais1308@gmail.com",
                        url = "https://eazytest.site"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://eazytest.site"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Employee-Service doc",
                url = "https://eazytest.site"
        )

)

@Tag(
        name = "Employee Controller",
        description = "Employee Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Operation(
            summary = "Save the Employee",
            method = "saveEmployee()",
            description = "to save Employee details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto savedEmployeeDto =  employeeService.saveEmployee(employeeDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeDto);
    }
    @Operation(
            summary = "Get the Employee",
            method = "getEmployeeById()",
            description = "to get Employee details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponceDto> getEmployeeById(
            @PathVariable(required = true, name = "id") Long employeeId){

        APIResponceDto apiResponceDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponceDto);
    }
}
