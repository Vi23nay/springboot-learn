package com.dcb.springboot_mongodb.service;

import com.dcb.springboot_mongodb.collection.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {
    String addPhoto(String originalFilename, MultipartFile image);

    Photo getPhotoById(String id);
}
