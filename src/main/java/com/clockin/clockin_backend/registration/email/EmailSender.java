package com.clockin.clockin_backend.registration.email;

public interface EmailSender {
    void send(String to, String email);
}
