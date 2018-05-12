package ru.digital.statistic.service;

import ru.digital.statistic.forms.VisitorForm;
import ru.digital.statistic.models.VisitorResult;
import java.util.Calendar;



public interface VisitorService {
    void save(VisitorForm visitor);

    VisitorResult countAllByUniqAndDate( Calendar calendar);

    VisitorResult fintCountVisitor(String date);

    VisitorResult fintCountVisitorPeriod(String date,String date1);

    VisitorResult countAllByUniqAndDateBetween(Integer i,Calendar calendar,Calendar calendar1);
}
