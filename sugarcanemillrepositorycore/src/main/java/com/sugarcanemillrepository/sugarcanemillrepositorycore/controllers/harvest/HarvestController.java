package com.sugarcanemillrepository.sugarcanemillrepositorycore.controllers.harvest;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest.Harvest;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.responseWrapper.ResponseWrapper;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.services.harvest.HarvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/harvest")
@RestController
public class HarvestController {

    public static final int OK_CODE = 200;
    public static final String SUCCESS_MESSAGE = "success";

    @Autowired
    private HarvestService harvestService;

    @GetMapping()
    public ResponseWrapper<List<Harvest>> getAllHarvests() {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, harvestService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseWrapper<Harvest> getHarvestById(@PathVariable Long id) {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, harvestService.findHarvestById(id)
        );
    }

    @PostMapping()
    public ResponseWrapper<Harvest> newHarvest(@RequestBody Harvest newHarvest) throws URISyntaxException {
        Harvest createdHarvest = harvestService.createHarvest(newHarvest);
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, createdHarvest
        );
    }
}
