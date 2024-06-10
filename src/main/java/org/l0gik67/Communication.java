package org.l0gik67;

import org.l0gik67.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/Learning7/api/employees";

    public List<Employee> getAllEmployees(){
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {});
        return responseEntity.getBody();
    }

    public Employee getEmployee(int id){
        Employee employee = restTemplate.getForObject(URL + "/" + id, Employee.class);
        return employee;
    }

    public void saveEmployee(Employee employee){
        if(employee.getId() == 0){
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL,employee,String.class);
        }else{
            restTemplate.put(URL,employee);
        }
    }


    public void deleteEmployee(int id){
        restTemplate.delete(URL + "/"+id);
    }

}
