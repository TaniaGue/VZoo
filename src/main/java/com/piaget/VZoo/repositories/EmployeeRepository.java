
package com.piaget.VZoo.repositories;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    public List<Employee> findByName(String nome);
    public List<Employee> findByFunction(String function);
    Employee findById(long id);
}
