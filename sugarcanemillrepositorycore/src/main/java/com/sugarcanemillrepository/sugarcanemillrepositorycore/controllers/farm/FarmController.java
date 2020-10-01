package com.sugarcanemillrepository.sugarcanemillrepositorycore.controllers.farm;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm.Farm;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.responseWrapper.ResponseWrapper;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.services.farm.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/farm")
@RestController
public class FarmController {

    public static final int OK_CODE = 200;
    public static final String SUCCESS_MESSAGE = "success";

    @Autowired
    private FarmService farmService;

    @GetMapping()
    public ResponseWrapper<List<Farm>> getAllFarms() {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, farmService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseWrapper<Farm> getFarmById(@PathVariable Long id) {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, farmService.findFarmById(id)
        );
    }

    @PostMapping()
    public ResponseWrapper<Farm> newFarm(@RequestBody Farm newFarm) throws URISyntaxException {
        Farm createdFarm = farmService.createFarm(newFarm);
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, createdFarm
        );
    }
}
