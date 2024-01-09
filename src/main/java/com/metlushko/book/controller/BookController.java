package com.metlushko.book.controller;


import com.metlushko.book.model.Book;
import com.metlushko.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class BookController {

    private final Scanner scanner;

    private final BookService bookService;

    public void main() {

        while (true) {
            System.out.println("Выберите опцию:");
            System.out.println("1. Вывести список книг");
            System.out.println("2. Создать новую книгу");
            System.out.println("3. Отредактировать книгу");
            System.out.println("4. Удалить книгу");
            System.out.println("0. Выйти");

            int nextInt = scanner.nextInt();
            scanner.nextLine();

            switch (nextInt) {
                case 1 -> displayAllBooks();
                case 2 -> createNewBook();
                case 3 -> editBook();
//                case 4 -> deleteBook();
//                case 0 -> exitApplication();
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }

        }
    }

    private void displayAllBooks() {
        List<Map.Entry<Long, Book>> allBooks = bookService.getAllBooks();
        allBooks.forEach(System.out::println);

    }


    private void createNewBook() {

        System.out.println("Введите название книги:");
        String name = scanner.nextLine();

        System.out.println("Введите автора книги:");
        String author = scanner.nextLine();

        System.out.println("Введите краткое описание книги:");
        String description = scanner.nextLine();

        Book newBook = new Book();
        newBook.setName(name);
        newBook.setAuthor(author);
        newBook.setDescription(description);


        bookService.addBook(newBook);

        System.out.println("Новая книга успешно добавлена.");
    }

    private void editBook() {

        System.out.println("Введите ID книги для редактирования:");
        Long bookId = scanner.nextLong();
        scanner.nextLine();

        Book existingBook = bookService.getBookById(bookId);

        if (existingBook == null) {
            System.out.println("Книга с указанным ID не найдена.");
            return;
        }

        System.out.println("Текущая информация о книге:");
        System.out.println(existingBook);

        System.out.println("Введите новое название книги:");
        String name = scanner.nextLine();

        System.out.println("Введите нового автора книги:");
        String newAuthor = scanner.nextLine();

        System.out.println("Введите новое краткое описание книги:");
        String newDescription = scanner.nextLine();

        existingBook.setName(name);
        existingBook.setAuthor(newAuthor);
        existingBook.setDescription(newDescription);

        bookService.updateBook(existingBook);

        System.out.println("Информация о книге успешно обновлена.");
    }



}
