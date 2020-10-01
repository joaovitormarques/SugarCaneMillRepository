package com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.mill;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill.MillHarvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MillHarvestRepository extends JpaRepository<MillHarvest, Long> {

    @Query(nativeQuery = true,
            value = "SELECT mh.id_harvest FROM mill_harvest mh WHERE mh.id_mill = :idMill")
    List<Long> findHarvestIdsOfMill(@Param("idMill") Long idMill);
}
