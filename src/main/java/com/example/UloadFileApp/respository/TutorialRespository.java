package com.example.UloadFileApp.respository;

import com.example.UloadFileApp.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRespository extends JpaRepository<Tutorial, Long> {
}
