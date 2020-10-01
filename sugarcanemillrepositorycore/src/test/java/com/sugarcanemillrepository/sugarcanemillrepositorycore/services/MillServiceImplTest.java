package com.sugarcanemillrepository.sugarcanemillrepositorycore.services;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill.Mill;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.mill.MillHarvestRepository;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.services.mill.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MillServiceImplTest {

    @MockBean()
    private MillHarvestRepository millHarvestRepository;

    @Autowired
    MillService millService;

    @Test
    public void whenCreatingMillWith3HarvestsShouldSaveInDB3Times() {
        // Given
        Mill testMill = new Mill();
        testMill.setHarvestIds(Arrays.asList(1L, 2L, 3L));

        // When
        millService.createMill(testMill);

        // Then
        verify(millHarvestRepository, times(3)).save(any());
    }

    @Test
    public void whenCreatingMillWith0HarvestsShouldSaveInDB0Times() {
        // Given
        Mill testMill = new Mill();
        testMill.setHarvestIds(Collections.emptyList());

        // When
        millService.createMill(testMill);

        // Then
        verify(millHarvestRepository, times(0)).save(any());
    }
}
