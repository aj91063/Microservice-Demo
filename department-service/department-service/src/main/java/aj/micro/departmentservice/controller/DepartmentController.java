package aj.micro.departmentservice.controller;

import aj.micro.departmentservice.dto.DepartmentDto;
import aj.micro.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
        info = @Info(
                title = "Department-Service REST APIs",
                description = "This is Department-Service REST APIs documentation",
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
                description = "Department-Service doc",
                url = "https://eazytest.site"
        )

)

@Tag(
        name = "Department Controller",
        description = "Department Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Operation(
            summary = "Save the Department",
            method = "saveDepartment()",
            description = "to save department details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartmentDto);
    }

    @Operation(
            summary = "Get the Department",
            method = "getDepartmentByCode()",
            description = "to get department details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(
            @PathVariable(required = true,name="department-code") String departmentCode){
           DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);

           return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }
}
