package com.example.iqro.service.impl;

import com.example.iqro.db.dto.response.halal.HalalCafeResponse;
import com.example.iqro.db.exceptions.NotFoundException;
import com.example.iqro.repository.HalalCafeRepository;
import com.example.iqro.service.HalalCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HalalCafeServiceImpl implements HalalCafeService {
    private final HalalCafeRepository halalCafeRepository;

    @Override
    public List<HalalCafeResponse> getAllCafe() {
        return halalCafeRepository.getAllCafe();
    }

    @Override
    public HalalCafeResponse getById(Long cafeId) {

        return halalCafeRepository.getByIdCafe(cafeId).orElseThrow(
                () -> new NotFoundException(String.format(" Кафе ID - %s не найден.", cafeId)));
    }
}
