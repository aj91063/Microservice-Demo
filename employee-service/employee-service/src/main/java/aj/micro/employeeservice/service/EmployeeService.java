package aj.micro.employeeservice.service;

import aj.micro.employeeservice.dto.APIResponceDto;
import aj.micro.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponceDto getEmployeeById(Long employeeId);
}
