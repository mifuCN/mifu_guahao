package com.mifu.yygh.hosp.repository;

import com.mifu.yygh.model.hosp.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository  extends MongoRepository<Department,String> {
    Department findByHoscodeAndDepcode(String hoscode, String depcode);

}
