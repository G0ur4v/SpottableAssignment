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
@Table(name="clientuserinvites")
public class ClientUserInvites {

    @Id
    @Column(name="email",length=50)
    private String email;
    @Column(name="clientcode")
    private String clientcode;
     @Column(name="userType")
    private String userType;
    @Column(name="accepted")
    private String accepted;
    @Column(name="role")
    private String role;
    @Column(name="inviter")
    private String inviter;


}
