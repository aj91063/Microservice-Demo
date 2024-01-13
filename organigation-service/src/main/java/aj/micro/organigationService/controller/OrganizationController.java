package aj.micro.organigationService.controller;

import aj.micro.organigationService.dto.OrganizationDto;
import aj.micro.organigationService.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
       OrganizationDto saveOrganizationDto = organizationService.saveOrganization(organizationDto);
       return ResponseEntity.status(HttpStatus.CREATED).body(saveOrganizationDto);
    }

    @GetMapping("/{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable(name = "organization-code") String organizationCode){
       OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
       return ResponseEntity.status(HttpStatus.OK).body(organizationDto);
    }
}
