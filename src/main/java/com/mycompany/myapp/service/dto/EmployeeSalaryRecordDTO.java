package com.mycompany.myapp.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.EmployeeSalaryRecord} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class EmployeeSalaryRecordDTO implements Serializable {

    private Long id;

    @NotNull
    @Schema(description = "Salary record date", required = true)
    private String salaryRecordDate;

    @Schema(description = "Company")
    private String company;

    @Schema(description = "Area name")
    private String areaName;

    @Schema(description = "Area code")
    private Integer areaCode;

    @Schema(description = "Employee name")
    private String employeeName;

    @NotNull
    @Schema(description = "Birthday", required = true)
    private LocalDate birthday;

    @Schema(description = "Employee code")
    private Integer employeeCode;

    @NotNull
    @Schema(description = "Number of dependents", required = true)
    private Integer numberOfDependents;

    @NotNull
    @Schema(description = "Basic salary", required = true)
    private Integer basicSalary;

    @Schema(description = "Commuting allowance")
    private Integer commutingAllowance;

    @Schema(description = "Other allowance")
    private Integer otherAllowance;

    @Schema(description = "Employees' insurance level")
    private String insuranceLevel;

    @Schema(description = "Employees' health insurance")
    private Integer healthInsuranceFees;

    @Schema(description = "Employees' pension insurance")
    private Integer pensionInsuranceFees;

    @Schema(description = "Labour insurance")
    private Integer labourInsuranceFees;

    @Schema(description = "Personal income tax")
    private Integer personalIncomeTax;

    @Schema(description = "Personal income tax level")
    private String personalIncomeTaxLevel;

    @Schema(description = "Total deduction amount")
    private Integer totalDeductionAmount;

    @Schema(description = "Take home amount")
    private Integer takeHomeAmount;

    @Schema(description = "Version")
    private Long version;

    @Schema(description = "Create user")
    private String createUserId;

    @Schema(description = "Create date")
    private Instant createDate;

    @Schema(description = "Update user")
    private String updateUserId;

    @Schema(description = "Update date")
    private Instant updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalaryRecordDate() {
        return salaryRecordDate;
    }

    public void setSalaryRecordDate(String salaryRecordDate) {
        this.salaryRecordDate = salaryRecordDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(Integer employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Integer getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(Integer numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public Integer getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getCommutingAllowance() {
        return commutingAllowance;
    }

    public void setCommutingAllowance(Integer commutingAllowance) {
        this.commutingAllowance = commutingAllowance;
    }

    public Integer getOtherAllowance() {
        return otherAllowance;
    }

    public void setOtherAllowance(Integer otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public String getInsuranceLevel() {
        return insuranceLevel;
    }

    public void setInsuranceLevel(String insuranceLevel) {
        this.insuranceLevel = insuranceLevel;
    }

    public Integer getHealthInsuranceFees() {
        return healthInsuranceFees;
    }

    public void setHealthInsuranceFees(Integer healthInsuranceFees) {
        this.healthInsuranceFees = healthInsuranceFees;
    }

    public Integer getPensionInsuranceFees() {
        return pensionInsuranceFees;
    }

    public void setPensionInsuranceFees(Integer pensionInsuranceFees) {
        this.pensionInsuranceFees = pensionInsuranceFees;
    }

    public Integer getLabourInsuranceFees() {
        return labourInsuranceFees;
    }

    public void setLabourInsuranceFees(Integer labourInsuranceFees) {
        this.labourInsuranceFees = labourInsuranceFees;
    }

    public Integer getPersonalIncomeTax() {
        return personalIncomeTax;
    }

    public void setPersonalIncomeTax(Integer personalIncomeTax) {
        this.personalIncomeTax = personalIncomeTax;
    }

    public String getPersonalIncomeTaxLevel() {
        return personalIncomeTaxLevel;
    }

    public void setPersonalIncomeTaxLevel(String personalIncomeTaxLevel) {
        this.personalIncomeTaxLevel = personalIncomeTaxLevel;
    }

    public Integer getTotalDeductionAmount() {
        return totalDeductionAmount;
    }

    public void setTotalDeductionAmount(Integer totalDeductionAmount) {
        this.totalDeductionAmount = totalDeductionAmount;
    }

    public Integer getTakeHomeAmount() {
        return takeHomeAmount;
    }

    public void setTakeHomeAmount(Integer takeHomeAmount) {
        this.takeHomeAmount = takeHomeAmount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeSalaryRecordDTO)) {
            return false;
        }

        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = (EmployeeSalaryRecordDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, employeeSalaryRecordDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmployeeSalaryRecordDTO{" +
            "id=" + getId() +
            ", salaryRecordDate='" + getSalaryRecordDate() + "'" +
            ", company='" + getCompany() + "'" +
            ", areaName='" + getAreaName() + "'" +
            ", areaCode=" + getAreaCode() +
            ", employeeName='" + getEmployeeName() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", employeeCode=" + getEmployeeCode() +
            ", numberOfDependents=" + getNumberOfDependents() +
            ", basicSalary=" + getBasicSalary() +
            ", commutingAllowance=" + getCommutingAllowance() +
            ", otherAllowance=" + getOtherAllowance() +
            ", insuranceLevel='" + getInsuranceLevel() + "'" +
            ", healthInsuranceFees=" + getHealthInsuranceFees() +
            ", pensionInsuranceFees=" + getPensionInsuranceFees() +
            ", labourInsuranceFees=" + getLabourInsuranceFees() +
            ", personalIncomeTax=" + getPersonalIncomeTax() +
            ", personalIncomeTaxLevel='" + getPersonalIncomeTaxLevel() + "'" +
            ", totalDeductionAmount=" + getTotalDeductionAmount() +
            ", takeHomeAmount=" + getTakeHomeAmount() +
            ", version=" + getVersion() +
            ", createUserId='" + getCreateUserId() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", updateUserId='" + getUpdateUserId() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            "}";
    }
}
