package com.example.iqro.service;

import com.example.iqro.db.dto.response.RatingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    List<RatingResponse> getRating();
}
