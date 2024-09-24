package com.mahmood.firstrestapi.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class InternationalizationController {

    private MessageSource messageSource;

    public InternationalizationController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/helloWorld")
    public String helloWorld(){

        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message",
                null,
                "Default Message",
                locale);
//        return "Hello World";
    }
}
