package com.example.iqro.repository;

import com.example.iqro.db.dto.response.DuaCategoryResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.DuaSubCategoryResponse;
import com.example.iqro.db.model.Dua;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuaRepository extends JpaRepository<Dua, Long> {
    @Query("SELECT NEW com.example.iqro.db.dto.response.DuaCategoryResponse(dc.id, dc.name) FROM DuaCategory dc")
    List<DuaCategoryResponse> getAllDuaCategories();

    @Query("SELECT NEW com.example.iqro.db.dto.response.DuaSubCategoryResponse(dsc.id, dsc.name)FROM DuaSubCategory dsc WHERE dsc.duaCategories.id = :duaCategoryId")
    List<DuaSubCategoryResponse> getAllSubCategory(Long duaCategoryId);

    @Query("SELECT NEW com.example.iqro.db.dto.response.DuaResponse(" +
            "d.id,d.name,d.arabicText,d.meaning,d.transcription,d.audio)" +
            "FROM Dua d " +
            "WHERE d.id = :duaId")
   Optional<DuaResponse> getByIdDua(Long duaId);


}