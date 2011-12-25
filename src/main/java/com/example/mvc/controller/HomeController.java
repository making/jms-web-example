package com.example.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.jms.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mvc.form.MessageForm;
import com.example.mvc.service.MessageService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);
    
    @Inject
    protected MessageService messageService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! the client locale is " + locale.toString());
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate);
        return "home";
    }
    
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ModelAttribute
    public MessageForm send(Model model) {
        return new MessageForm();
    }
    
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendOnSubmit(final MessageForm messageForm, Model model) {
        logger.debug("message={}", messageForm.getMessage());
        messageService.send(messageForm.getMessage());
        return "redirect:/send";
    }
    
    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String receive(Model model) {
        Message msg = messageService.receive();
        logger.debug("receive={}", msg);
        model.addAttribute("message", msg);
        return "receive";
    }
}
