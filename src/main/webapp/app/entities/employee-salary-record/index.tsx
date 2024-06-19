import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import EmployeeSalaryRecord from './employee-salary-record';
import EmployeeSalaryRecordDetail from './employee-salary-record-detail';
import EmployeeSalaryRecordUpdate from './employee-salary-record-update';
import EmployeeSalaryRecordDeleteDialog from './employee-salary-record-delete-dialog';

const EmployeeSalaryRecordRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<EmployeeSalaryRecord />} />
    <Route path="new" element={<EmployeeSalaryRecordUpdate />} />
    <Route path=":id">
      <Route index element={<EmployeeSalaryRecordDetail />} />
      <Route path="edit" element={<EmployeeSalaryRecordUpdate />} />
      <Route path="delete" element={<EmployeeSalaryRecordDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default EmployeeSalaryRecordRoutes;
