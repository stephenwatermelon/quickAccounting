package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.EmployeeSalaryRecord;
import com.mycompany.myapp.initData.InsuranceDTO;
import com.mycompany.myapp.initData.InsuranceRangeData;
import com.mycompany.myapp.initData.InsuranceTable;
import com.mycompany.myapp.initData.TaxTable;
import com.mycompany.myapp.repository.EmployeeSalaryRecordRepository;
import com.mycompany.myapp.service.EmployeeSalaryRecordService;
import com.mycompany.myapp.service.dto.EmployeeSalaryRecordDTO;
import com.mycompany.myapp.service.mapper.EmployeeSalaryRecordMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.mycompany.myapp.domain.EmployeeSalaryRecord}.
 */
@Service
@Transactional
public class EmployeeSalaryRecordServiceImpl implements EmployeeSalaryRecordService {

    private final Logger log = LoggerFactory.getLogger(EmployeeSalaryRecordServiceImpl.class);

    private final EmployeeSalaryRecordRepository employeeSalaryRecordRepository;

    private final EmployeeSalaryRecordMapper employeeSalaryRecordMapper;

    public EmployeeSalaryRecordServiceImpl(
        EmployeeSalaryRecordRepository employeeSalaryRecordRepository,
        EmployeeSalaryRecordMapper employeeSalaryRecordMapper
    ) {
        this.employeeSalaryRecordRepository = employeeSalaryRecordRepository;
        this.employeeSalaryRecordMapper = employeeSalaryRecordMapper;
    }

    private void caculate(EmployeeSalaryRecord employeeSalaryRecord) {
        String year = employeeSalaryRecord.getSalaryRecordDate();
        String area = employeeSalaryRecord.getAreaName();
        int basicSalary = employeeSalaryRecord.getBasicSalary();
        int commutingAllowance = employeeSalaryRecord.getCommutingAllowance();
        int otherAllowance = employeeSalaryRecord.getOtherAllowance();

        int totalSalary = basicSalary + commutingAllowance + otherAllowance;

        InsuranceDTO insuranceDTO = InsuranceTable.getInsuranceData(year, area, employeeSalaryRecord.getBirthday(), totalSalary);

        int totalInsurance = insuranceDTO.getTotalInsurance();
        int laborInsuranceFees = 0;
        if (employeeSalaryRecord.getAreaCode().equals(1)) {
            laborInsuranceFees = (int) Math.round(totalSalary * 6 / 1000.0f);
        }

        int salaryForTax = totalSalary - totalInsurance - commutingAllowance - laborInsuranceFees;
        int tax = TaxTable.getTax(salaryForTax, employeeSalaryRecord.getNumberOfDependents());

        int takeHomeAmount = totalSalary - tax - totalInsurance - laborInsuranceFees;

        employeeSalaryRecord.setTakeHomeAmount(takeHomeAmount);
        employeeSalaryRecord.setHealthInsuranceFees(insuranceDTO.getHealthInsuranceFees());
        employeeSalaryRecord.setPensionInsuranceFees(insuranceDTO.getPensionInsuranceFees());
        employeeSalaryRecord.setLabourInsuranceFees(laborInsuranceFees);
        employeeSalaryRecord.setPersonalIncomeTax(tax);
        employeeSalaryRecord.setTotalDeductionAmount(tax+totalInsurance);
    }

    @Override
    public EmployeeSalaryRecordDTO save(EmployeeSalaryRecordDTO employeeSalaryRecordDTO) {
        log.debug("Request to save EmployeeSalaryRecord : {}", employeeSalaryRecordDTO);
        EmployeeSalaryRecord employeeSalaryRecord = employeeSalaryRecordMapper.toEntity(employeeSalaryRecordDTO);

        caculate(employeeSalaryRecord);

        employeeSalaryRecord = employeeSalaryRecordRepository.save(employeeSalaryRecord);
        return employeeSalaryRecordMapper.toDto(employeeSalaryRecord);
    }

    @Override
    public EmployeeSalaryRecordDTO update(EmployeeSalaryRecordDTO employeeSalaryRecordDTO) {
        log.debug("Request to update EmployeeSalaryRecord : {}", employeeSalaryRecordDTO);
        EmployeeSalaryRecord employeeSalaryRecord = employeeSalaryRecordMapper.toEntity(employeeSalaryRecordDTO);

        caculate(employeeSalaryRecord);

        employeeSalaryRecord = employeeSalaryRecordRepository.save(employeeSalaryRecord);
        return employeeSalaryRecordMapper.toDto(employeeSalaryRecord);
    }

    @Override
    public Optional<EmployeeSalaryRecordDTO> partialUpdate(EmployeeSalaryRecordDTO employeeSalaryRecordDTO) {
        log.debug("Request to partially update EmployeeSalaryRecord : {}", employeeSalaryRecordDTO);

        return employeeSalaryRecordRepository
            .findById(employeeSalaryRecordDTO.getId())
            .map(existingEmployeeSalaryRecord -> {
                employeeSalaryRecordMapper.partialUpdate(existingEmployeeSalaryRecord, employeeSalaryRecordDTO);

                return existingEmployeeSalaryRecord;
            })
            .map(employeeSalaryRecordRepository::save)
            .map(employeeSalaryRecordMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeSalaryRecordDTO> findAll(Pageable pageable) {
        log.debug("Request to get all EmployeeSalaryRecords");
        return employeeSalaryRecordRepository.findAll(pageable).map(employeeSalaryRecordMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EmployeeSalaryRecordDTO> findOne(Long id) {
        log.debug("Request to get EmployeeSalaryRecord : {}", id);
        return employeeSalaryRecordRepository.findById(id).map(employeeSalaryRecordMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete EmployeeSalaryRecord : {}", id);
        employeeSalaryRecordRepository.deleteById(id);
    }
}
