package ru.digital.statistic.repositories;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.digital.statistic.models.Visit;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    Optional<Visit> findByIP(String ip);

    Integer countAllByCountAfter(Integer i);
}
