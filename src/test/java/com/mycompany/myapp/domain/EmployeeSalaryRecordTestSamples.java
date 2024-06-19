package com.mycompany.myapp.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeSalaryRecordTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static EmployeeSalaryRecord getEmployeeSalaryRecordSample1() {
        return new EmployeeSalaryRecord()
            .id(1L)
            .salaryRecordDate("salaryRecordDate1")
            .company("company1")
            .areaName("areaName1")
            .areaCode(1)
            .employeeName("employeeName1")
            .employeeCode(1)
            .numberOfDependents(1)
            .basicSalary(1)
            .commutingAllowance(1)
            .otherAllowance(1)
            .insuranceLevel("insuranceLevel1")
            .healthInsuranceFees(1)
            .pensionInsuranceFees(1)
            .labourInsuranceFees(1)
            .personalIncomeTax(1)
            .personalIncomeTaxLevel("personalIncomeTaxLevel1")
            .totalDeductionAmount(1)
            .takeHomeAmount(1)
            .version(1L)
            .createUserId("createUserId1")
            .updateUserId("updateUserId1");
    }

    public static EmployeeSalaryRecord getEmployeeSalaryRecordSample2() {
        return new EmployeeSalaryRecord()
            .id(2L)
            .salaryRecordDate("salaryRecordDate2")
            .company("company2")
            .areaName("areaName2")
            .areaCode(2)
            .employeeName("employeeName2")
            .employeeCode(2)
            .numberOfDependents(2)
            .basicSalary(2)
            .commutingAllowance(2)
            .otherAllowance(2)
            .insuranceLevel("insuranceLevel2")
            .healthInsuranceFees(2)
            .pensionInsuranceFees(2)
            .labourInsuranceFees(2)
            .personalIncomeTax(2)
            .personalIncomeTaxLevel("personalIncomeTaxLevel2")
            .totalDeductionAmount(2)
            .takeHomeAmount(2)
            .version(2L)
            .createUserId("createUserId2")
            .updateUserId("updateUserId2");
    }

    public static EmployeeSalaryRecord getEmployeeSalaryRecordRandomSampleGenerator() {
        return new EmployeeSalaryRecord()
            .id(longCount.incrementAndGet())
            .salaryRecordDate(UUID.randomUUID().toString())
            .company(UUID.randomUUID().toString())
            .areaName(UUID.randomUUID().toString())
            .areaCode(intCount.incrementAndGet())
            .employeeName(UUID.randomUUID().toString())
            .employeeCode(intCount.incrementAndGet())
            .numberOfDependents(intCount.incrementAndGet())
            .basicSalary(intCount.incrementAndGet())
            .commutingAllowance(intCount.incrementAndGet())
            .otherAllowance(intCount.incrementAndGet())
            .insuranceLevel(UUID.randomUUID().toString())
            .healthInsuranceFees(intCount.incrementAndGet())
            .pensionInsuranceFees(intCount.incrementAndGet())
            .labourInsuranceFees(intCount.incrementAndGet())
            .personalIncomeTax(intCount.incrementAndGet())
            .personalIncomeTaxLevel(UUID.randomUUID().toString())
            .totalDeductionAmount(intCount.incrementAndGet())
            .takeHomeAmount(intCount.incrementAndGet())
            .version(longCount.incrementAndGet())
            .createUserId(UUID.randomUUID().toString())
            .updateUserId(UUID.randomUUID().toString());
    }
}
