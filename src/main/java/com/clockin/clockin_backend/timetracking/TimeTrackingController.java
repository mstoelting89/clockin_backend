package com.clockin.clockin_backend.timetracking;

import com.clockin.clockin_backend.security.jwt.authentication.JwtAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TimeTrackingController {

    private TimeTrackingService timeTrackingService;
    private JwtAuthenticationService jwtAuthenticationService;

    @PostMapping(path = "/api/v1/timetrack/start")
    public ResponseEntity enterTimeTrackingStart(HttpServletRequest request) {

        final String token = jwtAuthenticationService.extractTokenFromRequest(request);

        if (token != null) {
            timeTrackingService.saveTimeTrackingStart(token);
            return new ResponseEntity("Eintragung Start erfolgreich", HttpStatus.OK);
        } else {
            return new ResponseEntity("Zugriff nicht erlaubt", HttpStatus.UNAUTHORIZED);
        }

    }


    @PostMapping(path = "/api/v1/timetrack/end")
    public ResponseEntity enterTimeTrackingEnd(HttpServletRequest request) {

        final String token = jwtAuthenticationService.extractTokenFromRequest(request);

        if (token != null) {
            timeTrackingService.saveTimeTrackingEnd(token);
            return new ResponseEntity("Eintragung End erfolgreich", HttpStatus.OK);
        } else {
            return new ResponseEntity("Zugriff nicht erlaubt", HttpStatus.UNAUTHORIZED);
        }
    }

}
