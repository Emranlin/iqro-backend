package com.example.iqro.db.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StatisticsResponse {
    private int maxPoint;
    private List<PointOfDay> pointsOfDays = new ArrayList<>();
}
