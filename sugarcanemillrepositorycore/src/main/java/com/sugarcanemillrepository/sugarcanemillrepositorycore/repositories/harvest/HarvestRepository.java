package com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.harvest;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {}
