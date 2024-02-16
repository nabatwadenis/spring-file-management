package com.example.filemanagement.services;

import com.example.filemanagement.model.FileStorage;
import com.example.filemanagement.utils.FileStorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class FileStoreImpl {
    @Autowired
    FileStoreService fsService;

    public String uploadMultipartfile(MultipartFile data){
        FileStorage file = new FileStorage();
        file.setFileName((data.getOriginalFilename()));
        file.setFileType(data.getContentType());
        try{
            file.setFilebyte(FileStorageUtil.compressFile(data.getBytes()));
        } catch (IOException e){
            e.printStackTrace();
        }
        FileStorage newFile = fsService.persistFile(file);
        if(newFile != null){
            return String.format("File %s uploaded Successfully", data.getContentType());
        }
        return String.format("file %s upload failed", data.getContentType());
    }
    public String uploadBase64File(String filename, String fileType, String data){
        FileStorage file = new FileStorage();
        file.setFileName(filename);
        file.setFileType(fileType);
        file.setFilebase64(data);
        FileStorage newfile = fsService.persistFile(file);

        if(newfile != null){
            return String.format("File %s uploaded successfully", filename);
        }
        return String.format("File %s upload failed", filename);
    }
    public FileStorage retrieveFile (String filename){
        return fsService.retrieveFileByName(filename);
    }
    public byte[] downloadMultipartFile(String filename){
        return  FileStorageUtil.decompressFile(fsService.retrieveFileByName(filename).getFilebyte());
    }
    public byte[] downloadBase64File(String filename){
        String data = fsService.retrieveFileByName(filename).getFilebase64();
        return Base64.getDecoder().decode(data.split(",")[1]);
    }
}
