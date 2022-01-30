package com.clockin.clockin_backend.timetracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TimeTrackingRequest {

    private String token;
    private LocalDateTime startTime;
}
