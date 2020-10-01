package com.sugarcanemillrepository.sugarcanemillrepositorycore.services.mill;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill.Mill;

import java.util.List;

public interface MillService {

    List<Mill> findAll();

    Mill createMill(Mill mill);

    Mill findMillById(Long id);
}
