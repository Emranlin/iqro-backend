package com.example.iqro.service.impl;


import com.example.iqro.config.jwt.JwtService;
import com.example.iqro.db.dto.response.PointOfDay;
import com.example.iqro.db.dto.response.RatingResponse;
import com.example.iqro.db.dto.response.StatisticsHelper;
import com.example.iqro.db.dto.response.StatisticsResponse;
import com.example.iqro.repository.UserInfoRepository;
import com.example.iqro.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final UserInfoRepository userInfoRepository;
    private final JwtService jwtService;


    @Override
    public List<RatingResponse> getRating() {
        Long userInfoId = jwtService.getAuthenticate().getUserInfo().getId();
        int dayNumberOfWeek = ZonedDateTime.now().getDayOfWeek().getValue();
        LocalDate dayBeginning = LocalDate.now().minusDays(dayNumberOfWeek);
        return userInfoRepository.getRating(userInfoId, dayBeginning);
    }

    @Override
    public StatisticsResponse getStatisticsOfUser() {
        Long userInfoId = jwtService.getAuthenticate().getUserInfo().getId();
        LocalDate startDate = LocalDate.now().minusDays(7L);
        StatisticsResponse response = new StatisticsResponse();
        List<StatisticsHelper> statisticsHelper = userInfoRepository.getStatisticsOfUser(userInfoId, startDate);

        int maxPoint = 0;
        for (StatisticsHelper helper : statisticsHelper) {
            PointOfDay pointOfDay = new PointOfDay(
                    helper.date().getDayOfWeek(),
                    helper.point().intValue()
            );
            response.getPointsOfDays().add(pointOfDay);

            if (helper.point() > maxPoint) maxPoint = helper.point().intValue();
        }

        response.setMaxPoint(10 - maxPoint % 10 + maxPoint);

        return response;
    }
}
