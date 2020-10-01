package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.harvest;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest.Harvest;

import java.util.List;

public interface HarvestService {

    List<Harvest> findAll();

    Harvest createHarvest(Harvest harvest);

    Harvest findHarvestById(Long id);
}
