package com.sugarcanemillrepository.sugarcanemillrepositorycore.repositories.mill;

import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill.Mill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MillRepository extends JpaRepository<Mill, Long> {}
