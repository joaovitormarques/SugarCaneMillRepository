package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.harvest;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest.Harvest;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest.HarvestFarm;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.harvest.HarvestFarmRepository;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.harvest.HarvestRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HarvestServiceImpl implements HarvestService {

    @Resource
    private HarvestRepository harvestRepository;

    @Resource
    private HarvestFarmRepository harvestFarmRepository;

    @Override
    public List<Harvest> findAll() {
        List<Harvest> harvests = harvestRepository.findAll();
        harvests.forEach(harvest -> harvest.setFarmIds(harvestFarmRepository.findFarmsIdsOfHarvest(harvest.getId())));
        return harvests;
    }

    @Override
    public Harvest createHarvest(Harvest harvest) {
        Harvest harvestCreated = harvestRepository.save(harvest);
        harvest.getFarmIds().forEach(farmId -> harvestFarmRepository.save(new HarvestFarm(harvestCreated.getId(), farmId)));
        harvestCreated.setFarmIds(harvest.getFarmIds());
        return harvestCreated;
    }

    @Override
    public Harvest findHarvestById(Long id) {
        Harvest harvest = harvestRepository.getOne(id);
        harvest.setFarmIds(harvestFarmRepository.findFarmsIdsOfHarvest(harvest.getId()));
        return harvest;
    }
}
