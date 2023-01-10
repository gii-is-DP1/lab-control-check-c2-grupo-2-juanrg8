package org.springframework.samples.petclinic.care;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CareController {
    
    CareService service;
    @Autowired
    public CareController(CareService service) {
        this.service = service;
    }

    @PostMapping("/visit/{visitId}/cares/create")
    public ModelAndView process(@PathParam("visitId") Integer visitId, @Valid CareProvision care, BindingResult br) throws UnfeasibleCareException, NonCompatibleCaresException {
        ModelAndView res = new ModelAndView();
        if(br.hasErrors()) {
            res.setViewName("cares/createOrUpdateProvidedCareForm");
        } else {
            service.save(care);
            res.setViewName("redirect:/");
        }
        return res;
    }

}
