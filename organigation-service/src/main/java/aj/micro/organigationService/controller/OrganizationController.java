package aj.micro.organigationService.controller;

import aj.micro.organigationService.dto.OrganizationDto;
import aj.micro.organigationService.service.OrganizationService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@OpenAPIDefinition(
        info = @Info(
                title = "Organization-Service REST APIs",
                description = "This is Organization-Service REST APIs documentation",
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
                description = "Organization-Service doc",
                url = "https://eazytest.site"
        )

)

@Tag(
        name = "Organization Controller",
        description = "Organization Controller Exposes REST APIs for Department-Service"
)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Operation(
            summary = "Save the Organization",
            method = "saveOrganization()",
            description = "to save Organization details"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Created"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
       OrganizationDto saveOrganizationDto = organizationService.saveOrganization(organizationDto);
       return ResponseEntity.status(HttpStatus.CREATED).body(saveOrganizationDto);
    }

    @Operation(
            summary = "Get the Organization",
            method = "getOrganization()",
            description = "to get Organization details"
    )
    @ApiResponse(
            responseCode = "200",
            description = "OK"
    )
    @GetMapping("/{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable(name = "organization-code") String organizationCode){
       OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
       return ResponseEntity.status(HttpStatus.OK).body(organizationDto);
    }
}
