package com.dcb.springboot_mongodb.service;

import com.dcb.springboot_mongodb.collection.Photo;
import com.dcb.springboot_mongodb.repository.PhotoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public String addPhoto(String originalFilename, MultipartFile image) {
        Photo photo = new Photo();
        photo.setTitle(originalFilename);
        try {
            photo.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return photoRepository.save(photo).getId();
    }

    @Override
    public Photo getPhotoById(String id) {
        return photoRepository.findById(id).orElse(null);
    }
}
