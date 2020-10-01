package com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.farm;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {}
