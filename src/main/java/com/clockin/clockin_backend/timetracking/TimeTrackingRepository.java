package com.clockin.clockin_backend.timetracking;

import com.clockin.clockin_backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeTrackingRepository extends JpaRepository<TimeTracking, Long> {

    List<TimeTracking> getTimeTrackingByUser(User user);


    @Transactional
    @Modifying
    @Query("UPDATE TimeTracking t SET t.end = ?1 WHERE t.user = ?2 AND t.id = ?3")
    int updateTimeTrackingEnd(Long endTime, User user, Long timeTrackingId);

    /*
    @Transactional
    @Modifying
    @Query("UPDATE Token SET confirmedAt = ?2 WHERE token = ?1")
    int updateTimeTrackingEnd(String token, LocalDateTime confirmedAt); */
}
