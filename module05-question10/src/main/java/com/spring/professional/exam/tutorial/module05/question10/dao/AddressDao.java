package com.spring.professional.exam.tutorial.module05.question10.dao;

import com.spring.professional.exam.tutorial.module05.question10.ds.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address, Integer> {
}
