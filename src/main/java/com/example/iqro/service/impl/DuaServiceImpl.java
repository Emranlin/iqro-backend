package com.example.iqro.service.impl;

import com.example.iqro.db.dto.response.DuaGetAllResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.GetAllTypeDuaResponse;
import com.example.iqro.repository.DuaRepository;
import com.example.iqro.service.DuaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DuaServiceImpl implements DuaService {
    private final DuaRepository duaRepository;

    @Override
    public List<DuaGetAllResponse> getAllDua() {
        return duaRepository.getAllDua();
    }

    @Override
    public List<GetAllTypeDuaResponse> getAllTypesOfDua() {
        return duaRepository.getAllSubCategory();
    }

    @Override
    public DuaResponse getById(Long duaId) {
        return duaRepository.getByIdDua(duaId);
    }


}
