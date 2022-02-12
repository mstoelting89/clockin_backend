package com.clockin.clockin_backend.timetracking;

import com.clockin.clockin_backend.security.authentication.AuthenticationDto;
import com.clockin.clockin_backend.security.jwt.authentication.JwtAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TimeTrackingController {

    private TimeTrackingService timeTrackingService;
    private JwtAuthenticationService jwtAuthenticationService;

    @GetMapping(path = "/api/v1/timetrack/start", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> enterTimeTrackingStart(HttpServletRequest request) {

        final String token = jwtAuthenticationService.extractTokenFromRequest(request);

        if (token != null) {
            TimeTracking saveTimeTrackingEntry = timeTrackingService.saveTimeTrackingStart(token);

            Map<String, Object> responseObject = new HashMap<String, Object>();
            responseObject.put("id", saveTimeTrackingEntry.getId());

            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Zugriff nicht erlaubt", HttpStatus.UNAUTHORIZED);
        }

    }


    @PostMapping(path = "/api/v1/timetrack/end")
    public ResponseEntity<?> enterTimeTrackingEnd(HttpServletRequest request, @RequestBody TimeTrackingDto timeTrackingDto) {

        final String token = jwtAuthenticationService.extractTokenFromRequest(request);
        final Long timeTrackingId = timeTrackingDto.getId();

        if (token != null) {
            return new ResponseEntity<>(timeTrackingService.saveTimeTrackingEnd(token, timeTrackingId), HttpStatus.OK);
        } else {
        return new ResponseEntity<>("Zugriff nicht erlaubt", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/api/v1/timetrack/get")
    public ResponseEntity<?> getTimeTrackingEntries(HttpServletRequest request) {

        final String token = jwtAuthenticationService.extractTokenFromRequest(request);

        if (token != null) {
            return new ResponseEntity<>(timeTrackingService.getTimeTrackingData(token), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Zugriff nicht erlaubt", HttpStatus.UNAUTHORIZED);
        }
    }

}
