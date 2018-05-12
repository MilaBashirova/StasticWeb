package ru.digital.statistic.forms;

import lombok.Data;

@Data
public class VisitForm {
    private Long id;
    private String IP;
    private Integer count;
}
