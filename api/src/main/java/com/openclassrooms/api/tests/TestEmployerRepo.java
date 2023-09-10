package com.openclassrooms.api.tests;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.repository.EmployeeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static junit.framework.TestCase.assertEquals;
@DataJpaTest
public class TestEmployerRepo {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setRole("Developer");
        entityManager.persist(employee);
        entityManager.flush();

        Employee savedEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        assertEquals("John Doe", savedEmployee.getName());
        assertEquals("Developer", savedEmployee.getRole());
    }
}
