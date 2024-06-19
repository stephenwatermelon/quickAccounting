package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.EmployeeSalaryRecordRepository;
import com.mycompany.myapp.service.EmployeeSalaryRecordService;
import com.mycompany.myapp.service.dto.EmployeeSalaryRecordDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.EmployeeSalaryRecord}.
 */
@RestController
@RequestMapping("/api/employee-salary-records")
public class EmployeeSalaryRecordResource {

    private final Logger log = LoggerFactory.getLogger(EmployeeSalaryRecordResource.class);

    private static final String ENTITY_NAME = "employeeSalaryRecord";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EmployeeSalaryRecordService employeeSalaryRecordService;

    private final EmployeeSalaryRecordRepository employeeSalaryRecordRepository;

    public EmployeeSalaryRecordResource(
        EmployeeSalaryRecordService employeeSalaryRecordService,
        EmployeeSalaryRecordRepository employeeSalaryRecordRepository
    ) {
        this.employeeSalaryRecordService = employeeSalaryRecordService;
        this.employeeSalaryRecordRepository = employeeSalaryRecordRepository;
    }

    /**
     * {@code POST  /employee-salary-records} : Create a new employeeSalaryRecord.
     *
     * @param employeeSalaryRecordDTO the employeeSalaryRecordDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new employeeSalaryRecordDTO, or with status {@code 400 (Bad Request)} if the employeeSalaryRecord has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<EmployeeSalaryRecordDTO> createEmployeeSalaryRecord(
        @Valid @RequestBody EmployeeSalaryRecordDTO employeeSalaryRecordDTO
    ) throws URISyntaxException {
        log.debug("REST request to save EmployeeSalaryRecord : {}", employeeSalaryRecordDTO);
        if (employeeSalaryRecordDTO.getId() != null) {
            throw new BadRequestAlertException("A new employeeSalaryRecord cannot already have an ID", ENTITY_NAME, "idexists");
        }
        employeeSalaryRecordDTO = employeeSalaryRecordService.save(employeeSalaryRecordDTO);
        return ResponseEntity.created(new URI("/api/employee-salary-records/" + employeeSalaryRecordDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, employeeSalaryRecordDTO.getId().toString()))
            .body(employeeSalaryRecordDTO);
    }

    /**
     * {@code PUT  /employee-salary-records/:id} : Updates an existing employeeSalaryRecord.
     *
     * @param id the id of the employeeSalaryRecordDTO to save.
     * @param employeeSalaryRecordDTO the employeeSalaryRecordDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated employeeSalaryRecordDTO,
     * or with status {@code 400 (Bad Request)} if the employeeSalaryRecordDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the employeeSalaryRecordDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeSalaryRecordDTO> updateEmployeeSalaryRecord(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody EmployeeSalaryRecordDTO employeeSalaryRecordDTO
    ) throws URISyntaxException {
        log.debug("REST request to update EmployeeSalaryRecord : {}, {}", id, employeeSalaryRecordDTO);
        if (employeeSalaryRecordDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, employeeSalaryRecordDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!employeeSalaryRecordRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        employeeSalaryRecordDTO = employeeSalaryRecordService.update(employeeSalaryRecordDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, employeeSalaryRecordDTO.getId().toString()))
            .body(employeeSalaryRecordDTO);
    }

    /**
     * {@code PATCH  /employee-salary-records/:id} : Partial updates given fields of an existing employeeSalaryRecord, field will ignore if it is null
     *
     * @param id the id of the employeeSalaryRecordDTO to save.
     * @param employeeSalaryRecordDTO the employeeSalaryRecordDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated employeeSalaryRecordDTO,
     * or with status {@code 400 (Bad Request)} if the employeeSalaryRecordDTO is not valid,
     * or with status {@code 404 (Not Found)} if the employeeSalaryRecordDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the employeeSalaryRecordDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<EmployeeSalaryRecordDTO> partialUpdateEmployeeSalaryRecord(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody EmployeeSalaryRecordDTO employeeSalaryRecordDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update EmployeeSalaryRecord partially : {}, {}", id, employeeSalaryRecordDTO);
        if (employeeSalaryRecordDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, employeeSalaryRecordDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!employeeSalaryRecordRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<EmployeeSalaryRecordDTO> result = employeeSalaryRecordService.partialUpdate(employeeSalaryRecordDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, employeeSalaryRecordDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /employee-salary-records} : get all the employeeSalaryRecords.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of employeeSalaryRecords in body.
     */
    @GetMapping("")
    public ResponseEntity<List<EmployeeSalaryRecordDTO>> getAllEmployeeSalaryRecords(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of EmployeeSalaryRecords");
        Page<EmployeeSalaryRecordDTO> page = employeeSalaryRecordService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /employee-salary-records/:id} : get the "id" employeeSalaryRecord.
     *
     * @param id the id of the employeeSalaryRecordDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the employeeSalaryRecordDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSalaryRecordDTO> getEmployeeSalaryRecord(@PathVariable("id") Long id) {
        log.debug("REST request to get EmployeeSalaryRecord : {}", id);
        Optional<EmployeeSalaryRecordDTO> employeeSalaryRecordDTO = employeeSalaryRecordService.findOne(id);
        return ResponseUtil.wrapOrNotFound(employeeSalaryRecordDTO);
    }

    /**
     * {@code DELETE  /employee-salary-records/:id} : delete the "id" employeeSalaryRecord.
     *
     * @param id the id of the employeeSalaryRecordDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeSalaryRecord(@PathVariable("id") Long id) {
        log.debug("REST request to delete EmployeeSalaryRecord : {}", id);
        employeeSalaryRecordService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
