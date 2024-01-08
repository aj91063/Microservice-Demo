package aj.micro.departmentservice.controller;

import aj.micro.departmentservice.dto.DepartmentDto;
import aj.micro.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartmentDto);
    }

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(
            @PathVariable(required = true,name="department-code") String departmentCode){
           DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);

           return ResponseEntity.status(HttpStatus.OK).body(departmentDto);
    }
}
