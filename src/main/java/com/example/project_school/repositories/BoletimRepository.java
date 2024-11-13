package com.example.project_school.repositories;

import com.example.project_school.domain.boletins.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletimRepository extends JpaRepository<Boletim, Long> {
}
