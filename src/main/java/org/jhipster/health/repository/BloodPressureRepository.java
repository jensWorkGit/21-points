package org.jhipster.health.repository;

import org.jhipster.health.domain.BloodPressure;
import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Spring Data JPA repository for the BloodPressure entity.
 */
public interface BloodPressureRepository extends JpaRepository<BloodPressure,Long> {

    @Query("select bloodPressure from BloodPressure bloodPressure where bloodPressure.user.login = ?#{principal.username} order by bloodPressure.timestamp desc")
    Page<BloodPressure> findAllForCurrentUser(Pageable pageable);

    Page<BloodPressure> findAllByOrderByTimestampDesc(Pageable pageable);

    List<BloodPressure> findAllByTimestampBetweenOrderByTimestampDesc(DateTime firstDate, DateTime secondDate);

    List<BloodPressure> findAllByTimestampBetweenAndUserLoginOrderByTimestampDesc(DateTime firstDate, DateTime secondDate, String login);
}
