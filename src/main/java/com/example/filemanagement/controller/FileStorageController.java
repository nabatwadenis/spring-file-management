package com.example.filemanagement.controller;

import com.example.filemanagement.services.FileStoreImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileStorageController {
    FileStoreImpl fsServiceImpl;
    @PostMapping("multipart")
    public ResponseEntity<?> uploadMultipartFile(@RequestParam("file") MultipartFile data){
        String response = fsServiceImpl.uploadMultipartfile(data);
        return ResponseEntity.ok(response);
    }
    @GetMapping("base64")
    public ResponseEntity<?> uploadBase64File(@RequestBody FileStorageDto data){
        String response = fsServiceImpl.uploadBase64File(data.getFilename(), data.getFileType);
    }
}
