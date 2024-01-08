package aj.micro.employeeservice.controller;

import aj.micro.employeeservice.dto.APIResponceDto;
import aj.micro.employeeservice.dto.EmployeeDto;
import aj.micro.employeeservice.service.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto savedEmployeeDto =  employeeService.saveEmployee(employeeDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployeeDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponceDto> getEmployeeById(
            @PathVariable(required = true, name = "id") Long employeeId){

        APIResponceDto apiResponceDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(apiResponceDto);
    }
}
