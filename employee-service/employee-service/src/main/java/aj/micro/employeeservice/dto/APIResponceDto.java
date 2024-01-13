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

    private DepartmentDto department;
    private EmployeeDto employee;
    private OrganizationDto organization;
}
