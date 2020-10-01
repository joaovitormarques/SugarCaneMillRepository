package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.field;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;

import java.util.List;

public interface FieldService {

    List<Field> findAll();

    Field createField(Field field);

    Field findFieldById(Long id);
}
