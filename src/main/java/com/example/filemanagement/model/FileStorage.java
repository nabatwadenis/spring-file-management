package com.example.filemanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "filestore")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FileStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filename")
    private String fileName;
    @Column(name = "filename")
    private  String fileType;

    @Column(name = "filebyte", length = 5000)
    private byte[] filebyte;

    @Column(name = "filebase64", length = 20000)
    private String filebase64;
}
