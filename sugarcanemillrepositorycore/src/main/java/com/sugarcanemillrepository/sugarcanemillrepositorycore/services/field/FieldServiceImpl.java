package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.field;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.field.FieldRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {

    @Resource
    private FieldRepository fieldRepository;

    @Override
    public List<Field> findAll() {
        return fieldRepository.findAll();
    }

    @Override
    public Field createField(Field field) {
        return fieldRepository.save(field);
    }

    @Override
    public Field findFieldById(Long id) {
        return fieldRepository.getOne(id);
    }
}
