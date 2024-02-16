package com.example.filemanagement.repository;

import com.example.filemanagement.model.FileStorage;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FileStoreRepository extends JpaRepository<FileStorage, Integer> {
    FileStorage findByFileName(String filename);

}
