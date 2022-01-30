package com.clockin.clockin_backend.timetracking;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
public class TimeTrackingController {

    private TimeTrackingService timeTrackingService;

    @PostMapping(path = "/api/v1/timetrack/start")
    public ResponseEntity enterTimeTrackingStart(@RequestBody TimeTrackingDto timeTrackingDto) {
        return new ResponseEntity(timeTrackingService.saveTimeTracking(timeTrackingDto), HttpStatus.OK);
    }
}
