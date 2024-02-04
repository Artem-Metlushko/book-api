package com.metlushko.book.service;

import com.metlushko.book.entity.Image;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final GridFsTemplate gridFsTemplate;
    private final GridFsOperations operations;

    public String addImage(MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "image");
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id.toString();
    }

    public Image download(String id) throws IOException {
        GridFSFile image = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));

        Image loadImage = new Image();

        if (image != null && image.getMetadata() !=null){
            loadImage.setName(image.getFilename());
            loadImage.setFileType( image.getMetadata().get("_contentType").toString() );
            loadImage.setFile( IOUtils.toByteArray(operations.getResource(image).getInputStream()) );
        }

        return loadImage;
    }


}
