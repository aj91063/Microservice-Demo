package aj.micro.employeeservice.service.impl;

import aj.micro.employeeservice.dto.EmployeeDto;
import aj.micro.employeeservice.entity.Employee;
import aj.micro.employeeservice.exception.ResourceNotFoundException;
import aj.micro.employeeservice.repository.EmployeeRepository;
import aj.micro.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
          employeeDto.getId(),
          employeeDto.getFirstName(),
          employeeDto.getLastName(),
          employeeDto.getEmail()
        );


     Employee  savedEmployee = employeeRepository.save(employee);

     EmployeeDto savedEmployeeDto = new EmployeeDto(
             savedEmployee.getId(),
             savedEmployee.getFirstName(),
             savedEmployee.getLastName(),
             savedEmployee.getEmail()
     );

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(
               ()->new ResourceNotFoundException("Employee","id",employeeId)
       );
       EmployeeDto employeeDto= new EmployeeDto(
               employee.getId(),
               employee.getFirstName(),
               employee.getLastName(),
               employee.getEmail()
       );


        return employeeDto;
    }
}
