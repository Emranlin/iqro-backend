package com.example.iqro.service;

import com.example.iqro.db.dto.response.SurahResponse;
import com.example.iqro.db.dto.response.SurahesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SurahService {
     List<SurahesResponse> getAllSurah();
    SurahResponse getSurahById(Long id);
}