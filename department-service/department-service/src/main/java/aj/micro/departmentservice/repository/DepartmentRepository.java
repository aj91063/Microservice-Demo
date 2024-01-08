package aj.micro.departmentservice.repository;

import aj.micro.departmentservice.dto.DepartmentDto;
import aj.micro.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

   Optional<Department> findByDepartmentCode(String departmentCode);
}
