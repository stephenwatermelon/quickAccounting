import dayjs from 'dayjs';

export interface IEmployeeSalaryRecord {
  id?: number;
  salaryRecordDate?: string;
  company?: string | null;
  areaName?: string | null;
  areaCode?: number | null;
  employeeName?: string | null;
  birthday?: dayjs.Dayjs;
  employeeCode?: number | null;
  numberOfDependents?: number;
  basicSalary?: number;
  commutingAllowance?: number | null;
  otherAllowance?: number | null;
  insuranceLevel?: string | null;
  healthInsuranceFees?: number | null;
  pensionInsuranceFees?: number | null;
  labourInsuranceFees?: number | null;
  personalIncomeTax?: number | null;
  personalIncomeTaxLevel?: string | null;
  totalDeductionAmount?: number | null;
  takeHomeAmount?: number | null;
  version?: number | null;
  createUserId?: string | null;
  createDate?: dayjs.Dayjs | null;
  updateUserId?: string | null;
  updateDate?: dayjs.Dayjs | null;
}

export const defaultValue: Readonly<IEmployeeSalaryRecord> = {};
