package com.example.iqro.repository;

import com.example.iqro.db.dto.response.SurahResponse;
import com.example.iqro.db.dto.response.SurahesResponse;
import com.example.iqro.db.model.Surah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SurahRepository extends JpaRepository<Surah, Long> {
    @Query("""
            SELECT NEW com.example.iqro.db.dto.response.SurahesResponse(
            s.id,s.arabicName,s.cyrillicName,s.audio)
            FROM Surah s
            """)
    List<SurahesResponse> getAllSurahes();

    @Query("""
             SELECT NEW com.example.iqro.db.dto.response.SurahResponse(
             s.id,s.arabicName,s.cyrillicName,s.audio,s.surah,s.meaning,s.transcription
             )
             FROM Surah s WHERE s.id =:surahId
            """)
    Optional<SurahResponse> getSurahById(Long surahId);
}
