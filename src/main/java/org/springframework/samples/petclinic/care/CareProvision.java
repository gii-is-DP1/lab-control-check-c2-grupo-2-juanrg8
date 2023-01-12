package org.springframework.samples.petclinic.care;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;
// TEST 2 
@Entity
@Getter
@Setter
public class CareProvision{   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Pattern(regexp = "^Care rated with [0-9] stars.*$")
    String userRating;
    
    @ManyToOne(optional = true)
    Visit visit;

    @ManyToOne
    @NotNull
    Care care;  
}
