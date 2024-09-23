package com.dcb.springboot_mongodb.controller;

import com.dcb.springboot_mongodb.collection.Photo;
import com.dcb.springboot_mongodb.service.PhotoService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping
    public String addPhoto(@RequestParam("image") MultipartFile image){
        String id = photoService.addPhoto(image.getOriginalFilename() ,image);
        return id;
    }

    @GetMapping("{id}")
    public ResponseEntity<Resource> downloadPhoto(@PathVariable String id){
        Photo photo = photoService.getPhotoById(id);
        Resource resource = new ByteArrayResource(photo.getPhoto().getData());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getTitle() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }
}
