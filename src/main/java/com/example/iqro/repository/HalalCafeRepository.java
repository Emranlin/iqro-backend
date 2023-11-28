package com.example.iqro.repository;

import com.example.iqro.db.dto.response.halal.HalalCafeResponse;
import com.example.iqro.db.model.HalalCafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HalalCafeRepository extends JpaRepository<HalalCafe, Long> {
    @Query("SELECT NEW com.example.iqro.db.dto.response.halal.HalalCafeResponse(hc.id,hc.name,hc.name)" +
            "FROM HalalCafe hc")
    List<HalalCafeResponse> getAllCafe();

    @Query("SELECT NEW com.example.iqro.db.dto.response.halal.HalalCafeResponse(hc.id,hc.name,hc.name)" +
            "FROM HalalCafe hc " +
            "WHERE hc.id = :cafeId")
    Optional<HalalCafeResponse> getByIdCafe(@Param("cafeId") Long cafeId);
}