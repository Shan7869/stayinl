package com.stayinn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stayinn.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {}
