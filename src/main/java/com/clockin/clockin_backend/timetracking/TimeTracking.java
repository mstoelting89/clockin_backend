package com.clockin.clockin_backend.timetracking;

import com.clockin.clockin_backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TimeTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private LocalDateTime start;
    private LocalDateTime end;

    public TimeTracking(User user, LocalDateTime start, LocalDateTime end) {
        this.user = user;
        this.start = start;
        this.end = end;
    }
}
