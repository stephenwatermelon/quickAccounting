package com.mycompany.myapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A EmployeeSalaryRecord.
 */
@Entity
@Table(name = "employee_salary_record")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class EmployeeSalaryRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Salary record date
     */
    @NotNull
    @Column(name = "salary_record_date", nullable = false)
    private String salaryRecordDate;

    /**
     * Company
     */
    @Column(name = "company")
    private String company;

    /**
     * Area name
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * Area code
     */
    @Column(name = "area_code")
    private Integer areaCode;

    /**
     * Employee name
     */
    @Column(name = "employee_name")
    private String employeeName;

    /**
     * Birthday
     */
    @NotNull
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    /**
     * Employee code
     */
    @Column(name = "employee_code")
    private Integer employeeCode;

    /**
     * Number of dependents
     */
    @NotNull
    @Column(name = "number_of_dependents", nullable = false)
    private Integer numberOfDependents;

    /**
     * Basic salary
     */
    @NotNull
    @Column(name = "basic_salary", nullable = false)
    private Integer basicSalary;

    /**
     * Commuting allowance
     */
    @Column(name = "commuting_allowance")
    private Integer commutingAllowance;

    /**
     * Other allowance
     */
    @Column(name = "other_allowance")
    private Integer otherAllowance;

    /**
     * Employees' insurance level
     */
    @Column(name = "insurance_level")
    private String insuranceLevel;

    /**
     * Employees' health insurance
     */
    @Column(name = "health_insurance_fees")
    private Integer healthInsuranceFees;

    /**
     * Employees' pension insurance
     */
    @Column(name = "pension_insurance_fees")
    private Integer pensionInsuranceFees;

    /**
     * Labour insurance
     */
    @Column(name = "labour_insurance_fees")
    private Integer labourInsuranceFees;

    /**
     * Personal income tax
     */
    @Column(name = "personal_income_tax")
    private Integer personalIncomeTax;

    /**
     * Personal income tax level
     */
    @Column(name = "personal_income_tax_level")
    private String personalIncomeTaxLevel;

    /**
     * Total deduction amount
     */
    @Column(name = "total_deduction_amount")
    private Integer totalDeductionAmount;

    /**
     * Take home amount
     */
    @Column(name = "take_home_amount")
    private Integer takeHomeAmount;

    /**
     * Version
     */
    @Column(name = "version")
    private Long version;

    /**
     * Create user
     */
    @Column(name = "create_user_id")
    private String createUserId;

    /**
     * Create date
     */
    @Column(name = "create_date")
    private Instant createDate;

    /**
     * Update user
     */
    @Column(name = "update_user_id")
    private String updateUserId;

    /**
     * Update date
     */
    @Column(name = "update_date")
    private Instant updateDate;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public EmployeeSalaryRecord id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalaryRecordDate() {
        return this.salaryRecordDate;
    }

    public EmployeeSalaryRecord salaryRecordDate(String salaryRecordDate) {
        this.setSalaryRecordDate(salaryRecordDate);
        return this;
    }

    public void setSalaryRecordDate(String salaryRecordDate) {
        this.salaryRecordDate = salaryRecordDate;
    }

    public String getCompany() {
        return this.company;
    }

    public EmployeeSalaryRecord company(String company) {
        this.setCompany(company);
        return this;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public EmployeeSalaryRecord areaName(String areaName) {
        this.setAreaName(areaName);
        return this;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAreaCode() {
        return this.areaCode;
    }

    public EmployeeSalaryRecord areaCode(Integer areaCode) {
        this.setAreaCode(areaCode);
        return this;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public EmployeeSalaryRecord employeeName(String employeeName) {
        this.setEmployeeName(employeeName);
        return this;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public EmployeeSalaryRecord birthday(LocalDate birthday) {
        this.setBirthday(birthday);
        return this;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getEmployeeCode() {
        return this.employeeCode;
    }

    public EmployeeSalaryRecord employeeCode(Integer employeeCode) {
        this.setEmployeeCode(employeeCode);
        return this;
    }

    public void setEmployeeCode(Integer employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Integer getNumberOfDependents() {
        return this.numberOfDependents;
    }

    public EmployeeSalaryRecord numberOfDependents(Integer numberOfDependents) {
        this.setNumberOfDependents(numberOfDependents);
        return this;
    }

    public void setNumberOfDependents(Integer numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public Integer getBasicSalary() {
        return this.basicSalary;
    }

    public EmployeeSalaryRecord basicSalary(Integer basicSalary) {
        this.setBasicSalary(basicSalary);
        return this;
    }

    public void setBasicSalary(Integer basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Integer getCommutingAllowance() {
        return this.commutingAllowance;
    }

    public EmployeeSalaryRecord commutingAllowance(Integer commutingAllowance) {
        this.setCommutingAllowance(commutingAllowance);
        return this;
    }

    public void setCommutingAllowance(Integer commutingAllowance) {
        this.commutingAllowance = commutingAllowance;
    }

    public Integer getOtherAllowance() {
        return this.otherAllowance;
    }

    public EmployeeSalaryRecord otherAllowance(Integer otherAllowance) {
        this.setOtherAllowance(otherAllowance);
        return this;
    }

    public void setOtherAllowance(Integer otherAllowance) {
        this.otherAllowance = otherAllowance;
    }

    public String getInsuranceLevel() {
        return this.insuranceLevel;
    }

    public EmployeeSalaryRecord insuranceLevel(String insuranceLevel) {
        this.setInsuranceLevel(insuranceLevel);
        return this;
    }

    public void setInsuranceLevel(String insuranceLevel) {
        this.insuranceLevel = insuranceLevel;
    }

    public Integer getHealthInsuranceFees() {
        return this.healthInsuranceFees;
    }

    public EmployeeSalaryRecord healthInsuranceFees(Integer healthInsuranceFees) {
        this.setHealthInsuranceFees(healthInsuranceFees);
        return this;
    }

    public void setHealthInsuranceFees(Integer healthInsuranceFees) {
        this.healthInsuranceFees = healthInsuranceFees;
    }

    public Integer getPensionInsuranceFees() {
        return this.pensionInsuranceFees;
    }

    public EmployeeSalaryRecord pensionInsuranceFees(Integer pensionInsuranceFees) {
        this.setPensionInsuranceFees(pensionInsuranceFees);
        return this;
    }

    public void setPensionInsuranceFees(Integer pensionInsuranceFees) {
        this.pensionInsuranceFees = pensionInsuranceFees;
    }

    public Integer getLabourInsuranceFees() {
        return this.labourInsuranceFees;
    }

    public EmployeeSalaryRecord labourInsuranceFees(Integer labourInsuranceFees) {
        this.setLabourInsuranceFees(labourInsuranceFees);
        return this;
    }

    public void setLabourInsuranceFees(Integer labourInsuranceFees) {
        this.labourInsuranceFees = labourInsuranceFees;
    }

    public Integer getPersonalIncomeTax() {
        return this.personalIncomeTax;
    }

    public EmployeeSalaryRecord personalIncomeTax(Integer personalIncomeTax) {
        this.setPersonalIncomeTax(personalIncomeTax);
        return this;
    }

    public void setPersonalIncomeTax(Integer personalIncomeTax) {
        this.personalIncomeTax = personalIncomeTax;
    }

    public String getPersonalIncomeTaxLevel() {
        return this.personalIncomeTaxLevel;
    }

    public EmployeeSalaryRecord personalIncomeTaxLevel(String personalIncomeTaxLevel) {
        this.setPersonalIncomeTaxLevel(personalIncomeTaxLevel);
        return this;
    }

    public void setPersonalIncomeTaxLevel(String personalIncomeTaxLevel) {
        this.personalIncomeTaxLevel = personalIncomeTaxLevel;
    }

    public Integer getTotalDeductionAmount() {
        return this.totalDeductionAmount;
    }

    public EmployeeSalaryRecord totalDeductionAmount(Integer totalDeductionAmount) {
        this.setTotalDeductionAmount(totalDeductionAmount);
        return this;
    }

    public void setTotalDeductionAmount(Integer totalDeductionAmount) {
        this.totalDeductionAmount = totalDeductionAmount;
    }

    public Integer getTakeHomeAmount() {
        return this.takeHomeAmount;
    }

    public EmployeeSalaryRecord takeHomeAmount(Integer takeHomeAmount) {
        this.setTakeHomeAmount(takeHomeAmount);
        return this;
    }

    public void setTakeHomeAmount(Integer takeHomeAmount) {
        this.takeHomeAmount = takeHomeAmount;
    }

    public Long getVersion() {
        return this.version;
    }

    public EmployeeSalaryRecord version(Long version) {
        this.setVersion(version);
        return this;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public EmployeeSalaryRecord createUserId(String createUserId) {
        this.setCreateUserId(createUserId);
        return this;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Instant getCreateDate() {
        return this.createDate;
    }

    public EmployeeSalaryRecord createDate(Instant createDate) {
        this.setCreateDate(createDate);
        return this;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUserId() {
        return this.updateUserId;
    }

    public EmployeeSalaryRecord updateUserId(String updateUserId) {
        this.setUpdateUserId(updateUserId);
        return this;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Instant getUpdateDate() {
        return this.updateDate;
    }

    public EmployeeSalaryRecord updateDate(Instant updateDate) {
        this.setUpdateDate(updateDate);
        return this;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmployeeSalaryRecord)) {
            return false;
        }
        return getId() != null && getId().equals(((EmployeeSalaryRecord) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmployeeSalaryRecord{" +
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
