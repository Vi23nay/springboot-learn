package com.dcb.springboot_mongodb.repository;

import com.dcb.springboot_mongodb.collection.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
}
