package com.clockin.clockin_backend.timetracking;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TimeTrackingController {

    private TimeTrackingService timeTrackingService;

    @PostMapping(path = "/api/v1/timetrack/start")
    public ResponseEntity enterTimeTrackingStart(HttpServletRequest request) {
        final String tokenString = request.getHeader("Authorization");
        final String token = tokenString.substring(7);

        return new ResponseEntity(timeTrackingService.saveTimeTracking(token), HttpStatus.OK);
    }
}
