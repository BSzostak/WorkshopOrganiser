package com.workshop.app.client.dto;

public record CreateClientRequest(String firstName,
                                  String lastName,
                                  String phoneNumber,
                                  String email) {
}
