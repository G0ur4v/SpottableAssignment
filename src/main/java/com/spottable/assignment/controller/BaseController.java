package com.spottable.assignment.controller;

import com.spottable.assignment.model.Response;
import com.spottable.assignment.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@Slf4j
@RestController
public class BaseController {


    @Autowired
    private BaseService clientUserInvitesService;


    @GetMapping(value = "/getDataJson")
    public Response getUsersOnSpottablInJsonFormat(HttpServletResponse servletResponse) throws IOException {
        return clientUserInvitesService.getDataOfClientUserInvites();

    }

    @GetMapping(value = "/getData", produces = "text/csv")
    public void getUsersOnSpottabl1CsvFormat(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"response.csv\"");
        writeResponseToCsv(servletResponse.getWriter());

    }

    public void writeResponseToCsv(Writer writer) {
        Response response = clientUserInvitesService.getDataOfClientUserInvites();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord(response.getUserAcceptedInvite(), response.getUserInvitesFromSpottablUser(),
                    response.getUserInvitesFromSpttabl(), response.getUsersInSpottabl());

        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }

    }
}
