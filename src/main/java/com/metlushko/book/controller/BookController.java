package com.metlushko.book.controller;

import com.metlushko.book.entyti.Book;
import com.metlushko.book.service.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class BookController {

    private final Scanner scanner;

    private final BookServiceImpl bookService;

    public void main() {

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Display the list of books");
            System.out.println("2. Create a new book");
            System.out.println("3. Edit a book");
            System.out.println("4. Delete a book");
            System.out.println("0. Exit");

            int nextInt = scanner.nextInt();
            scanner.nextLine();

            switch (nextInt) {
                case 1 -> displayAllBooks();
                case 2 -> createNewBook();
                case 3 -> editBook();
                case 4 -> deleteBook();
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    private void displayAllBooks() {
        bookService.getAllBooks().forEach(System.out::println);

    }

    private void createNewBook() {

        System.out.println("Enter the book title:");
        String name = scanner.nextLine();

        System.out.println("Enter the book author:");
        String author = scanner.nextLine();

        System.out.println("Enter a brief description of the book:");
        String description = scanner.nextLine();

        Book newBook = new Book();
        newBook.setName(name);
        newBook.setAuthor(author);
        newBook.setDescription(description);

        bookService.addBook(newBook);

        System.out.println("New book successfully added.");
    }

    private void editBook() {

        System.out.println("Enter the ID of the book to edit:");
        Long bookId = scanner.nextLong();
        scanner.nextLine();

        Book existingBook = bookService.getBookById(bookId);

        if (existingBook == null) {
            System.out.println("Book with the specified ID not found.");
            return;
        }

        System.out.println("Current information about the book:");
        System.out.println(existingBook);

        System.out.println("Enter the new title of the book:");
        String name = scanner.nextLine();

        System.out.println("Enter the new author of the book:");
        String newAuthor = scanner.nextLine();

        System.out.println("Enter the new brief description of the book:");
        String newDescription = scanner.nextLine();

        existingBook.setName(name);
        existingBook.setAuthor(newAuthor);
        existingBook.setDescription(newDescription);

        bookService.updateBook(bookId,existingBook);

        System.out.println("Information about the book successfully updated.");
    }

    private void deleteBook() {

        System.out.println("Enter the ID of the book to delete:");
        Long bookId = scanner.nextLong();
        scanner.nextLine();

        Book existingBook = bookService.getBookById(bookId);

        if (existingBook == null) {
            System.out.println("Book with the specified ID not found.");
            return;
        }

        System.out.println("Are you sure you want to delete the following book?");
        System.out.println(existingBook);
        System.out.println("Enter 'yes' to confirm:");

        String confirmation = scanner.nextLine().trim().toLowerCase();

        if ("yes".equals(confirmation)) {
            bookService.deleteBook(bookId);
            System.out.println("Book successfully deleted.");
        } else {
            System.out.println("Deletion canceled.");
        }
    }
}
