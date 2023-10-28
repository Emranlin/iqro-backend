package com.example.iqro.service.impl;

import com.example.iqro.db.dto.response.SurahResponse;
import com.example.iqro.db.dto.response.SurahesResponse;
import com.example.iqro.db.exceptions.NotFoundException;
import com.example.iqro.repository.SurahRepository;
import com.example.iqro.service.SurahService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SurahServiceImpl implements SurahService {
    private final SurahRepository surahRepository;

    @Override
    public List<SurahesResponse> getAllSurah() {
        return surahRepository.getAllSurahes();
    }

    @Override
    public SurahResponse getSurahById(Long id) {
        surahRepository.findById(id).orElseThrow(()->new NotFoundException("Сура с идентификатором: "+id+" не найдена!"));
        return surahRepository.getSurahById(id);
    }
}
