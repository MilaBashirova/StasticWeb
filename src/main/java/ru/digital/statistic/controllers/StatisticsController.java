package ru.digital.statistic.controllers;


import org.json.JSONObject;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.digital.statistic.forms.VisitForm;
import ru.digital.statistic.forms.VisitorForm;
import ru.digital.statistic.models.Visit;
import ru.digital.statistic.models.Visitor;
import ru.digital.statistic.models.VisitorResult;
import ru.digital.statistic.repositories.VisitRepository;
import ru.digital.statistic.repositories.VisitorRepository;
import ru.digital.statistic.service.VisitService;
import ru.digital.statistic.service.VisitorService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.*;


@RestController
public class StatisticsController {

    @Autowired
    VisitRepository visitRepository;
    @Autowired
    VisitService visitService;
    @Autowired
    VisitorService visitorService;


    @GetMapping("/user/{date}")
    public VisitorResult countUniqVisit(@PathVariable("date") String date) {
        return visitorService.fintCountVisitor(date);
    }

    @GetMapping("/user/{date}/{date1}")
    public VisitorResult countUniqVisitPeriod(@PathVariable("date") String date,@PathVariable("date1") String date1) {
        return visitorService.fintCountVisitorPeriod(date,date1);
    }

    @GetMapping("/users/{ip}")
    public String user(@PathVariable("ip") String IP, VisitorForm visitorForm, VisitForm visitForm) {
        if (visitService.checkIPAndCountIncrease(IP))//true усли не null
        {
            visitorForm.setUniq(1);
            visitorService.save(visitorForm);
            return "users";
        } else {
            visitorForm.setUniq(0);
            visitorService.save(visitorForm);
            visitForm.setIP(IP);
            visitForm.setCount(1);
            visitService.save(visitForm);
            return "users";
        }


    }
/*


    @GetMapping("/users/{ip}")
    public String Count(@PathVariable("ip") String IP,VisitorForm visitorForm, VisitForm visitForm) {

        if (visitService.checkIPAndCountIncrease(IP))//true усли не null
        {
            visitorForm.setUniq(1);
            visitorService.save(visitorForm);
            return "users";
        } else {
            visitorForm.setUniq(0);
            visitorService.save(visitorForm);
            visitForm.setIP(IP);
            visitForm.setCount(1);
            visitService.save(visitForm);
            return "users";
        }


    }
*/




    /*@GetMapping("/users/{id}")
    public VisitorResult getUser(@PathVariable("id") String IP, VisitorForm visitorForm, VisitForm visitForm) {
       VisitorResult visitorResult=new VisitorResult();
        if (visitService.checkIPAndCountIncrease(IP))//true усли не null
        {
            visitorForm.setUniq(1);
            visitorService.save(visitorForm);
            Calendar myCalendar = new GregorianCalendar(2018, 04, 11);
            Date date = myCalendar.getTime();
            Calendar myCalendar1 = new GregorianCalendar(2018, 04, 10);
            Date date1 = myCalendar.getTime();
            *//*Date date2 = new Date();
            date2.setMonth(04);
            date2.setDate(11);
            date2.setYear(2018);*//*

            Integer i = visitorService.countByUniq(0);
            visitorService.countByDate(date);
            //System.out.println(visitorService.countByDate(date));
            Integer count = visitorService.countByDate(date);

            visitorResult.setCount(count);
            visitorResult.setDate(date);
            System.out.println(visitorService.countAllByDateDateBetween(date, date1));
            //System.out.println(visitorService.countAllByUniqAndDate(0,date));


            return visitorResult;
        } else {
            visitorForm.setUniq(0);
            visitorService.save(visitorForm);
            visitForm.setIP(IP);
            visitForm.setCount(1);
            visitService.save(visitForm);
            return visitorResult;
        }
    }
*/
/*

    @GetMapping("/users/{id}")
    public VisitorResult getUser(@PathVariable("id") String IP, VisitorForm visitorForm, VisitForm visitForm) {
        VisitorResult visitorResult = new VisitorResult();
        if (visitService.checkIPAndCountIncrease(IP))//true усли не null
        {
            visitorForm.setUniq(1);
            visitorService.save(visitorForm);
            Calendar myCalendar = new GregorianCalendar(2018, 04, 11);
            Date date = myCalendar.getTime();
            Calendar myCalendar1 = new GregorianCalendar(2018, 04, 10);
            Date date1 = myCalendar.getTime();

            Integer i = visitorService.countByUniq(0);
            visitorService.countByDate(date);
            //System.out.println(visitorService.countByDate(date));
            Integer count = visitorService.countByDate(date);
            Calendar calendar = new GregorianCalendar(2018, 05, 11);
            visitorResult.setCount(count);
            visitorResult.setDate(calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DATE));
            System.out.println(visitorService.countAllByDateDateBetween(date, date1));
            System.out.println(visitorService.countAllByUniqAndDateBetween(0, date, date1));
            //System.out.println(visitorService.countAllByUniqAndDate(0,date));
            return visitorResult;
        } else {
            visitorForm.setUniq(0);
            visitorService.save(visitorForm);
            visitForm.setIP(IP);
            visitForm.setCount(1);
            visitService.save(visitForm);
            return visitorResult;
        }
    }

*/


  /*  @GetMapping("/users")
    public Visit getUser( HttpServletRequest request) {
        String remoteAddr = "";
        if (request != null) {
            remoteAddr = request.getHeader("HTTP_CLIENT_IP");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }


        String ipaddress = null;
        String hostName  = null;
        try {
            // Get the InetAddress.
            InetAddress inet = InetAddress.getLocalHost();

            // Get IP Address of the client
            ipaddress = inet.getHostAddress();
            // Get hostname of the client
            hostName  = inet.getHostName();
            System.out.println("Client IP Address is: "+ipaddress);
            System.out.println("Client hostname is: "+hostName);
        } catch( UnknownHostException uhe ){
            System.out.println("UnknownHostException: "+uhe.toString());
        }


        return null;
    }*/

}

