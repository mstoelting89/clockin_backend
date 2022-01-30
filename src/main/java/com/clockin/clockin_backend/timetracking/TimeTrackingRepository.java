package com.clockin.clockin_backend.timetracking;

import com.clockin.clockin_backend.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimeTrackingRepository extends JpaRepository<TimeTracking, Long> {

    Optional<TimeTracking> getTimeTrackingByUser(User user);

}
