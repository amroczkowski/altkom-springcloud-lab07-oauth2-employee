package pl.altkom.springcloud.lab07.oauth2.employeeservice.controller.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class UpdateEmployeeRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String city;
    private Long projectId;
}
