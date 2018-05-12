package ru.digital.statistic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.digital.statistic.models.Visitor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    Integer countAllByDate(Date date);

    Integer countAllByUniqAndDate(Integer i, Date date);

    Integer countAllByUniqAndDateBetween(Integer i, Date date, Date date1);

    Integer countAllByDateBetween(Date date, Date date1);

}
