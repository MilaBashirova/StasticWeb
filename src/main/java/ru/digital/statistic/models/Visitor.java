package ru.digital.statistic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.digital.statistic.forms.VisitForm;
import ru.digital.statistic.forms.VisitorForm;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "visitor")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Integer uniq;//0-уникальный 1-нет

    public static Visitor from(VisitorForm form) {
        return Visitor.builder().date(form.getDate()).uniq(form.getUniq())
                .build();
    }
}
