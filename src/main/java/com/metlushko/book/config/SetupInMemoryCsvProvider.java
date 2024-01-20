package com.metlushko.book.config;

import com.metlushko.book.dao.DataCSV;
import com.metlushko.book.entyti.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SetupInMemoryCsvProvider {

    private final DataCSV dataCSV;
    private final  Map<Long, Book> hashMap;


    @PostConstruct
    private void setupData(){

        hashMap.put(1L,new Book(1L,"1","a","b"));
        hashMap.put(2L,new Book(2L,"2","c","d"));
        hashMap.put(3L,new Book(3L,"3","f","c"));
        hashMap.put(4L,new Book(4L,"4","q","w"));

        dataCSV.writeBooks(hashMap);


    }





}
