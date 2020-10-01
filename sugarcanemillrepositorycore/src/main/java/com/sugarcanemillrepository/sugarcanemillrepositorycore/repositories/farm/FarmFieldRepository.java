package com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.farm;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm.FarmField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmFieldRepository extends JpaRepository<FarmField, Long> {

    @Query(nativeQuery = true,
            value = "SELECT ff.id_field FROM farm_field ff WHERE ff.id_farm = :idFarm")
    List<Long> findFieldsIdsOfFarm(@Param("idFarm") Long idFarm);
}
