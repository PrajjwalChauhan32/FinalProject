package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.entity.Merchant;

@RepositoryRestResource(path="merchant")
@CrossOrigin("http://localhost:4200/")
public interface MerchantRepository extends JpaRepository<Merchant, Integer>{

}
