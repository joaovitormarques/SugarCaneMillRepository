package com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.field;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long> {}
