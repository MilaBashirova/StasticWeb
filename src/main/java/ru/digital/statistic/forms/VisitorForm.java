package ru.digital.statistic.forms;

import lombok.Data;
import org.springframework.data.annotation.Version;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


@Data
public class VisitorForm {
    @Version
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Integer uniq;//0-уникальный 1-нет
}
