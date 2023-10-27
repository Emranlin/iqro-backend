package com.example.iqro.repository;

import com.example.iqro.db.dto.response.RatingResponse;
import com.example.iqro.db.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    @Query("""
            SELECT NEW com.example.iqro.db.dto.response.RatingResponse(ui.id, ui.avatar, ui.name,
            SUM(r.point), (ui.id = :userInfoId))
            FROM UserInfo ui
            JOIN ui.results r
            WHERE r.date >= CURRENT_DATE
            LIMIT 10
            """)
    List<RatingResponse> getRating(Long userInfoId);
}