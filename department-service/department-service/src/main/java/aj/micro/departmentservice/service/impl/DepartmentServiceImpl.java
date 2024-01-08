package aj.micro.departmentservice.service.impl;

import aj.micro.departmentservice.dto.DepartmentDto;
import aj.micro.departmentservice.entity.Department;
import aj.micro.departmentservice.exception.ResourceNotFoundException;
import aj.micro.departmentservice.repository.DepartmentRepository;
import aj.micro.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //Convert the DepartmentDto into Department jpa entity

        Department department= new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

   Department savedDepartment =  departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
              savedDepartment.getId(),
              savedDepartment.getDepartmentName(),
              savedDepartment.getDepartmentDescription(),
              savedDepartment.getDepartmentCode()
        );

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                ()->new ResourceNotFoundException("Department","id",departmentCode)
        );

        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return departmentDto;
    }
}
