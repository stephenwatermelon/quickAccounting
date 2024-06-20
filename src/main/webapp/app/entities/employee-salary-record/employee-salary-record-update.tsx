import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText, UncontrolledTooltip } from 'reactstrap';
import { isNumber, Translate, translate, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IEmployeeSalaryRecord } from 'app/shared/model/employee-salary-record.model';
import { getEntity, updateEntity, createEntity, reset } from './employee-salary-record.reducer';

export const EmployeeSalaryRecordUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const employeeSalaryRecordEntity = useAppSelector(state => state.employeeSalaryRecord.entity);
  const loading = useAppSelector(state => state.employeeSalaryRecord.loading);
  const updating = useAppSelector(state => state.employeeSalaryRecord.updating);
  const updateSuccess = useAppSelector(state => state.employeeSalaryRecord.updateSuccess);

  const today = new Date();
  const fortyYearsAgo = new Date(today.getFullYear() - 40, today.getMonth(), today.getDate());
  // 手动格式化日期为 'YYYY-MM-DD'
  const year = fortyYearsAgo.getFullYear();
  const month = String(fortyYearsAgo.getMonth() + 1).padStart(2, '0'); // 月份是从0开始的，所以需要加1
  const day = String(fortyYearsAgo.getDate()).padStart(2, '0');

  const defaultDate = `${year}-${month}-${day}`;

  const handleClose = newId => {
    if (newId) {
      navigate(`/employee-salary-record/${newId}`);
    } else {
      navigate('/employee-salary-record');
    }
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose(employeeSalaryRecordEntity.id);
    }
  }, [updateSuccess]);

  // eslint-disable-next-line complexity
  const saveEntity = values => {
    if (values.id !== undefined && typeof values.id !== 'number') {
      values.id = Number(values.id);
    }
    if (values.areaCode !== undefined && typeof values.areaCode !== 'number') {
      values.areaCode = Number(values.areaCode);
    }
    if (values.employeeCode !== undefined && typeof values.employeeCode !== 'number') {
      values.employeeCode = Number(values.employeeCode);
    }
    if (values.numberOfDependents !== undefined && typeof values.numberOfDependents !== 'number') {
      values.numberOfDependents = Number(values.numberOfDependents);
    }
    if (values.basicSalary !== undefined && typeof values.basicSalary !== 'number') {
      values.basicSalary = Number(values.basicSalary);
    }
    if (values.commutingAllowance !== undefined && typeof values.commutingAllowance !== 'number') {
      values.commutingAllowance = Number(values.commutingAllowance);
    }
    if (values.otherAllowance !== undefined && typeof values.otherAllowance !== 'number') {
      values.otherAllowance = Number(values.otherAllowance);
    }
    if (values.healthInsuranceFees !== undefined && typeof values.healthInsuranceFees !== 'number') {
      values.healthInsuranceFees = Number(values.healthInsuranceFees);
    }
    if (values.pensionInsuranceFees !== undefined && typeof values.pensionInsuranceFees !== 'number') {
      values.pensionInsuranceFees = Number(values.pensionInsuranceFees);
    }
    if (values.labourInsuranceFees !== undefined && typeof values.labourInsuranceFees !== 'number') {
      values.labourInsuranceFees = Number(values.labourInsuranceFees);
    }
    if (values.personalIncomeTax !== undefined && typeof values.personalIncomeTax !== 'number') {
      values.personalIncomeTax = Number(values.personalIncomeTax);
    }
    if (values.totalDeductionAmount !== undefined && typeof values.totalDeductionAmount !== 'number') {
      values.totalDeductionAmount = Number(values.totalDeductionAmount);
    }
    if (values.takeHomeAmount !== undefined && typeof values.takeHomeAmount !== 'number') {
      values.takeHomeAmount = Number(values.takeHomeAmount);
    }
    if (values.version !== undefined && typeof values.version !== 'number') {
      values.version = Number(values.version);
    }
    values.createDate = convertDateTimeToServer(values.createDate);
    values.updateDate = convertDateTimeToServer(values.updateDate);

    const entity = {
      ...employeeSalaryRecordEntity,
      ...values,
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          createDate: displayDefaultDateTime(),
          updateDate: displayDefaultDateTime(),
        }
      : {
          ...employeeSalaryRecordEntity,
          createDate: convertDateTimeFromServer(employeeSalaryRecordEntity.createDate),
          updateDate: convertDateTimeFromServer(employeeSalaryRecordEntity.updateDate),
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="quickAccountingApp.employeeSalaryRecord.home.createOrEditLabel" data-cy="EmployeeSalaryRecordCreateUpdateHeading">
            <Translate contentKey="quickAccountingApp.employeeSalaryRecord.home.createOrEditLabel">
              Create or edit a EmployeeSalaryRecord
            </Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="employee-salary-record-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              ) : null}
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.company')}
                id="employee-salary-record-company"
                name="company"
                data-cy="company"
                type="text"
              />
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.employeeName')}
                id="employee-salary-record-employeeName"
                name="employeeName"
                data-cy="employeeName"
                type="text"
              />
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.salaryRecordDate')}
                id="employee-salary-record-salaryRecordDate"
                name="salaryRecordDate"
                data-cy="salaryRecordDate"
                type="select"
                defaultValue="06"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              >
                <option value="05">05</option>
                <option value="06">06</option>
              </ValidatedField>
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.areaName')}
                id="employee-salary-record-areaName"
                name="areaName"
                data-cy="areaName"
                type="select"
                defaultValue="東京"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              >
                <option value="東京">東京</option>
                <option value="千葉">千葉</option>
                <option value="神奈川">神奈川</option>
                <option value="埼玉">埼玉</option>
                <option value="青森">青森</option>
                <option value="秋田">秋田</option>
                <option value="大阪">大阪</option>
              </ValidatedField>
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.birthday')}
                id="employee-salary-record-birthday"
                name="birthday"
                data-cy="birthday"
                type="date"
                defaultValue={defaultDate}
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <UncontrolledTooltip target="birthdayLabel">
                <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.birthday" />
              </UncontrolledTooltip>
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.areaCode')}
                id="employee-salary-record-areaCode"
                name="areaCode"
                data-cy="areaCode"
                type="select"
                defaultValue="1"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              >
                <option value="1">有</option>
                <option value="0">无</option>
              </ValidatedField>
              <UncontrolledTooltip target="areaCodeLabel">
                <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.areaCode" />
              </UncontrolledTooltip>
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.numberOfDependents')}
                id="employee-salary-record-numberOfDependents"
                name="numberOfDependents"
                data-cy="numberOfDependents"
                type="select"
                defaultValue="0"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              >
                {Array.from({ length: 8 }, (_, i) => (
                  <option key={i} value={i}>
                    {i}
                  </option>
                ))}
              </ValidatedField>
              <UncontrolledTooltip target="numberOfDependentsLabel">
                <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.numberOfDependents" />
              </UncontrolledTooltip>
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.basicSalary')}
                id="employee-salary-record-basicSalary"
                name="basicSalary"
                data-cy="basicSalary"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <UncontrolledTooltip target="basicSalaryLabel">
                <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.basicSalary" />
              </UncontrolledTooltip>
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.commutingAllowance')}
                id="employee-salary-record-commutingAllowance"
                name="commutingAllowance"
                data-cy="commutingAllowance"
                type="text"
              />
              <UncontrolledTooltip target="commutingAllowanceLabel">
                <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.commutingAllowance" />
              </UncontrolledTooltip>
              <ValidatedField
                label={translate('quickAccountingApp.employeeSalaryRecord.otherAllowance')}
                id="employee-salary-record-otherAllowance"
                name="otherAllowance"
                data-cy="otherAllowance"
                type="text"
              />
              <UncontrolledTooltip target="otherAllowanceLabel">
                <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.otherAllowance" />
              </UncontrolledTooltip>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/employee-salary-record" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default EmployeeSalaryRecordUpdate;
