package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
