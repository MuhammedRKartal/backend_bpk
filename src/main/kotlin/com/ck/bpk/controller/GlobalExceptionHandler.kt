package com.ck.bpk.controller

import com.ck.bpk.dto.ErrorResponseObject
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ErrorResponseObject {
        val response = ErrorResponseObject(
            message = e.message,
            statusLabel = HttpStatus.NOT_FOUND,
            status = 404,
            isSuccess = false,
            timeStamp = LocalDateTime.now())
        return response
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ErrorResponseObject {
        val response = ErrorResponseObject(
            message = e.message,
            statusLabel = HttpStatus.BAD_REQUEST,
            status = 400,
            isSuccess = false,
            timeStamp = LocalDateTime.now())
        return response
    }

    @ExceptionHandler(Exception::class)
    fun handleBadRequest(e: Exception): ErrorResponseObject {
        val response = ErrorResponseObject(
            message = e.message,
            statusLabel = HttpStatus.BAD_REQUEST,
            status = 400,
            isSuccess = false,
            timeStamp = LocalDateTime.now())
        return response
    }
}