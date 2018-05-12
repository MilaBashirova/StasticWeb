package ru.digital.statistic.service;

import ru.digital.statistic.forms.VisitForm;
import ru.digital.statistic.models.Visit;

public interface VisitService {
    boolean checkIPAndCountIncrease(String IP);
    void save(VisitForm visitForm);
    void save(Visit visit);
}
