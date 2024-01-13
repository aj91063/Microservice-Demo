package aj.micro.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(description = "EmployeeDto Modle Info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @Schema(description = "Employee ID")
    private Long id;
    @Schema(description = "Employee FirstName")
    private String firstName;
    @Schema(description = "Employee LastName")
    private String lastName;
    @Schema(description = "Employee Email")
    private String email;
    @Schema(description = "Department Code")
    private String departmentCode;
    @Schema(description = "Organization Code")
    private String organizationCode;
}
