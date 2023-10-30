package com.example.iqro.api;

import com.example.iqro.db.dto.response.SurahResponse;
import com.example.iqro.db.dto.response.SurahesResponse;
import com.example.iqro.service.SurahService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surahes")
@RequiredArgsConstructor
@Tag(name = "Surah controller")
@CrossOrigin(origins = "*", maxAge = 3600)
@PermitAll
public class SurahesController {
    private final SurahService service;
    @Operation(summary = "Get all surahes", description = "This method gets all surahes.")
    @GetMapping
    public List<SurahesResponse> getAllSurahes(){
        return service.getAllSurah();
    }

    @Operation(summary = "Get surah by id", description = "This method gets surah by id.")
    @GetMapping("/{id}")
    public SurahResponse getSurahById(@PathVariable Long id){
        return service.getSurahById(id);
    }
}
