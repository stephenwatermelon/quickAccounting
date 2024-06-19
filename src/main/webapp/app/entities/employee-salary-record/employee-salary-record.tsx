import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, TextFormat, getPaginationState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSort, faSortUp, faSortDown } from '@fortawesome/free-solid-svg-icons';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ASC, DESC, ITEMS_PER_PAGE, SORT } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntities } from './employee-salary-record.reducer';

export const EmployeeSalaryRecord = () => {
  const dispatch = useAppDispatch();

  const pageLocation = useLocation();
  const navigate = useNavigate();

  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getPaginationState(pageLocation, ITEMS_PER_PAGE, 'id'), pageLocation.search),
  );

  const employeeSalaryRecordList = useAppSelector(state => state.employeeSalaryRecord.entities);
  const loading = useAppSelector(state => state.employeeSalaryRecord.loading);
  const totalItems = useAppSelector(state => state.employeeSalaryRecord.totalItems);

  const getAllEntities = () => {
    dispatch(
      getEntities({
        page: paginationState.activePage - 1,
        size: paginationState.itemsPerPage,
        sort: `${paginationState.sort},${paginationState.order}`,
      }),
    );
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`;
    if (pageLocation.search !== endURL) {
      navigate(`${pageLocation.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  useEffect(() => {
    const params = new URLSearchParams(pageLocation.search);
    const page = params.get('page');
    const sort = params.get(SORT);
    if (page && sort) {
      const sortSplit = sort.split(',');
      setPaginationState({
        ...paginationState,
        activePage: +page,
        sort: sortSplit[0],
        order: sortSplit[1],
      });
    }
  }, [pageLocation.search]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === ASC ? DESC : ASC,
      sort: p,
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage,
    });

  const handleSyncList = () => {
    sortEntities();
  };

  const getSortIconByFieldName = (fieldName: string) => {
    const sortFieldName = paginationState.sort;
    const order = paginationState.order;
    if (sortFieldName !== fieldName) {
      return faSort;
    } else {
      return order === ASC ? faSortUp : faSortDown;
    }
  };

  return (
    <div>
      <h2 id="employee-salary-record-heading" data-cy="EmployeeSalaryRecordHeading">
        <Translate contentKey="quickAccountingApp.employeeSalaryRecord.home.title">Employee Salary Records</Translate>
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} />{' '}
            <Translate contentKey="quickAccountingApp.employeeSalaryRecord.home.refreshListLabel">Refresh List</Translate>
          </Button>
          <Link
            to="/employee-salary-record/new"
            className="btn btn-primary jh-create-entity"
            id="jh-create-entity"
            data-cy="entityCreateButton"
          >
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="quickAccountingApp.employeeSalaryRecord.home.createLabel">Create new Employee Salary Record</Translate>
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {employeeSalaryRecordList && employeeSalaryRecordList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.id">ID</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('id')} />
                </th>
                <th className="hand" onClick={sort('salaryRecordDate')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.salaryRecordDate">Salary Record Date</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('salaryRecordDate')} />
                </th>
                <th className="hand" onClick={sort('company')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.company">Company</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('company')} />
                </th>
                <th className="hand" onClick={sort('areaName')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.areaName">Area Name</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('areaName')} />
                </th>
                <th className="hand" onClick={sort('employeeName')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.employeeName">Employee Name</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('employeeName')} />
                </th>
                <th className="hand" onClick={sort('birthday')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.birthday">Birthday</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('birthday')} />
                </th>
                <th className="hand" onClick={sort('numberOfDependents')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.numberOfDependents">Number Of Dependents</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('numberOfDependents')} />
                </th>
                <th className="hand" onClick={sort('basicSalary')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.basicSalary">Basic Salary</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('basicSalary')} />
                </th>
                <th className="hand" onClick={sort('commutingAllowance')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.commutingAllowance">Commuting Allowance</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('commutingAllowance')} />
                </th>
                <th className="hand" onClick={sort('otherAllowance')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.otherAllowance">Other Allowance</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('otherAllowance')} />
                </th>

                <th className="hand" onClick={sort('healthInsuranceFees')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.healthInsuranceFees">Health Insurance Fees</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('healthInsuranceFees')} />
                </th>
                <th className="hand" onClick={sort('pensionInsuranceFees')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.pensionInsuranceFees">Pension Insurance Fees</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('pensionInsuranceFees')} />
                </th>
                <th className="hand" onClick={sort('labourInsuranceFees')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.labourInsuranceFees">Labour Insurance Fees</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('labourInsuranceFees')} />
                </th>
                <th className="hand" onClick={sort('personalIncomeTax')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.personalIncomeTax">Personal Income Tax</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('personalIncomeTax')} />
                </th>
                <th className="hand" onClick={sort('totalDeductionAmount')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.totalDeductionAmount">Total Deduction Amount</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('totalDeductionAmount')} />
                </th>
                <th className="hand" onClick={sort('takeHomeAmount')}>
                  <Translate contentKey="quickAccountingApp.employeeSalaryRecord.takeHomeAmount">Take Home Amount</Translate>{' '}
                  <FontAwesomeIcon icon={getSortIconByFieldName('takeHomeAmount')} />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {employeeSalaryRecordList.map((employeeSalaryRecord, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/employee-salary-record/${employeeSalaryRecord.id}`} color="link" size="sm">
                      {employeeSalaryRecord.id}
                    </Button>
                  </td>
                  <td>{employeeSalaryRecord.salaryRecordDate}</td>
                  <td>{employeeSalaryRecord.company}</td>
                  <td>{employeeSalaryRecord.areaName}</td>
                  <td>{employeeSalaryRecord.employeeName}</td>
                  <td>
                    {employeeSalaryRecord.birthday ? (
                      <TextFormat type="date" value={employeeSalaryRecord.birthday} format={APP_LOCAL_DATE_FORMAT} />
                    ) : null}
                  </td>
                  <td>{employeeSalaryRecord.numberOfDependents}</td>
                  <td>{employeeSalaryRecord.basicSalary}</td>
                  <td>{employeeSalaryRecord.commutingAllowance}</td>
                  <td>{employeeSalaryRecord.otherAllowance}</td>

                  <td>{employeeSalaryRecord.healthInsuranceFees}</td>
                  <td>{employeeSalaryRecord.pensionInsuranceFees}</td>
                  <td>{employeeSalaryRecord.labourInsuranceFees}</td>
                  <td>{employeeSalaryRecord.personalIncomeTax}</td>
                  <td>{employeeSalaryRecord.totalDeductionAmount}</td>
                  <td>{employeeSalaryRecord.takeHomeAmount}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button
                        tag={Link}
                        to={`/employee-salary-record/${employeeSalaryRecord.id}`}
                        color="info"
                        size="sm"
                        data-cy="entityDetailsButton"
                      >
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/employee-salary-record/${employeeSalaryRecord.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button
                        onClick={() =>
                          (window.location.href = `/employee-salary-record/${employeeSalaryRecord.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`)
                        }
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && (
            <div className="alert alert-warning">
              <Translate contentKey="quickAccountingApp.employeeSalaryRecord.home.notFound">No Employee Salary Records found</Translate>
            </div>
          )
        )}
      </div>
      {totalItems ? (
        <div className={employeeSalaryRecordList && employeeSalaryRecordList.length > 0 ? '' : 'd-none'}>
          <div className="justify-content-center d-flex">
            <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} i18nEnabled />
          </div>
          <div className="justify-content-center d-flex">
            <JhiPagination
              activePage={paginationState.activePage}
              onSelect={handlePagination}
              maxButtons={5}
              itemsPerPage={paginationState.itemsPerPage}
              totalItems={totalItems}
            />
          </div>
        </div>
      ) : (
        ''
      )}
    </div>
  );
};

export default EmployeeSalaryRecord;
