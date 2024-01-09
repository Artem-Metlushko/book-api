/*
package com.metlushko.book.cashe;


import com.metlushko.book.model.Book;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Aspect
public class BookCache {

    private final Map<Long, Book> cacheMap;
    private static final Logger logger = LoggerFactory.getLogger(BookCache.class);



    @Around("@annotation(com.metlushko.book.cashe.annotation.FindByIdCashe)")
    public Optional<Book> findByIdAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("---------------------------");
        logMapIsEmpty();

        Long id = (Long) joinPoint.getArgs()[0];

        Optional<Book> bookFromCache = Optional.ofNullable(cacheMap.get(id));

        if (bookFromCache.isPresent()) {
            logToTerminal();
            return bookFromCache;
        }

        Optional<Book> bookFromDatabase = (Optional<Book>) joinPoint.proceed();

        bookFromDatabase.ifPresent(book -> cacheMap.put(id, book));

        logToTerminal();
        logger.info("---------------------------");
        return bookFromDatabase;
    }

    private void logToTerminal() {
        String mapToString = cacheMap.entrySet().stream().toList().toString();

        logger.info("HASHMAP : {}", mapToString);
    }

    private void logMapIsEmpty() {
        if (cacheMap.isEmpty()) {
            logger.info("HASHMAP : EMPTY");
        }
    }


    @Around("@annotation(com.metlushko.book.cashe.annotation.SaveCashe)")
    public Book saveBeforeAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("---------------------------");
        logMapIsEmpty();

        Book bookFromDatabase = (Book) proceedingJoinPoint.proceed();

        cacheMap.put(bookFromDatabase.getId(), bookFromDatabase);

        logToTerminal();
        logger.info("---------------------------");
        return bookFromDatabase;
    }


    @Around("@annotation(com.metlushko.book.cashe.annotation.UpdateCashe)")
    public Object updateAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("---------------------------");
        logMapIsEmpty();

        Book book = (Book) proceedingJoinPoint.getArgs()[0];
        Long bookId = (Long) proceedingJoinPoint.getArgs()[1];

        proceedingJoinPoint.proceed();

        Book bookFromCache = cacheMap.put(bookId, book);

        logToTerminal();
        logger.info("---------------------------");
        return bookFromCache;
    }



    @Around("@annotation(com.metlushko.book.cashe.annotation.DeleteCashe)")
    public Object deleteAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("---------------------------");
        logMapIsEmpty();

        Long id = (Long) proceedingJoinPoint.getArgs()[0];
        Optional<Book> cachedBook = Optional.ofNullable(cacheMap.get(id));

        if (cachedBook.isPresent()) {
            cacheMap.remove(id);
            logToTerminal();
            logger.info("---------------------------");
            return proceedingJoinPoint.proceed();
        }

        logToTerminal();
        logger.info("---------------------------");
        return proceedingJoinPoint.proceed();
    }
}
*/
