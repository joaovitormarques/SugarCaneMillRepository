package com.sugarcanemillrepository.sugarcanemillrepositorycore.services;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest.Harvest;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.harvest.HarvestFarmRepository;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.services.harvest.HarvestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class HarvestServiceImplTest {

    @MockBean()
    private HarvestFarmRepository harvestFarmRepository;

    @Autowired
    HarvestService harvestService;

    @Test
    public void whenCreatingHarvestWith2FarmsShouldSaveInDB2Times() {
        // Given
        Harvest testHarvest = new Harvest();
        testHarvest.setFarmIds(Arrays.asList(2L, 3L));

        // When
        harvestService.createHarvest(testHarvest);

        // Then
        verify(harvestFarmRepository, times(2)).save(any());
    }

    @Test
    public void whenCreatingHarvestWith0FarmsShouldSaveInDB0Times() {
        // Given
        Harvest testHarvest = new Harvest();
        testHarvest.setFarmIds(Collections.emptyList());

        // When
        harvestService.createHarvest(testHarvest);

        // Then
        verify(harvestFarmRepository, times(0)).save(any());
    }
}
