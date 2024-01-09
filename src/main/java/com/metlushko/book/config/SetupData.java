package com.metlushko.book.config;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SetupData {

    private final CsvMapper csvMapper;

    private final File file;


    public <T> List<T> loadObjectList(final Class<T> type) {
        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();

        try {
            final MappingIterator<T> readValues = csvMapper
                    .readerFor(type)
                    .with(bootstrapSchema)
                    .readValues(file);
            return readValues.readAll();
        } catch (final Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public <T> Map<Long, T> loadObjectMap(final Class<T> type) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();

            final MappingIterator<T> readValues = csvMapper
                    .readerFor(type).
                    with(bootstrapSchema)
                    .readValues(file);

            return readValues.readAll().stream()
                    .filter(Book.class::isInstance)
                    .map(Book.class::cast)
                    .collect(Collectors.toMap(Book::getId, obj -> (T) obj));

        } catch (final Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }


    public void writeAlLObject(Map<Long, Book> map) {
        CsvSchema schema = csvMapper.schemaFor(Book.class).withHeader();
        try {
            SequenceWriter sequenceWriter = csvMapper
                    .writer(schema)
                    .writeValues(file)
                    .writeAll(map.values());
            sequenceWriter.flush();

            sequenceWriter.close();

        } catch (IOException e) {
            throw new RuntimeException("Error writing CSV file", e);
        }
    }


}
