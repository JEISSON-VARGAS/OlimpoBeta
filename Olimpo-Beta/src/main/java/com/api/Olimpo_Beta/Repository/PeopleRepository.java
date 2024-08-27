package com.api.Olimpo_Beta.Repository;

import com.api.Olimpo_Beta.Entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<PeopleEntity , Long> {
}
