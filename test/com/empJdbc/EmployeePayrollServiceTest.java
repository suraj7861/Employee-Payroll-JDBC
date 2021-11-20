package com.empJdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class EmployeePayrollServiceTest {
	// test to match number of count data in data base.
	@Test
	public void RetrievedDataFromDB_MatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeePayrollData> employeePayrollData = employeePayrollService
				.readEmployeePayrollData(EmployeePayrollService.IOService.DB_IO);
		Assert.assertEquals(3, employeePayrollData.size());
	}

}
