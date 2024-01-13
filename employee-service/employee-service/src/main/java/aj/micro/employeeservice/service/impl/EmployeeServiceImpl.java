package aj.micro.employeeservice.service.impl;

import aj.micro.employeeservice.dto.APIResponceDto;
import aj.micro.employeeservice.dto.DepartmentDto;
import aj.micro.employeeservice.dto.EmployeeDto;
import aj.micro.employeeservice.dto.OrganizationDto;
import aj.micro.employeeservice.entity.Employee;
import aj.micro.employeeservice.exception.ResourceNotFoundException;
import aj.micro.employeeservice.mapper.EmployeeMapper;
import aj.micro.employeeservice.repository.EmployeeRepository;
import aj.micro.employeeservice.service.APIClient;
import aj.micro.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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

//    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponceDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

//    ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.
//            getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
//               DepartmentDto.class);
//
//    DepartmentDto departmentDto =departmentDtoResponseEntity.getBody();


        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve().
                bodyToMono(DepartmentDto.class)
                .block();
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                .retrieve().
                bodyToMono(OrganizationDto.class)
                .block();

        //   DepartmentDto departmentDto =  apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        APIResponceDto apiResponceDto = new APIResponceDto();
        apiResponceDto.setEmployee(employeeDto);
        apiResponceDto.setDepartment(departmentDto);
        apiResponceDto.setOrganization(organizationDto);
        return apiResponceDto;
    }

    public APIResponceDto getDefaultDepartment(Long employeeId, Exception exception) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentDescription("This is R&D Department");
        departmentDto.setDepartmentCode("RD001");


        EmployeeDto employeeDto =EmployeeMapper.mapToEmployeeDto(employee);

        APIResponceDto apiResponceDto = new APIResponceDto();
        apiResponceDto.setEmployee(employeeDto);
        apiResponceDto.setDepartment(departmentDto);
        return apiResponceDto;
    }
}
