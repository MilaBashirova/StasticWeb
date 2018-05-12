package ru.digital.statistic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digital.statistic.forms.VisitorForm;
import ru.digital.statistic.models.Visitor;
import ru.digital.statistic.models.VisitorResult;
import ru.digital.statistic.repositories.VisitRepository;
import ru.digital.statistic.repositories.VisitorRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    VisitorRepository visitorRepository;
    @Autowired
    VisitRepository visitRepository;

    @Override
    public void save(VisitorForm visitor) {
        Visitor visitor1 = Visitor.from(visitor);
        visitorRepository.save(visitor1);

    }

    @Override
    public VisitorResult countAllByUniqAndDate(Calendar calendar) {
        Date date = calendar.getTime();
        VisitorResult visitorResult = new VisitorResult();
        visitorResult.setCount(visitorRepository.countAllByDate(date));
        visitorResult.setCountUniq(visitorRepository.countAllByUniqAndDate(0, date));
        visitorResult.setDate(calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DATE));

        return visitorResult;
    }

    @Override
    public VisitorResult fintCountVisitor(String date) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");//задаю формат даты
        try {
            Date date1 = formatter.parse(date);
            calendar.setTime(date1);

        } catch (ParseException e) {

        }
        return countAllByUniqAndDate(calendar);
    }

    @Override
    public VisitorResult fintCountVisitorPeriod(String date, String date1) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");//задаю формат даты
        try {
            Date dateFormat = formatter.parse(date);
            calendar.setTime(dateFormat);
            Date dateFormat1 = formatter.parse(date1);
            calendar1.setTime(dateFormat1);

        } catch (ParseException e) {


        }
        return countAllByUniqAndDateBetween(0, calendar, calendar1);

    }

    @Override
    public VisitorResult countAllByUniqAndDateBetween(Integer i, Calendar calendar, Calendar calendar1) {
        Date date = calendar.getTime();
        Date date1 = calendar1.getTime();
        VisitorResult visitorResult = new VisitorResult();
        visitorResult.setCount(visitorRepository.countAllByDateBetween(date, date1));
        visitorResult.setCountUniq(visitorRepository.countAllByUniqAndDateBetween(0, date, date1));
        visitorResult.setCountConstant(visitRepository.countAllByCountAfter(10));
        visitorResult.setDate(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DATE) + "/" +
                calendar1.get(Calendar.YEAR) + "-" + (calendar1.get(Calendar.MONTH) + 1) + "-" + calendar1.get(Calendar.DATE));

        return visitorResult;
    }
}
