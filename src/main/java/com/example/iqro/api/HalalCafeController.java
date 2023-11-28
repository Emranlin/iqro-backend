package com.example.iqro.api;

import com.example.iqro.db.dto.response.halal.HalalCafeResponse;
import com.example.iqro.service.HalalCafeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/halal-cafe")
@RequiredArgsConstructor
@Tag(name = "Halal cafe API")
@CrossOrigin(origins = "*", maxAge = 3600)
@PermitAll
public class HalalCafeController {
    private final HalalCafeService halalCafeService;

    @Operation(summary = "Get all halal cafe", description = "This method will get all method")
    @GetMapping
    public List<HalalCafeResponse> getAllCafe() {
        return halalCafeService.getAllCafe();
    }

    @Operation(summary = "Get by id halal cafe", description = "This method will get by id halal cafe")
    @GetMapping("/{cafeId}")
    public HalalCafeResponse getByIdCafe(@PathVariable Long cafeId) {
        return halalCafeService.getById(cafeId);
    }
}
