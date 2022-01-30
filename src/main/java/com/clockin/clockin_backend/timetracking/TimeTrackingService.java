package com.clockin.clockin_backend.timetracking;

import com.clockin.clockin_backend.security.jwt.authentication.JwtAuthenticationService;
import com.clockin.clockin_backend.user.User;
import com.clockin.clockin_backend.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TimeTrackingService {

    private TimeTrackingRepository timeTrackingRepository;
    private JwtAuthenticationService jwtAuthenticationService;
    private UserService userService;

    public TimeTracking saveTimeTracking(TimeTrackingRequest timeTrackingRequest) {

        String email = jwtAuthenticationService.getEmailFromToken(timeTrackingRequest.getToken());
        User user = userService.loadUserByMail(email);

        return timeTrackingRepository.save(new TimeTracking(user, LocalDateTime.now(), LocalDateTime.now()));
    }
}
