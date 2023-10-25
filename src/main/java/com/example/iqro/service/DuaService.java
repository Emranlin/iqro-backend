package com.example.iqro.service;

import com.example.iqro.db.dto.response.DuaGetAllResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.GetAllTypeDuaResponse;

import java.util.List;

public interface DuaService {
    List<DuaGetAllResponse> getAllDua();

    List<GetAllTypeDuaResponse> getAllTypesOfDua();
    DuaResponse getById(Long duaId);


}
