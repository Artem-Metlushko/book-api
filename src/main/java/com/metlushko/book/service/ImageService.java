package com.metlushko.book.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

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

/*    public File download(String id) throws IOException {
        GridFSFile image = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));

//        Image loadImage = new Image();
        InputStream inputStream = operations.getResource(image).getInputStream();

        File targetFile = new File("src/main/resources/targetFile.tmp");

        FileUtils.copyInputStreamToFile(inputStream, targetFile);

        if (image != null && image.getMetadata() !=null){
            loadImage.setName(image.getFilename());
            loadImage.setFileType( image.getMetadata().get("_contentType").toString() );
            loadImage.setFile( IOUtils.toByteArray(operations.getResource(image).getInputStream()) );
        }

        return targetFile;
    }*/

/*    public File download(String id) throws IOException {
        GridFSFile image = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));

        InputStream inputStream = operations.getResource(image).getInputStream();

        File targetFile = new File("src/main/resources/targetFile.mp4");

        FileUtils.copyInputStreamToFile(inputStream, targetFile);

        return targetFile;
    } */

    public InputStreamResource download(String id) throws IOException {
        GridFSFile image = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));

        InputStream inputStream = gridFsTemplate.getResource(image).getInputStream();

        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        return inputStreamResource;
    }


}
