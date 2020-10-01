package com.sugarcanemillrepository.sugarcanemillrepositorycore.controllers.field;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.responseWrapper.ResponseWrapper;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.services.field.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/field")
@RestController
public class FieldController {

    public static final int OK_CODE = 200;
    public static final String SUCCESS_MESSAGE = "success";

    @Autowired
    private FieldService fieldService;

    @GetMapping()
    public ResponseWrapper<List<Field>> getAllFields() {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, fieldService.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseWrapper<Field> getFieldById(@PathVariable Long id) {
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, fieldService.findFieldById(id)
        );
    }

    @PostMapping()
    public ResponseWrapper<Field> newField(@RequestBody Field newField) throws URISyntaxException {
        Field createdField = fieldService.createField(newField);
        return new ResponseWrapper<>(
                OK_CODE, SUCCESS_MESSAGE, createdField
        );
    }
}
