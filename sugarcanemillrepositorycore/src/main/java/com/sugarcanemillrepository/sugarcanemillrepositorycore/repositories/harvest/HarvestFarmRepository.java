package com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.harvest;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest.HarvestFarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestFarmRepository extends JpaRepository<HarvestFarm, Long> {

    @Query(nativeQuery = true,
            value = "SELECT hf.id_farm FROM harvest_farm hf WHERE hf.id_harvest = :idHarvest")
    List<Long> findFarmsIdsOfHarvest(@Param("idHarvest") Long idHarvest);
}
