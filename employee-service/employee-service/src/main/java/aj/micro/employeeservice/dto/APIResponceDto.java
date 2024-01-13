package aj.micro.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(description = "APIResponceDto Info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponceDto {
    @Schema(description = "DepartmentDto model info")
    private DepartmentDto department;
    @Schema(description = "EmployeeDto Modle Info")
    private EmployeeDto employee;
    @Schema(description = "Organization Model Info")
    private OrganizationDto organization;
}
