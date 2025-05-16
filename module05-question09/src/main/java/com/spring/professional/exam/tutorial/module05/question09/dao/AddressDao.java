package com.spring.professional.exam.tutorial.module05.question09.dao;

import com.spring.professional.exam.tutorial.module05.question09.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer> {
}
