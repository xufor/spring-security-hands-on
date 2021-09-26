package com.assignment.api.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableRowResponse {

	private int empId;
	private String empName;
	private int deptId;
	private String deptName;

}
