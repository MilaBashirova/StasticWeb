package ru.digital.statistic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.digital.statistic.forms.VisitForm;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iP;
    private Integer count;

    public static Visit from(VisitForm form) {
        return Visit.builder().iP(form.getIP()).count(form.getCount())

                .build();
    }

}
