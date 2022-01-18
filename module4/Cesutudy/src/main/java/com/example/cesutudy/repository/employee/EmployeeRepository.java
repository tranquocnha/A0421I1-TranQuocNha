package com.example.cesutudy.repository.employee;

import com.example.cesutudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT employee_name FROM employee " +
            " where employee_name like %:name% ", nativeQuery = true)
    Set<String> selectName(@Param("name") String nameEmp);

    @Query(value = "SELECT * FROM employee " +
            " where employee_name like %:nameEmp% ", nativeQuery = true)
    Page<Employee> searchName(@Param("nameEmp") String nameEmp, Pageable pageable);

    Boolean existsByEmployeeId(int id);
}
