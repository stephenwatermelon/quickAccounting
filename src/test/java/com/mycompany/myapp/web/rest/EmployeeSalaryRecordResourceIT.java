package com.mycompany.myapp.web.rest;

import static com.mycompany.myapp.domain.EmployeeSalaryRecordAsserts.*;
import static com.mycompany.myapp.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.EmployeeSalaryRecord;
import com.mycompany.myapp.repository.EmployeeSalaryRecordRepository;
import com.mycompany.myapp.service.dto.EmployeeSalaryRecordDTO;
import com.mycompany.myapp.service.mapper.EmployeeSalaryRecordMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link EmployeeSalaryRecordResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class EmployeeSalaryRecordResourceIT {

    private static final String DEFAULT_SALARY_RECORD_DATE = "AAAAAAAAAA";
    private static final String UPDATED_SALARY_RECORD_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_AREA_NAME = "AAAAAAAAAA";
    private static final String UPDATED_AREA_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_AREA_CODE = 1;
    private static final Integer UPDATED_AREA_CODE = 2;

    private static final String DEFAULT_EMPLOYEE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_EMPLOYEE_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_BIRTHDAY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BIRTHDAY = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_EMPLOYEE_CODE = 1;
    private static final Integer UPDATED_EMPLOYEE_CODE = 2;

    private static final Integer DEFAULT_NUMBER_OF_DEPENDENTS = 1;
    private static final Integer UPDATED_NUMBER_OF_DEPENDENTS = 2;

    private static final Integer DEFAULT_BASIC_SALARY = 1;
    private static final Integer UPDATED_BASIC_SALARY = 2;

    private static final Integer DEFAULT_COMMUTING_ALLOWANCE = 1;
    private static final Integer UPDATED_COMMUTING_ALLOWANCE = 2;

    private static final Integer DEFAULT_OTHER_ALLOWANCE = 1;
    private static final Integer UPDATED_OTHER_ALLOWANCE = 2;

    private static final String DEFAULT_INSURANCE_LEVEL = "AAAAAAAAAA";
    private static final String UPDATED_INSURANCE_LEVEL = "BBBBBBBBBB";

    private static final Integer DEFAULT_HEALTH_INSURANCE_FEES = 1;
    private static final Integer UPDATED_HEALTH_INSURANCE_FEES = 2;

    private static final Integer DEFAULT_PENSION_INSURANCE_FEES = 1;
    private static final Integer UPDATED_PENSION_INSURANCE_FEES = 2;

    private static final Integer DEFAULT_LABOUR_INSURANCE_FEES = 1;
    private static final Integer UPDATED_LABOUR_INSURANCE_FEES = 2;

    private static final Integer DEFAULT_PERSONAL_INCOME_TAX = 1;
    private static final Integer UPDATED_PERSONAL_INCOME_TAX = 2;

    private static final String DEFAULT_PERSONAL_INCOME_TAX_LEVEL = "AAAAAAAAAA";
    private static final String UPDATED_PERSONAL_INCOME_TAX_LEVEL = "BBBBBBBBBB";

    private static final Integer DEFAULT_TOTAL_DEDUCTION_AMOUNT = 1;
    private static final Integer UPDATED_TOTAL_DEDUCTION_AMOUNT = 2;

    private static final Integer DEFAULT_TAKE_HOME_AMOUNT = 1;
    private static final Integer UPDATED_TAKE_HOME_AMOUNT = 2;

    private static final Long DEFAULT_VERSION = 1L;
    private static final Long UPDATED_VERSION = 2L;

    private static final String DEFAULT_CREATE_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_USER_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_UPDATE_USER_ID = "AAAAAAAAAA";
    private static final String UPDATED_UPDATE_USER_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_UPDATE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String ENTITY_API_URL = "/api/employee-salary-records";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private EmployeeSalaryRecordRepository employeeSalaryRecordRepository;

    @Autowired
    private EmployeeSalaryRecordMapper employeeSalaryRecordMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEmployeeSalaryRecordMockMvc;

    private EmployeeSalaryRecord employeeSalaryRecord;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EmployeeSalaryRecord createEntity(EntityManager em) {
        EmployeeSalaryRecord employeeSalaryRecord = new EmployeeSalaryRecord()
            .salaryRecordDate(DEFAULT_SALARY_RECORD_DATE)
            .company(DEFAULT_COMPANY)
            .areaName(DEFAULT_AREA_NAME)
            .areaCode(DEFAULT_AREA_CODE)
            .employeeName(DEFAULT_EMPLOYEE_NAME)
            .birthday(DEFAULT_BIRTHDAY)
            .employeeCode(DEFAULT_EMPLOYEE_CODE)
            .numberOfDependents(DEFAULT_NUMBER_OF_DEPENDENTS)
            .basicSalary(DEFAULT_BASIC_SALARY)
            .commutingAllowance(DEFAULT_COMMUTING_ALLOWANCE)
            .otherAllowance(DEFAULT_OTHER_ALLOWANCE)
            .insuranceLevel(DEFAULT_INSURANCE_LEVEL)
            .healthInsuranceFees(DEFAULT_HEALTH_INSURANCE_FEES)
            .pensionInsuranceFees(DEFAULT_PENSION_INSURANCE_FEES)
            .labourInsuranceFees(DEFAULT_LABOUR_INSURANCE_FEES)
            .personalIncomeTax(DEFAULT_PERSONAL_INCOME_TAX)
            .personalIncomeTaxLevel(DEFAULT_PERSONAL_INCOME_TAX_LEVEL)
            .totalDeductionAmount(DEFAULT_TOTAL_DEDUCTION_AMOUNT)
            .takeHomeAmount(DEFAULT_TAKE_HOME_AMOUNT)
            .version(DEFAULT_VERSION)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .createDate(DEFAULT_CREATE_DATE)
            .updateUserId(DEFAULT_UPDATE_USER_ID)
            .updateDate(DEFAULT_UPDATE_DATE);
        return employeeSalaryRecord;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EmployeeSalaryRecord createUpdatedEntity(EntityManager em) {
        EmployeeSalaryRecord employeeSalaryRecord = new EmployeeSalaryRecord()
            .salaryRecordDate(UPDATED_SALARY_RECORD_DATE)
            .company(UPDATED_COMPANY)
            .areaName(UPDATED_AREA_NAME)
            .areaCode(UPDATED_AREA_CODE)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .birthday(UPDATED_BIRTHDAY)
            .employeeCode(UPDATED_EMPLOYEE_CODE)
            .numberOfDependents(UPDATED_NUMBER_OF_DEPENDENTS)
            .basicSalary(UPDATED_BASIC_SALARY)
            .commutingAllowance(UPDATED_COMMUTING_ALLOWANCE)
            .otherAllowance(UPDATED_OTHER_ALLOWANCE)
            .insuranceLevel(UPDATED_INSURANCE_LEVEL)
            .healthInsuranceFees(UPDATED_HEALTH_INSURANCE_FEES)
            .pensionInsuranceFees(UPDATED_PENSION_INSURANCE_FEES)
            .labourInsuranceFees(UPDATED_LABOUR_INSURANCE_FEES)
            .personalIncomeTax(UPDATED_PERSONAL_INCOME_TAX)
            .personalIncomeTaxLevel(UPDATED_PERSONAL_INCOME_TAX_LEVEL)
            .totalDeductionAmount(UPDATED_TOTAL_DEDUCTION_AMOUNT)
            .takeHomeAmount(UPDATED_TAKE_HOME_AMOUNT)
            .version(UPDATED_VERSION)
            .createUserId(UPDATED_CREATE_USER_ID)
            .createDate(UPDATED_CREATE_DATE)
            .updateUserId(UPDATED_UPDATE_USER_ID)
            .updateDate(UPDATED_UPDATE_DATE);
        return employeeSalaryRecord;
    }

    @BeforeEach
    public void initTest() {
        employeeSalaryRecord = createEntity(em);
    }

    @Test
    @Transactional
    void createEmployeeSalaryRecord() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the EmployeeSalaryRecord
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);
        var returnedEmployeeSalaryRecordDTO = om.readValue(
            restEmployeeSalaryRecordMockMvc
                .perform(
                    post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(employeeSalaryRecordDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            EmployeeSalaryRecordDTO.class
        );

        // Validate the EmployeeSalaryRecord in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedEmployeeSalaryRecord = employeeSalaryRecordMapper.toEntity(returnedEmployeeSalaryRecordDTO);
        assertEmployeeSalaryRecordUpdatableFieldsEquals(
            returnedEmployeeSalaryRecord,
            getPersistedEmployeeSalaryRecord(returnedEmployeeSalaryRecord)
        );
    }

    @Test
    @Transactional
    void createEmployeeSalaryRecordWithExistingId() throws Exception {
        // Create the EmployeeSalaryRecord with an existing ID
        employeeSalaryRecord.setId(1L);
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmployeeSalaryRecordMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(employeeSalaryRecordDTO)))
            .andExpect(status().isBadRequest());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkSalaryRecordDateIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        employeeSalaryRecord.setSalaryRecordDate(null);

        // Create the EmployeeSalaryRecord, which fails.
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        restEmployeeSalaryRecordMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(employeeSalaryRecordDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBirthdayIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        employeeSalaryRecord.setBirthday(null);

        // Create the EmployeeSalaryRecord, which fails.
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        restEmployeeSalaryRecordMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(employeeSalaryRecordDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkNumberOfDependentsIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        employeeSalaryRecord.setNumberOfDependents(null);

        // Create the EmployeeSalaryRecord, which fails.
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        restEmployeeSalaryRecordMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(employeeSalaryRecordDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkBasicSalaryIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        employeeSalaryRecord.setBasicSalary(null);

        // Create the EmployeeSalaryRecord, which fails.
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        restEmployeeSalaryRecordMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(employeeSalaryRecordDTO)))
            .andExpect(status().isBadRequest());

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllEmployeeSalaryRecords() throws Exception {
        // Initialize the database
        employeeSalaryRecordRepository.saveAndFlush(employeeSalaryRecord);

        // Get all the employeeSalaryRecordList
        restEmployeeSalaryRecordMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(employeeSalaryRecord.getId().intValue())))
            .andExpect(jsonPath("$.[*].salaryRecordDate").value(hasItem(DEFAULT_SALARY_RECORD_DATE)))
            .andExpect(jsonPath("$.[*].company").value(hasItem(DEFAULT_COMPANY)))
            .andExpect(jsonPath("$.[*].areaName").value(hasItem(DEFAULT_AREA_NAME)))
            .andExpect(jsonPath("$.[*].areaCode").value(hasItem(DEFAULT_AREA_CODE)))
            .andExpect(jsonPath("$.[*].employeeName").value(hasItem(DEFAULT_EMPLOYEE_NAME)))
            .andExpect(jsonPath("$.[*].birthday").value(hasItem(DEFAULT_BIRTHDAY.toString())))
            .andExpect(jsonPath("$.[*].employeeCode").value(hasItem(DEFAULT_EMPLOYEE_CODE)))
            .andExpect(jsonPath("$.[*].numberOfDependents").value(hasItem(DEFAULT_NUMBER_OF_DEPENDENTS)))
            .andExpect(jsonPath("$.[*].basicSalary").value(hasItem(DEFAULT_BASIC_SALARY)))
            .andExpect(jsonPath("$.[*].commutingAllowance").value(hasItem(DEFAULT_COMMUTING_ALLOWANCE)))
            .andExpect(jsonPath("$.[*].otherAllowance").value(hasItem(DEFAULT_OTHER_ALLOWANCE)))
            .andExpect(jsonPath("$.[*].insuranceLevel").value(hasItem(DEFAULT_INSURANCE_LEVEL)))
            .andExpect(jsonPath("$.[*].healthInsuranceFees").value(hasItem(DEFAULT_HEALTH_INSURANCE_FEES)))
            .andExpect(jsonPath("$.[*].pensionInsuranceFees").value(hasItem(DEFAULT_PENSION_INSURANCE_FEES)))
            .andExpect(jsonPath("$.[*].labourInsuranceFees").value(hasItem(DEFAULT_LABOUR_INSURANCE_FEES)))
            .andExpect(jsonPath("$.[*].personalIncomeTax").value(hasItem(DEFAULT_PERSONAL_INCOME_TAX)))
            .andExpect(jsonPath("$.[*].personalIncomeTaxLevel").value(hasItem(DEFAULT_PERSONAL_INCOME_TAX_LEVEL)))
            .andExpect(jsonPath("$.[*].totalDeductionAmount").value(hasItem(DEFAULT_TOTAL_DEDUCTION_AMOUNT)))
            .andExpect(jsonPath("$.[*].takeHomeAmount").value(hasItem(DEFAULT_TAKE_HOME_AMOUNT)))
            .andExpect(jsonPath("$.[*].version").value(hasItem(DEFAULT_VERSION.intValue())))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID)))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(DEFAULT_CREATE_DATE.toString())))
            .andExpect(jsonPath("$.[*].updateUserId").value(hasItem(DEFAULT_UPDATE_USER_ID)))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.toString())));
    }

    @Test
    @Transactional
    void getEmployeeSalaryRecord() throws Exception {
        // Initialize the database
        employeeSalaryRecordRepository.saveAndFlush(employeeSalaryRecord);

        // Get the employeeSalaryRecord
        restEmployeeSalaryRecordMockMvc
            .perform(get(ENTITY_API_URL_ID, employeeSalaryRecord.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(employeeSalaryRecord.getId().intValue()))
            .andExpect(jsonPath("$.salaryRecordDate").value(DEFAULT_SALARY_RECORD_DATE))
            .andExpect(jsonPath("$.company").value(DEFAULT_COMPANY))
            .andExpect(jsonPath("$.areaName").value(DEFAULT_AREA_NAME))
            .andExpect(jsonPath("$.areaCode").value(DEFAULT_AREA_CODE))
            .andExpect(jsonPath("$.employeeName").value(DEFAULT_EMPLOYEE_NAME))
            .andExpect(jsonPath("$.birthday").value(DEFAULT_BIRTHDAY.toString()))
            .andExpect(jsonPath("$.employeeCode").value(DEFAULT_EMPLOYEE_CODE))
            .andExpect(jsonPath("$.numberOfDependents").value(DEFAULT_NUMBER_OF_DEPENDENTS))
            .andExpect(jsonPath("$.basicSalary").value(DEFAULT_BASIC_SALARY))
            .andExpect(jsonPath("$.commutingAllowance").value(DEFAULT_COMMUTING_ALLOWANCE))
            .andExpect(jsonPath("$.otherAllowance").value(DEFAULT_OTHER_ALLOWANCE))
            .andExpect(jsonPath("$.insuranceLevel").value(DEFAULT_INSURANCE_LEVEL))
            .andExpect(jsonPath("$.healthInsuranceFees").value(DEFAULT_HEALTH_INSURANCE_FEES))
            .andExpect(jsonPath("$.pensionInsuranceFees").value(DEFAULT_PENSION_INSURANCE_FEES))
            .andExpect(jsonPath("$.labourInsuranceFees").value(DEFAULT_LABOUR_INSURANCE_FEES))
            .andExpect(jsonPath("$.personalIncomeTax").value(DEFAULT_PERSONAL_INCOME_TAX))
            .andExpect(jsonPath("$.personalIncomeTaxLevel").value(DEFAULT_PERSONAL_INCOME_TAX_LEVEL))
            .andExpect(jsonPath("$.totalDeductionAmount").value(DEFAULT_TOTAL_DEDUCTION_AMOUNT))
            .andExpect(jsonPath("$.takeHomeAmount").value(DEFAULT_TAKE_HOME_AMOUNT))
            .andExpect(jsonPath("$.version").value(DEFAULT_VERSION.intValue()))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID))
            .andExpect(jsonPath("$.createDate").value(DEFAULT_CREATE_DATE.toString()))
            .andExpect(jsonPath("$.updateUserId").value(DEFAULT_UPDATE_USER_ID))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.toString()));
    }

    @Test
    @Transactional
    void getNonExistingEmployeeSalaryRecord() throws Exception {
        // Get the employeeSalaryRecord
        restEmployeeSalaryRecordMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingEmployeeSalaryRecord() throws Exception {
        // Initialize the database
        employeeSalaryRecordRepository.saveAndFlush(employeeSalaryRecord);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the employeeSalaryRecord
        EmployeeSalaryRecord updatedEmployeeSalaryRecord = employeeSalaryRecordRepository
            .findById(employeeSalaryRecord.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedEmployeeSalaryRecord are not directly saved in db
        em.detach(updatedEmployeeSalaryRecord);
        updatedEmployeeSalaryRecord
            .salaryRecordDate(UPDATED_SALARY_RECORD_DATE)
            .company(UPDATED_COMPANY)
            .areaName(UPDATED_AREA_NAME)
            .areaCode(UPDATED_AREA_CODE)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .birthday(UPDATED_BIRTHDAY)
            .employeeCode(UPDATED_EMPLOYEE_CODE)
            .numberOfDependents(UPDATED_NUMBER_OF_DEPENDENTS)
            .basicSalary(UPDATED_BASIC_SALARY)
            .commutingAllowance(UPDATED_COMMUTING_ALLOWANCE)
            .otherAllowance(UPDATED_OTHER_ALLOWANCE)
            .insuranceLevel(UPDATED_INSURANCE_LEVEL)
            .healthInsuranceFees(UPDATED_HEALTH_INSURANCE_FEES)
            .pensionInsuranceFees(UPDATED_PENSION_INSURANCE_FEES)
            .labourInsuranceFees(UPDATED_LABOUR_INSURANCE_FEES)
            .personalIncomeTax(UPDATED_PERSONAL_INCOME_TAX)
            .personalIncomeTaxLevel(UPDATED_PERSONAL_INCOME_TAX_LEVEL)
            .totalDeductionAmount(UPDATED_TOTAL_DEDUCTION_AMOUNT)
            .takeHomeAmount(UPDATED_TAKE_HOME_AMOUNT)
            .version(UPDATED_VERSION)
            .createUserId(UPDATED_CREATE_USER_ID)
            .createDate(UPDATED_CREATE_DATE)
            .updateUserId(UPDATED_UPDATE_USER_ID)
            .updateDate(UPDATED_UPDATE_DATE);
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(updatedEmployeeSalaryRecord);

        restEmployeeSalaryRecordMockMvc
            .perform(
                put(ENTITY_API_URL_ID, employeeSalaryRecordDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(employeeSalaryRecordDTO))
            )
            .andExpect(status().isOk());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedEmployeeSalaryRecordToMatchAllProperties(updatedEmployeeSalaryRecord);
    }

    @Test
    @Transactional
    void putNonExistingEmployeeSalaryRecord() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        employeeSalaryRecord.setId(longCount.incrementAndGet());

        // Create the EmployeeSalaryRecord
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEmployeeSalaryRecordMockMvc
            .perform(
                put(ENTITY_API_URL_ID, employeeSalaryRecordDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(employeeSalaryRecordDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchEmployeeSalaryRecord() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        employeeSalaryRecord.setId(longCount.incrementAndGet());

        // Create the EmployeeSalaryRecord
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmployeeSalaryRecordMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(employeeSalaryRecordDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamEmployeeSalaryRecord() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        employeeSalaryRecord.setId(longCount.incrementAndGet());

        // Create the EmployeeSalaryRecord
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmployeeSalaryRecordMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(employeeSalaryRecordDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateEmployeeSalaryRecordWithPatch() throws Exception {
        // Initialize the database
        employeeSalaryRecordRepository.saveAndFlush(employeeSalaryRecord);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the employeeSalaryRecord using partial update
        EmployeeSalaryRecord partialUpdatedEmployeeSalaryRecord = new EmployeeSalaryRecord();
        partialUpdatedEmployeeSalaryRecord.setId(employeeSalaryRecord.getId());

        partialUpdatedEmployeeSalaryRecord
            .employeeCode(UPDATED_EMPLOYEE_CODE)
            .numberOfDependents(UPDATED_NUMBER_OF_DEPENDENTS)
            .basicSalary(UPDATED_BASIC_SALARY)
            .commutingAllowance(UPDATED_COMMUTING_ALLOWANCE)
            .insuranceLevel(UPDATED_INSURANCE_LEVEL)
            .healthInsuranceFees(UPDATED_HEALTH_INSURANCE_FEES)
            .pensionInsuranceFees(UPDATED_PENSION_INSURANCE_FEES)
            .labourInsuranceFees(UPDATED_LABOUR_INSURANCE_FEES)
            .personalIncomeTax(UPDATED_PERSONAL_INCOME_TAX)
            .totalDeductionAmount(UPDATED_TOTAL_DEDUCTION_AMOUNT)
            .takeHomeAmount(UPDATED_TAKE_HOME_AMOUNT)
            .version(UPDATED_VERSION)
            .createUserId(UPDATED_CREATE_USER_ID);

        restEmployeeSalaryRecordMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedEmployeeSalaryRecord.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedEmployeeSalaryRecord))
            )
            .andExpect(status().isOk());

        // Validate the EmployeeSalaryRecord in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertEmployeeSalaryRecordUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedEmployeeSalaryRecord, employeeSalaryRecord),
            getPersistedEmployeeSalaryRecord(employeeSalaryRecord)
        );
    }

    @Test
    @Transactional
    void fullUpdateEmployeeSalaryRecordWithPatch() throws Exception {
        // Initialize the database
        employeeSalaryRecordRepository.saveAndFlush(employeeSalaryRecord);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the employeeSalaryRecord using partial update
        EmployeeSalaryRecord partialUpdatedEmployeeSalaryRecord = new EmployeeSalaryRecord();
        partialUpdatedEmployeeSalaryRecord.setId(employeeSalaryRecord.getId());

        partialUpdatedEmployeeSalaryRecord
            .salaryRecordDate(UPDATED_SALARY_RECORD_DATE)
            .company(UPDATED_COMPANY)
            .areaName(UPDATED_AREA_NAME)
            .areaCode(UPDATED_AREA_CODE)
            .employeeName(UPDATED_EMPLOYEE_NAME)
            .birthday(UPDATED_BIRTHDAY)
            .employeeCode(UPDATED_EMPLOYEE_CODE)
            .numberOfDependents(UPDATED_NUMBER_OF_DEPENDENTS)
            .basicSalary(UPDATED_BASIC_SALARY)
            .commutingAllowance(UPDATED_COMMUTING_ALLOWANCE)
            .otherAllowance(UPDATED_OTHER_ALLOWANCE)
            .insuranceLevel(UPDATED_INSURANCE_LEVEL)
            .healthInsuranceFees(UPDATED_HEALTH_INSURANCE_FEES)
            .pensionInsuranceFees(UPDATED_PENSION_INSURANCE_FEES)
            .labourInsuranceFees(UPDATED_LABOUR_INSURANCE_FEES)
            .personalIncomeTax(UPDATED_PERSONAL_INCOME_TAX)
            .personalIncomeTaxLevel(UPDATED_PERSONAL_INCOME_TAX_LEVEL)
            .totalDeductionAmount(UPDATED_TOTAL_DEDUCTION_AMOUNT)
            .takeHomeAmount(UPDATED_TAKE_HOME_AMOUNT)
            .version(UPDATED_VERSION)
            .createUserId(UPDATED_CREATE_USER_ID)
            .createDate(UPDATED_CREATE_DATE)
            .updateUserId(UPDATED_UPDATE_USER_ID)
            .updateDate(UPDATED_UPDATE_DATE);

        restEmployeeSalaryRecordMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedEmployeeSalaryRecord.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedEmployeeSalaryRecord))
            )
            .andExpect(status().isOk());

        // Validate the EmployeeSalaryRecord in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertEmployeeSalaryRecordUpdatableFieldsEquals(
            partialUpdatedEmployeeSalaryRecord,
            getPersistedEmployeeSalaryRecord(partialUpdatedEmployeeSalaryRecord)
        );
    }

    @Test
    @Transactional
    void patchNonExistingEmployeeSalaryRecord() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        employeeSalaryRecord.setId(longCount.incrementAndGet());

        // Create the EmployeeSalaryRecord
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEmployeeSalaryRecordMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, employeeSalaryRecordDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(employeeSalaryRecordDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchEmployeeSalaryRecord() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        employeeSalaryRecord.setId(longCount.incrementAndGet());

        // Create the EmployeeSalaryRecord
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmployeeSalaryRecordMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(employeeSalaryRecordDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamEmployeeSalaryRecord() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        employeeSalaryRecord.setId(longCount.incrementAndGet());

        // Create the EmployeeSalaryRecord
        EmployeeSalaryRecordDTO employeeSalaryRecordDTO = employeeSalaryRecordMapper.toDto(employeeSalaryRecord);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmployeeSalaryRecordMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(employeeSalaryRecordDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the EmployeeSalaryRecord in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteEmployeeSalaryRecord() throws Exception {
        // Initialize the database
        employeeSalaryRecordRepository.saveAndFlush(employeeSalaryRecord);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the employeeSalaryRecord
        restEmployeeSalaryRecordMockMvc
            .perform(delete(ENTITY_API_URL_ID, employeeSalaryRecord.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return employeeSalaryRecordRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected EmployeeSalaryRecord getPersistedEmployeeSalaryRecord(EmployeeSalaryRecord employeeSalaryRecord) {
        return employeeSalaryRecordRepository.findById(employeeSalaryRecord.getId()).orElseThrow();
    }

    protected void assertPersistedEmployeeSalaryRecordToMatchAllProperties(EmployeeSalaryRecord expectedEmployeeSalaryRecord) {
        assertEmployeeSalaryRecordAllPropertiesEquals(
            expectedEmployeeSalaryRecord,
            getPersistedEmployeeSalaryRecord(expectedEmployeeSalaryRecord)
        );
    }

    protected void assertPersistedEmployeeSalaryRecordToMatchUpdatableProperties(EmployeeSalaryRecord expectedEmployeeSalaryRecord) {
        assertEmployeeSalaryRecordAllUpdatablePropertiesEquals(
            expectedEmployeeSalaryRecord,
            getPersistedEmployeeSalaryRecord(expectedEmployeeSalaryRecord)
        );
    }
}
