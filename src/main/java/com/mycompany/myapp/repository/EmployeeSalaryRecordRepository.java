package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.EmployeeSalaryRecord;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the EmployeeSalaryRecord entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeSalaryRecordRepository extends JpaRepository<EmployeeSalaryRecord, Long> {}
