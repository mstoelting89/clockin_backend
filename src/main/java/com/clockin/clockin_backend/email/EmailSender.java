package com.clockin.clockin_backend.email;

public interface EmailSender {
    void send(String to, String email);
}
