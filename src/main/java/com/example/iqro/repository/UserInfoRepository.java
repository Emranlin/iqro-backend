package com.example.iqro.repository;

import com.example.iqro.db.dto.response.RatingResponse;
import com.example.iqro.db.dto.response.StatisticsHelper;
import com.example.iqro.db.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query("""
            SELECT NEW com.example.iqro.db.dto.response.RatingResponse(ui.id, ui.avatar, ui.name,
            SUM (r.point), CASE WHEN ui.id = :userInfoId THEN true ELSE false END)
            FROM UserInfo ui
            JOIN ui.results r
            WHERE r.date > :dayBeginning
            GROUP BY ui.id, ui.avatar, ui.name, CASE WHEN ui.id = :userInfoId THEN true ELSE false END
            ORDER BY SUM(r.point) DESC
            LIMIT 10
            """)
    List<RatingResponse> getRating(Long userInfoId, LocalDate dayBeginning);

    @Query("""
            SELECT NEW com.example.iqro.db.dto.response.StatisticsHelper(r.date, SUM (r.point))
            FROM UserInfo ui
            JOIN ui.results r
            WHERE ui.id = :userInfoId AND r.date > :startDate
            GROUP BY r.date
            ORDER BY r.date
            """)
    List<StatisticsHelper> getStatisticsOfUser(Long userInfoId, LocalDate startDate);

}