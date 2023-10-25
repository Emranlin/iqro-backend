package com.example.iqro.repository;

import com.example.iqro.db.dto.response.DuaGetAllResponse;
import com.example.iqro.db.dto.response.DuaResponse;
import com.example.iqro.db.dto.response.GetAllTypeDuaResponse;
import com.example.iqro.db.model.Dua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuaRepository extends JpaRepository<Dua, Long> {
    @Query("SELECT NEW com.example.iqro.db.dto.response.DuaGetAllResponse(dc.id,dc.name)FROM DuaCategory dc")
    List<DuaGetAllResponse> getAllDua();

    @Query("SELECT NEW com.example.iqro.db.dto.response.GetAllTypeDuaResponse(dc.id,ds.id,ds.name)FROM DuaSubCategory ds JOIN ds.duaCategories dc ")
    List<GetAllTypeDuaResponse> getAllSubCategory();

    @Query("SELECT NEW com.example.iqro.db.dto.response.DuaResponse(dc.id,ds.id,d.id,d.name,d.arabicText,d.meaning,d.transcription,d.audio)" +
            "FROM Dua d " +
            "JOIN d.duaSubCategory ds " +
            "JOIN ds.duaCategories dc WHERE d.id = :duaId")
    DuaResponse getByIdDua(Long duaId);


}