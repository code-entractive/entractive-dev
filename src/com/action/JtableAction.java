package com.action;

import java.io.IOException;
import java.util.List;

import com.dao.CrudDao;
import com.model.Student;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class JtableAction extends ActionSupport {
	
	private CrudDao dao = new CrudDao();
	public String execute() throws Exception {
	      return "success";
	   }
	private List<Student> records;
	private String result;
	private String message;
	private Student record;

	// Holds Start Page Index
	private int jtStartIndex;
	// Hold records to be displayed per Page 
	private int jtPageSize;	
	
	// Holds total record count
	private int totalRecordCount;
	
	private int studentId;	
	private String name;
	private String department;
	private String emailId;

	public String list() throws Exception {
		try {
			// Fetch Data from Student Table
			records = dao.getAllStudents(jtStartIndex, jtPageSize);
			// Get Total Record Count for Pagination
			totalRecordCount = dao.getStudentCount();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String create() throws IOException {
		record = new Student();

		record.setStudentId(studentId);
		record.setName(name);
		record.setDepartment(department);
		record.setEmailId(emailId);
	
		try {
			// Create new record
			dao.addStudent(record);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
		}
		return Action.SUCCESS;	
	}

	public String update() throws IOException {
		Student student = new Student();
		
		student.setStudentId(studentId);
		student.setName(name);
		student.setDepartment(department);
		student.setEmailId(emailId);
		
		try {
			// Update existing record
			dao.updateStudent(student);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String delete() throws IOException {
		// Delete record
		try {
			dao.deleteStudent(studentId);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public List<Student> getRecords() {
		return records;
	}

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public Student getRecord() {
		return record;
	}

	public int getJtStartIndex() {
		return jtStartIndex;
	}

	public int getJtPageSize() {
		return jtPageSize;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setRecords(List<Student> records) {
		this.records = records;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRecord(Student record) {
		this.record = record;
	}

	public void setJtStartIndex(int jtStartIndex) {
		this.jtStartIndex = jtStartIndex;
	}

	public void setJtPageSize(int jtPageSize) {
		this.jtPageSize = jtPageSize;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}