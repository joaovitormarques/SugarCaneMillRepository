package com.sugarcanemillrepository.sugarcanemillrepositorycore.controllers.mill;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill.Mill;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.responseWrapper.ResponseWrapper;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.services.mill.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/mill")
@RestController
public class MillController {

    public static final int OK_CODE = 200;
    public static final String SUCCESS_MESSAGE = "success";

    @Autowired
    private MillService millService;

    @GetMapping()
    public ResponseWrapper<List<Mill>> getAllMills() {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, millService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseWrapper<Mill> getMillById(@PathVariable Long id) {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, millService.findMillById(id)
        );
    }

    @PostMapping()
    public ResponseWrapper<Mill> newMill(@RequestBody Mill newMill) throws URISyntaxException {
        Mill createdMill = millService.createMill(newMill);
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, createdMill
        );
    }
}
