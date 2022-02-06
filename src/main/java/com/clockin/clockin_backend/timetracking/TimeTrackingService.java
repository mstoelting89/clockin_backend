package com.clockin.clockin_backend.timetracking;

import com.clockin.clockin_backend.security.jwt.authentication.JwtAuthenticationService;
import com.clockin.clockin_backend.user.User;
import com.clockin.clockin_backend.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TimeTrackingService {

    private TimeTrackingRepository timeTrackingRepository;
    private JwtAuthenticationService jwtAuthenticationService;
    private UserService userService;

    public TimeTracking saveTimeTrackingStart(String token) {

        //TODO: Check before if there is an open timetracking without an end

        String email = jwtAuthenticationService.getEmailFromToken(token);
        User user = userService.loadUserByMail(email);

        return timeTrackingRepository.save(new TimeTracking(user, System.currentTimeMillis(), null));
    }


    public int saveTimeTrackingEnd(String token, Long timeTrackingId) {
        String email = jwtAuthenticationService.getEmailFromToken(token);
        User user = userService.loadUserByMail(email);

        return timeTrackingRepository.updateTimeTrackingEnd(System.currentTimeMillis(), user, timeTrackingId);
    }


    public List<TimeTracking> getTimeTrackingData(String token) {
        String email = jwtAuthenticationService.getEmailFromToken(token);
        User user = userService.loadUserByMail(email);

        return timeTrackingRepository.getTimeTrackingByUser(user);
    }
}
