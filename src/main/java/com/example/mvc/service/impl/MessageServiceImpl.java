package com.example.mvc.service.impl;

import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory
            .getLogger(MessageServiceImpl.class);

    @Inject
    protected JmsTemplate jmsTemplate;
    @Inject
    protected Destination destination;

    @Override
    @Transactional
    public void send(final String message) {
        logger.debug("destination={}", destination);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage msg = session.createTextMessage();
                msg.setText(message);
                return msg;
            }
        });

    }

    @Override
    @Transactional
    public Message receive() {
        Message msg = jmsTemplate.receive(destination);
        return msg;
    }

}
