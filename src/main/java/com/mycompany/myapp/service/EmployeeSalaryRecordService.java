package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.EmployeeSalaryRecordDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.EmployeeSalaryRecord}.
 */
public interface EmployeeSalaryRecordService {
    /**
     * Save a employeeSalaryRecord.
     *
     * @param employeeSalaryRecordDTO the entity to save.
     * @return the persisted entity.
     */
    EmployeeSalaryRecordDTO save(EmployeeSalaryRecordDTO employeeSalaryRecordDTO);

    /**
     * Updates a employeeSalaryRecord.
     *
     * @param employeeSalaryRecordDTO the entity to update.
     * @return the persisted entity.
     */
    EmployeeSalaryRecordDTO update(EmployeeSalaryRecordDTO employeeSalaryRecordDTO);

    /**
     * Partially updates a employeeSalaryRecord.
     *
     * @param employeeSalaryRecordDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<EmployeeSalaryRecordDTO> partialUpdate(EmployeeSalaryRecordDTO employeeSalaryRecordDTO);

    /**
     * Get all the employeeSalaryRecords.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<EmployeeSalaryRecordDTO> findAll(Pageable pageable);

    /**
     * Get the "id" employeeSalaryRecord.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<EmployeeSalaryRecordDTO> findOne(Long id);

    /**
     * Delete the "id" employeeSalaryRecord.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
