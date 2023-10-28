package com.example.iqro.service;

import com.example.iqro.db.dto.response.DuaCategoryResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.DuaSubCategoryResponse;

import java.util.List;

public interface DuaService {
    List<DuaCategoryResponse> getAllDuaCategories();

    List<DuaSubCategoryResponse> getAllDuaSubCategory(Long duaCategoryId);

    DuaResponse getDuaById(Long duaId);


}
