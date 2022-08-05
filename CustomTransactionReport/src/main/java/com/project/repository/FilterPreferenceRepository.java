package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.entity.FilterPreference;


@RepositoryRestResource(path="filter")
@CrossOrigin("http://localhost:4200/")
public interface FilterPreferenceRepository extends JpaRepository<FilterPreference, Integer>{

}
