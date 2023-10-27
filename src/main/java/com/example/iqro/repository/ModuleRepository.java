package com.example.iqro.repository;

import com.example.iqro.db.dto.response.lesson.ModuleResponse;
import com.example.iqro.db.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    @Query("SELECT NEW com.example.iqro.db.dto.response.lesson.ModuleResponse(m.id, m.name) FROM Module m")
    List<ModuleResponse> getAllModules();
}