package com.example.iqro.api;

import com.example.iqro.db.dto.response.DuaGetAllResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.GetAllTypeDuaResponse;
import com.example.iqro.service.DuaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dua")
@RequiredArgsConstructor
@Tag(name = "Dua API")
@CrossOrigin(origins = "*", maxAge = 3600)
@PermitAll
public class DuaController {
    private final DuaService duaService;

    @Operation(summary = "All dua category", description = "This method will get all dua category name")
    @GetMapping()
    public List<DuaGetAllResponse> getAllDua() {
        return duaService.getAllDua();
    }

    @Operation(summary = "Types of Dua", description = "This method will get all sub category of dua")
    @GetMapping("/subCategory")
    public List<GetAllTypeDuaResponse> getAllSubCategory() {
        return duaService.getAllTypesOfDua();
    }

    @Operation(summary = "Only one dua information", description = "this method will get only one dua")
    @GetMapping("/{duaId}")
    public DuaResponse getById(@PathVariable Long duaId) {
        return duaService.getById(duaId);
    }
}
