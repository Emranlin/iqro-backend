package com.example.iqro.api;

import com.example.iqro.db.dto.response.RatingResponse;
import com.example.iqro.db.dto.response.StatisticsResponse;
import com.example.iqro.service.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rating")
@Tag(name = "Rating controller")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class RatingController {
    private final RatingService ratingService;

    @Operation(summary = "Get rating of users", description = "This endpoint to get the rating of users")
    @GetMapping
    public List<RatingResponse> getRating() {
        return ratingService.getRating();
    }

    @Operation(summary = "Get user statistics", description = "This method to get a statistics of user")
    @GetMapping("/statistics")
    public StatisticsResponse getStatisticsOfUser() {
        return ratingService.getStatisticsOfUser();
    }

}
