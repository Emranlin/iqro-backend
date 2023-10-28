package com.example.iqro.api;

import com.example.iqro.db.dto.response.DuaCategoryResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.DuaSubCategoryResponse;
import com.example.iqro.service.DuaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dua")
@RequiredArgsConstructor
@Tag(name = "Dua API")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class DuaController {
    private final DuaService duaService;

    @Operation(summary = "All dua categories", description = "This method will get all dua categories name")
    @GetMapping("/categories")
    public List<DuaCategoryResponse> getAllDuaCategories() {
        return duaService.getAllDuaCategories();
    }

    @Operation(summary = "All dua sub-categories", description = "This method will get all sub-categories of dua")
    @GetMapping("/sub-categories")
    public List<DuaSubCategoryResponse> getAllDuaSubCategory(@RequestParam Long duaCategoryId) {
        return duaService.getAllDuaSubCategory(duaCategoryId);
    }

    @Operation(summary = "Get dua by id", description = "This method will get dua information")
    @GetMapping("/{duaId}")
    public DuaResponse getDuaById(@PathVariable Long duaId) {
        return duaService.getDuaById(duaId);
    }
}
