package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "care")
public class Care extends BaseEntity{

    @Size(min = 3, max = 40)
    @NotBlank
    @Column(name = "name", unique = true)
    String name;

    @Min(1)
    @Max(121)
    int careDuration;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinTable(name = "cares_type", joinColumns = @JoinColumn(name = "care_id"),
			inverseJoinColumns = @JoinColumn(name = "type_id"))
    Set<PetType> compatiblePetTypes;
}
