package com.clockin.clockin_backend.timetracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TimeTrackingDto {
    private Long Id;
    private String time;
}
