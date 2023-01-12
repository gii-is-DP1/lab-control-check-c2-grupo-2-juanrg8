package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
// TEST 5
@Component
public class CareFormatter implements Formatter<Care>{

    
    private CareService service;

    @Autowired
    public CareFormatter(CareService service) {
        this.service = service;
    }

    @Override
    public String print(Care object, Locale locale) {
        return object.name;
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        Care care = service.getCare(text);
        if (care == null) throw new ParseException("Care not found",0);
        return care;
    }
    
}
