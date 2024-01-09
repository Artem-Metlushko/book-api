package com.metlushko.book.config;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SetupData {

    private final CsvMapper csvMapper;
    private final File file;


    public <T> List<T> loadObjectList(final Class<T> type, final String fileName) {
        try {
            final CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            final MappingIterator<T> readValues = csvMapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (final Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
