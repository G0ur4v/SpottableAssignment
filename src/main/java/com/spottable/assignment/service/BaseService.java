package com.spottable.assignment.service;

import com.spottable.assignment.entity.ClientUserInvites;
import com.spottable.assignment.entity.Registrations;
import com.spottable.assignment.model.ClientCode;
import com.spottable.assignment.model.Response;
import com.spottable.assignment.repository.ClientUserInvitesRepository;
import com.spottable.assignment.repository.RegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    @Autowired
    private ClientUserInvitesRepository clientUserInvitesRepository;

    @Autowired
    private RegistrationsRepository registrationsRepository;

    public Response getDataOfClientUserInvites(){

        List<Registrations> registrationDataList =  registrationsRepository.findAll();
        int flexmoneyCount= (int) registrationDataList.stream().filter(dt -> dt.getEmail().contains("flexmoney")).count();
        int spottablCount = (int) registrationDataList.stream().filter(dt -> dt.getEmail().contains("spottabl")).count();

        List<ClientUserInvites> dataList =  clientUserInvitesRepository.findAll();
        int flexmoneyInviteCount= (int) dataList.stream().filter(dt -> dt.getInviter().contains("flexmoney")).count();
        int spottablInviteCount = (int) dataList.stream().filter(dt -> dt.getInviter().contains("spottabl")).count();

        int flexmoneyAcceptedCount= (int) dataList.stream().filter(dt -> dt.getClientcode().equalsIgnoreCase("flexmoney")&& dt.getAccepted().equalsIgnoreCase("TRUE")).count();
        int spottablAcceptedCount = (int) dataList.stream().filter(dt ->dt.getClientcode().equalsIgnoreCase("spottabl")&& dt.getAccepted().equalsIgnoreCase("TRUE")).count();

        int flexmoneyInvitesFromSpottablUserCount= (int) dataList.stream().filter(dt -> dt.getInviter().contains("flexmoney")).count();
        int spottablInvitesFromSpottablUserCount = (int) dataList.stream().filter(dt -> dt.getInviter().contains("spottabl")).count();

        return Response.builder()
                .usersInSpottabl(ClientCode.builder().flexmoney(flexmoneyCount).spottabl(spottablCount).build())
                .userInvitesFromSpttabl(ClientCode.builder().flexmoney(flexmoneyInviteCount).spottabl(spottablInviteCount).build())
                .userAcceptedInvite(ClientCode.builder().flexmoney(flexmoneyAcceptedCount).spottabl(spottablAcceptedCount).build())
                .userInvitesFromSpottablUser(ClientCode.builder().flexmoney(flexmoneyInvitesFromSpottablUserCount).spottabl(spottablInvitesFromSpottablUserCount).build())
                .build();
    }
}
