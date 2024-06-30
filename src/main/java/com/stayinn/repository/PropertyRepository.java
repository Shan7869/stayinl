package com.stayinn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stayinn.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByLocationAndType(String location, String type);
    List<Property> findAll();
}