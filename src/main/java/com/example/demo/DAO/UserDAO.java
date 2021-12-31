package com.example.demo.DAO;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserDAO extends CrudRepository<User, Integer>{
	

}
