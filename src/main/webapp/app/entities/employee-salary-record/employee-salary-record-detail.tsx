import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, UncontrolledTooltip, Row, Col } from 'reactstrap';
import { Translate, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './employee-salary-record.reducer';

export const EmployeeSalaryRecordDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const employeeSalaryRecordEntity = useAppSelector(state => state.employeeSalaryRecord.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="employeeSalaryRecordDetailsHeading">
          <Translate contentKey="quickAccountingApp.employeeSalaryRecord.detail.title">EmployeeSalaryRecord</Translate>
        </h2>
        <dl className="jh-entity-details">
          <Row>
            <Col md="3">
              <dt>
                <span id="id">
                  <Translate contentKey="global.field.id">ID</Translate>
                </span>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.id}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="salaryRecordDate">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.salaryRecordDate">Salary Record Date</Translate>
                </span>
                <UncontrolledTooltip target="salaryRecordDate">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.salaryRecordDate" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.salaryRecordDate}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="company">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.company">Company</Translate>
                </span>
                <UncontrolledTooltip target="company">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.company" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.company}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="areaName">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.areaName">Area Name</Translate>
                </span>
                <UncontrolledTooltip target="areaName">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.areaName" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.areaName}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="birthday">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.birthday">Birthday</Translate>
                </span>
                <UncontrolledTooltip target="birthday">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.birthday" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>
                {employeeSalaryRecordEntity.birthday ? (
                  <TextFormat value={employeeSalaryRecordEntity.birthday} type="date" format={APP_LOCAL_DATE_FORMAT} />
                ) : null}
              </dd>
            </Col>
          </Row>

          <Row>
            <Col md="3">
              <dt>
                <span id="numberOfDependents">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.numberOfDependents">Number Of Dependents</Translate>
                </span>
                <UncontrolledTooltip target="numberOfDependents">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.numberOfDependents" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.numberOfDependents}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="basicSalary">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.basicSalary">Basic Salary</Translate>
                </span>
                <UncontrolledTooltip target="basicSalary">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.basicSalary" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.basicSalary}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="commutingAllowance">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.commutingAllowance">Commuting Allowance</Translate>
                </span>
                <UncontrolledTooltip target="commutingAllowance">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.commutingAllowance" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.commutingAllowance}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="otherAllowance">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.otherAllowance">Other Allowance</Translate>
                </span>
                <UncontrolledTooltip target="otherAllowance">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.otherAllowance" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.otherAllowance}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="healthInsuranceFees">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.healthInsuranceFees">Health Insurance Fees</Translate>
                </span>
                <UncontrolledTooltip target="healthInsuranceFees">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.healthInsuranceFees" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.healthInsuranceFees}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="pensionInsuranceFees">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.pensionInsuranceFees">Pension Insurance Fees</Translate>
                </span>
                <UncontrolledTooltip target="pensionInsuranceFees">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.pensionInsuranceFees" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.pensionInsuranceFees}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="labourInsuranceFees">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.labourInsuranceFees">Labour Insurance Fees</Translate>
                </span>
                <UncontrolledTooltip target="labourInsuranceFees">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.labourInsuranceFees" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.labourInsuranceFees}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="personalIncomeTax">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.personalIncomeTax">Personal Income Tax</Translate>
                </span>
                <UncontrolledTooltip target="personalIncomeTax">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.personalIncomeTax" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.personalIncomeTax}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="totalDeductionAmount">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.totalDeductionAmount">Total Deduction Amount</Translate>
                </span>
                <UncontrolledTooltip target="totalDeductionAmount">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.totalDeductionAmount" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.totalDeductionAmount}</dd>
            </Col>
          </Row>
          <Row>
            <Col md="3">
              <dt>
                <span id="takeHomeAmount">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.takeHomeAmount">Take Home Amount</Translate>
                </span>
                <UncontrolledTooltip target="takeHomeAmount">
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.help.takeHomeAmount" />
                </UncontrolledTooltip>
              </dt>
            </Col>
            <Col md="9">
              <dd>{employeeSalaryRecordEntity.takeHomeAmount}</dd>
            </Col>
          </Row>

        </dl>
        <Button tag={Link} to="/employee-salary-record" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/employee-salary-record/${employeeSalaryRecordEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default EmployeeSalaryRecordDetail;
