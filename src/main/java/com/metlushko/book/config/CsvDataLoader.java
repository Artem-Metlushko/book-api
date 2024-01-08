package com.metlushko.book.config;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
public class CsvDataLoader {

    public <T> List<T> loadObjectList(final Class<T> type, final String fileName) {
        try {
            final CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            final CsvMapper mapper = new CsvMapper();
            final File file = new ClassPathResource(fileName).getFile();
            final MappingIterator<T> readValues = mapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (final Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
