package aj.micro.employeeservice.service.impl;

import aj.micro.employeeservice.dto.APIResponceDto;
import aj.micro.employeeservice.dto.DepartmentDto;
import aj.micro.employeeservice.dto.EmployeeDto;
import aj.micro.employeeservice.entity.Employee;
import aj.micro.employeeservice.exception.ResourceNotFoundException;
import aj.micro.employeeservice.repository.EmployeeRepository;
import aj.micro.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
//    private RestTemplate restTemplate;
    private WebClient webClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
          employeeDto.getId(),
          employeeDto.getFirstName(),
          employeeDto.getLastName(),
          employeeDto.getEmail(),
          employeeDto.getDepartmentCode()
        );


     Employee  savedEmployee = employeeRepository.save(employee);

     EmployeeDto savedEmployeeDto = new EmployeeDto(
             savedEmployee.getId(),
             savedEmployee.getFirstName(),
             savedEmployee.getLastName(),
             savedEmployee.getEmail(),
             savedEmployee.getDepartmentCode()
     );

        return savedEmployeeDto;
    }

    @Override
    public APIResponceDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(
               ()->new ResourceNotFoundException("Employee","id",employeeId)
       );

//    ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.
//            getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//               DepartmentDto.class);
//
//    DepartmentDto departmentDto =departmentDtoResponseEntity.getBody();


     DepartmentDto departmentDto =   webClient.get()
                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve().
                bodyToMono(DepartmentDto.class)
                .block();

       EmployeeDto employeeDto= new EmployeeDto(
               employee.getId(),
               employee.getFirstName(),
               employee.getLastName(),
               employee.getEmail(),
               employee.getDepartmentCode()
       );

        APIResponceDto apiResponceDto = new APIResponceDto();
        apiResponceDto.setEmployeeDto(employeeDto);
        apiResponceDto.setDepartmentDto(departmentDto);
        return apiResponceDto;
    }
}
