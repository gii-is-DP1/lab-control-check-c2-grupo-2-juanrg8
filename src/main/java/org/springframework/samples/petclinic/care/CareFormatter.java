package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CareFormatter implements Formatter<Care>{

    @Autowired
    private CareService careService;

    @Override
    public String print(Care object, Locale locale) {
        return object.name;
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        Care cr = careService.getCare(text);
        if (cr == null) {
            throw new ParseException("Product type not found: " + text, 0);
        }
        return cr;
    }
    
}
