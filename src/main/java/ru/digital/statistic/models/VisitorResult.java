package ru.digital.statistic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class VisitorResult {
    private Integer count;
    private Integer countUniq;
    private Integer countConstant;
    private String date;
}
