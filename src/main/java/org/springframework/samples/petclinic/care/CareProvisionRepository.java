package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Repository;

@Repository
public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
	@Query("SELECT c FROM Care c")
    List<Care> findAllCares();
    @Query("SELECT c FROM Care c WHERE :type MEMBER OF c.compatiblePetTypes AND NOT (:care MEMBER OF c.incompatibleCares)")
    List<Care> findCompatibleCares(@Param("type") PetType petType, @Param("care") Care additionalCare);
    @Query("SELECT c FROM Care c WHERE c.name = ?1")
    Care findCareByName(String name);
    @Query("SELECT c FROM CareProvision c WHERE c.visit.id = ?1")
    List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
    @Query("SELECT c FROM CareProvision c")
    Page<CareProvision> findAllPaginatedCareProvisions(Pageable p);
}
