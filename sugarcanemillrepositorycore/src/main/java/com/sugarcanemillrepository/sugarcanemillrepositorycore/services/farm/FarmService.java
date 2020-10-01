package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.farm;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm.Farm;

import java.util.List;

public interface FarmService {

    List<Farm> findAll();

    Farm createFarm(Farm harvest);

    Farm findFarmById(Long id);
}
