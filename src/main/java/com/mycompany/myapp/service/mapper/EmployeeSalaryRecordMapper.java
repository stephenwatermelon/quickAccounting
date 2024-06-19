package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.EmployeeSalaryRecord;
import com.mycompany.myapp.service.dto.EmployeeSalaryRecordDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link EmployeeSalaryRecord} and its DTO {@link EmployeeSalaryRecordDTO}.
 */
@Mapper(componentModel = "spring")
public interface EmployeeSalaryRecordMapper extends EntityMapper<EmployeeSalaryRecordDTO, EmployeeSalaryRecord> {}
