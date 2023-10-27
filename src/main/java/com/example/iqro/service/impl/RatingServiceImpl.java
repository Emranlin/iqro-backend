package com.example.iqro.service.impl;


import com.example.iqro.config.jwt.JwtService;
import com.example.iqro.db.dto.response.RatingResponse;
import com.example.iqro.repository.UserInfoRepository;
import com.example.iqro.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.webresources.JarWarResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final UserInfoRepository userInfoRepository;
    private final JwtService jwtService;


    @Override
    public List<RatingResponse> getRating() {
        Long userInfoId = jwtService.getAuthenticate().getUserInfo().getId();
        return userInfoRepository.getRating(userInfoId);
    }
}
