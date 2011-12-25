package com.example.mvc.service;

import javax.jms.Message;

public interface MessageService {
    void send(String message);
    Message receive();
}
