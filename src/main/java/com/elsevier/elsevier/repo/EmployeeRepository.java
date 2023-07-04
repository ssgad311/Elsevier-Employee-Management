package com.elsevier.elsevier.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elsevier.elsevier.model.Employee;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByUsername(String username);
	
	@Query(value ="SELECT * FROM Employee t WHERE " +
            "t.employee_name LIKE CONCAT('%',:name, '%') and t.manager_id=:managerId",nativeQuery = true)
	List<Employee> findByEmployeeName(@Param("name")String name,@Param("managerId") Integer managerId);
	
	
	@Query(value ="SELECT * FROM Employee m WHERE " +
            "m.employee_username=:username and m.employee_password=:password",nativeQuery = true)
	Employee findByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
	
	@Query(value ="SELECT * FROM Employee m WHERE " +
            "m.manager_id=:managerId",nativeQuery = true)
	List<Employee> findAllEmployeesByManagerId(@Param("managerId")Integer managerId);

}
