package com.sorbonne.paris.nord.university.tpteamshandlingapi.repository;

import com.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
