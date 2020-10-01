package com.sugarcanemillrepository.sugarcanemillrepositorycore.services;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm.Farm;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.farm.FarmFieldRepository;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.services.farm.FarmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class FarmServiceImplTest {

    @MockBean()
    private FarmFieldRepository farmFieldRepository;

    @Autowired
    FarmService farmService;

    @Test
    public void whenCreatingFarmWith1FieldShouldSaveInDB1Time() {
        // Given
        Farm testFarm = new Farm();
        testFarm.setFields(Collections.singletonList(new Field()));

        // When
        farmService.createFarm(testFarm);

        // Then
        verify(farmFieldRepository, times(1)).save(any());
    }

    @Test
    public void whenCreatingFarmWith0FieldsShouldSaveInDB0Times() {
        // Given
        Farm testFarm = new Farm();
        testFarm.setFields(Collections.emptyList());

        // When
        farmService.createFarm(testFarm);

        // Then
        verify(farmFieldRepository, times(0)).save(any());
    }
}
