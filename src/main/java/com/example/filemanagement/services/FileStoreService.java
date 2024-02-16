package com.example.filemanagement.services;

import com.example.filemanagement.model.FileStorage;
import com.example.filemanagement.repository.FileStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileStoreService {
    @Autowired
    private FileStoreRepository fileStoreRepository;

    public FileStorage persistFile(FileStorage file){
        return fileStoreRepository.save(file);
    }
    public FileStorage retrieveFileByName(String filename){
        return fileStoreRepository.findByFileName(filename);
    }
    public void removeFile(String filename) throws Exception{
        FileStorage file = retrieveFileByName(filename);
        if(file == null){
            throw new Exception(String.format("file with name %s not found", filename));
        }
        fileStoreRepository.delete(file);
    }


}
