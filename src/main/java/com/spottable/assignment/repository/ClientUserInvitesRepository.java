package com.spottable.assignment.repository;


import com.spottable.assignment.entity.ClientUserInvites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientUserInvitesRepository extends JpaRepository<ClientUserInvites,String> {
    List<ClientUserInvites> findAll();

}
