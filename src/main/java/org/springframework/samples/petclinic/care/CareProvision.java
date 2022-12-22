package org.springframework.samples.petclinic.care;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CareProvision extends BaseEntity{   

    String userRating;
    
    @ManyToOne
    Visit visit;

    @ManyToOne  
    @NotNull
    Care care;   
}
