package com.spottable.assignment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

private ClientCode usersInSpottabl;
private ClientCode  userInvitesFromSpttabl;
private ClientCode userAcceptedInvite;
private ClientCode userInvitesFromSpottablUser;

}
