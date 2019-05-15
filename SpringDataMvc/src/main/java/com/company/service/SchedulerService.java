package com.company.service;

import com.company.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class SchedulerService {
    private static final String CRON = "*/10 * * * * *";

    private final UserService userService;
    private final MailService mailService;

    @Scheduled(cron = CRON)
    public void sendMailtoUsers() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        List<User> usersBirthdays = userService.getAllUsersByMonthAndDate(month, day);
        if (!usersBirthdays.isEmpty()) {
            usersBirthdays.forEach(user -> {
                try {
                    String message = "Happy Birthday dear " + user.getName() + "!";
                    mailService.sendMail(user.getEmail(), "Happy Birthday!", message);
                    log.info("Email have been sent. User " + user.getId() + " Date: " + date);
                } catch (Exception e) {
                    log.error("Email can't be sent. User " + user.getId() + " Date: " + date);
                    log.error("Email can't be sent. " + e.getMessage());
                }
            });
        }
    }
}
