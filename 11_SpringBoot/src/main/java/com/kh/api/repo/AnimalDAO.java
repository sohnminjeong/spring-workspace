package com.kh.api.repo;

import com.kh.api.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalDAO extends JpaRepository<Animal, Integer> {

}
