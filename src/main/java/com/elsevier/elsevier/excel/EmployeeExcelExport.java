package com.elsevier.elsevier.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.elsevier.elsevier.model.Employee;

public class EmployeeExcelExport {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Employee> employeeList;
	
	public EmployeeExcelExport(List<Employee> employeeList) {
		this.employeeList = employeeList;
		workbook = new XSSFWorkbook();
	}
	
	private void writeHeaderLines() {
		sheet = workbook.createSheet("Employees");
		
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		createCell(row, 0, "ID ", style);
		createCell(row, 1, "Name ", style);
		createCell(row, 2, "Department ", style);
		createCell(row, 3, "Designation ", style);
		createCell(row, 4, "Location ", style);
		createCell(row, 5, "Mobile No ", style);
		createCell(row, 6, "Email Id ", style);
		createCell(row, 7, "Gender ", style);
		createCell(row, 8, "Salary ", style);
	}
	
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
	
	private void writeDataLines() {
		int rowCount = 1;
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for(Employee employee : employeeList) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			
			createCell(row, columnCount++, employee.getId(), style);
			createCell(row, columnCount++, employee.getName(), style);
			createCell(row, columnCount++, employee.getDepartment(), style);
			createCell(row, columnCount++, employee.getDesignation(), style);
			createCell(row, columnCount++, employee.getLocation(), style);
			createCell(row, columnCount++, employee.getMobileNo(), style);
			createCell(row, columnCount++, employee.getEmailId(), style);
			createCell(row, columnCount++, employee.getGender(), style);
			createCell(row, columnCount++, employee.getSalary(), style);		
		}		
	}
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLines();
		writeDataLines();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
		outputStream.close();
	}
}
