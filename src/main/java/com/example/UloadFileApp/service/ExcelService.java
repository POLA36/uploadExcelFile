package com.example.UloadFileApp.service;

import com.example.UloadFileApp.Helper.ExcelHelper;
import com.example.UloadFileApp.model.Tutorial;
import com.example.UloadFileApp.respository.TutorialRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    TutorialRespository tutorialRespository;
    public void save(MultipartFile file){
        try{
            List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
            tutorialRespository.saveAll(tutorials);
        }catch (IOException e){
            throw new RuntimeException("fail to store excel data" +e.getMessage());
        }
    }
    public List<Tutorial> getAllTutorials(){
        return tutorialRespository.findAll();
    }
}
