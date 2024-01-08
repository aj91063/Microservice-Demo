package aj.micro.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponceDto {

    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
}
