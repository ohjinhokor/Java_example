package com.company.di;

import java.util.Optional;

public class BookController {

    public static void main(String[] args) {

        BookService bookService = ContainerService.getObject(BookService.class);
        System.out.println(!Optional.ofNullable(bookService.bookRepository).isEmpty());
    }
}
