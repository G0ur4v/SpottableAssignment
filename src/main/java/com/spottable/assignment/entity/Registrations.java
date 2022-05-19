package com.spottable.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Registrations")
public class Registrations {
     @Id
     @Column(name="email",length=50)
    private String email;

    @Column(name="registrationType")
    private String registrationType;

    @Column(name="userType")
    private String userType;

    @Column(name="enabled")
    private boolean enabled;
}
