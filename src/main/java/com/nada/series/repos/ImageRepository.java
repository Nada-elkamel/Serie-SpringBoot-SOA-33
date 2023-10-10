package com.nada.series.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nada.series.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
