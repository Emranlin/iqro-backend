package com.example.iqro.service.impl;

import com.example.iqro.db.dto.response.DuaCategoryResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.DuaSubCategoryResponse;
import com.example.iqro.db.exceptions.NotFoundException;
import com.example.iqro.repository.DuaRepository;
import com.example.iqro.service.DuaService;
import lombok.RequiredArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuaServiceImpl implements DuaService {
    private final DuaRepository duaRepository;

    @Override
    public List<DuaCategoryResponse> getAllDuaCategories() {
        return duaRepository.getAllDuaCategories();
    }

    @Override
    public List<DuaSubCategoryResponse> getAllDuaSubCategory(Long duaCategoryId) {
        return duaRepository.getAllSubCategory(duaCategoryId);
    }

    @Override
    public DuaResponse getDuaById(Long duaId) {
        return duaRepository.getByIdDua(duaId).orElseThrow(
                () -> new NotFoundException("Дуа с ID - %s не найдена".formatted(duaId)));
    }
}