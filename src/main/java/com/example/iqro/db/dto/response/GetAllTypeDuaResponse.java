package com.example.iqro.db.dto.response;

public record GetAllTypeDuaResponse(
        Long duaCategoryId,
        Long duaSubCategoryId,
        String name
) {
}
