package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.mill;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill.Mill;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill.MillHarvest;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.mill.MillHarvestRepository;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.mill.MillRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MillServiceImpl implements MillService {

    @Resource
    private MillRepository millRepository;

    @Resource
    private MillHarvestRepository millHarvestRepository;

    @Override
    public List<Mill> findAll() {
        List<Mill> mills = millRepository.findAll();
        mills.forEach(mill -> mill.setHarvestIds(millHarvestRepository.findHarvestIdsOfMill(mill.getId())));
        return mills;
    }

    @Override
    public Mill createMill(Mill mill) {
        Mill millCreated = millRepository.save(mill);
        mill.getHarvestIds().forEach(harvestId -> millHarvestRepository.save(new MillHarvest(millCreated.getId(), harvestId)));
        millCreated.setHarvestIds(mill.getHarvestIds());
        return millCreated;
    }

    @Override
    public Mill findMillById(Long id) {
        Mill mill = millRepository.getOne(id);
        mill.setHarvestIds(millHarvestRepository.findHarvestIdsOfMill(mill.getId()));
        return mill;
    }
}
