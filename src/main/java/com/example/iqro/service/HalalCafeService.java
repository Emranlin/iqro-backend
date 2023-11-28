package com.example.iqro.service;

import com.example.iqro.db.dto.response.halal.HalalCafeResponse;

import java.util.List;

public interface HalalCafeService {
    List<HalalCafeResponse> getAllCafe();

    HalalCafeResponse getById(Long cafeId);
}
