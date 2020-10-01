package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.farm;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm.Farm;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm.FarmField;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.farm.FarmFieldRepository;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.farm.FarmRepository;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.field.FieldRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    @Resource
    private FarmRepository farmRepository;

    @Resource
    private FarmFieldRepository farmFieldRepository;

    @Resource
    private FieldRepository fieldRepository;

    @Override
    public List<Farm> findAll() {
        List<Farm> farms = farmRepository.findAll();
        farms.forEach(farm -> {
            List<Field> fieldsListFromIds = getFieldsListFromIds(farmFieldRepository.findFieldsIdsOfFarm(farm.getId()));
            farm.setFields(fieldsListFromIds);
        });
        return farms;
    }

    @Override
    public Farm createFarm(Farm farm) {
        Farm createdFarm =  farmRepository.save(farm);
        createdFarm.getFields()
                .forEach(field -> farmFieldRepository.save(new FarmField(createdFarm.getId(), field.getId())));
        return createdFarm;
    }

    @Override
    public Farm findFarmById(Long id) {
        Farm farm = farmRepository.getOne(id);
        List<Field> fieldsListFromIds = getFieldsListFromIds(farmFieldRepository.findFieldsIdsOfFarm(farm.getId()));
        farm.setFields(fieldsListFromIds);
        return farm;
    }

    private List<Field> getFieldsListFromIds(List<Long> ids) {
        List<Field> farms = new ArrayList<>();
        ids.forEach(id -> farms.add(fieldRepository.getOne(id)));
        return farms;
    }
}
