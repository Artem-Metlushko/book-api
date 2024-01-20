package com.metlushko.book.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.metlushko.book.entyti.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataCSV {

    private final CsvMapper csvMapper;

    private final File file;

    public Map<Long, Book> loadBooks() {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();

            final MappingIterator<Book> readValues = csvMapper
                    .readerFor(Book.class).
                    with(bootstrapSchema)
                    .readValues(file);

            return readValues.readAll().stream()
                    .filter(Objects::nonNull)
                    .map(Book.class::cast)
                    .collect(Collectors.toMap(Book::getId, obj -> obj));

        } catch (final Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }


    public void writeBooks(Map<Long, Book> map) {
        CsvSchema schema = csvMapper.schemaFor(Book.class).withHeader();
        try (SequenceWriter sequenceWriter = csvMapper
                .writer(schema)
                .writeValues(file)
                .writeAll(map.values());
        ) {

            sequenceWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException("Error writing CSV file", e);
        }
    }


}
