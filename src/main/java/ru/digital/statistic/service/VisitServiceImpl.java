package ru.digital.statistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digital.statistic.forms.VisitForm;
import ru.digital.statistic.models.Visit;
import ru.digital.statistic.repositories.VisitRepository;

import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {
    @Autowired
    VisitRepository visitRepository;

    @Override
    public boolean checkIPAndCountIncrease(String IP) {
        Optional<Visit> visit = visitRepository.findByIP(IP);
        if (visitRepository.findByIP(IP).isPresent())//true усли не null
        {
            save(visit.get());
            return true;
        } else return false;
    }

    @Override
    public void save(VisitForm visitForm) {
        Visit visit1 = Visit.from(visitForm);
        visitRepository.save(visit1);

    }

    @Override
    public void save(Visit visit) {
        Integer count = visit.getCount();
        visit.setCount(count + 1);
        visitRepository.save(visit);


    }
}
