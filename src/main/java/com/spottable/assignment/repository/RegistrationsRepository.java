package com.spottable.assignment.repository;

import com.spottable.assignment.entity.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationsRepository  extends JpaRepository<Registrations,String> {

    List<Registrations> findAll();

}
