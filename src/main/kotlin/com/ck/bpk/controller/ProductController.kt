package com.ck.bpk.controller;

import com.ck.bpk.dto.ResponseObject
import com.ck.bpk.model.Product;
import com.ck.bpk.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseObject {
        val response = ResponseObject(message = e.message, statusLabel = HttpStatus.NOT_FOUND, status = 404)
        return response
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseObject {
        val response = ResponseObject(message = e.message, statusLabel = HttpStatus.BAD_REQUEST, status = 400)
        return response
    }

    @ExceptionHandler(Exception::class)
    fun handleBadRequest(e: Exception): ResponseObject {
        val response = ResponseObject(message = e.message, statusLabel = HttpStatus.BAD_REQUEST, status = 400)
        return response
    }

    @GetMapping
    fun getProducts(): MutableList<Product> = service.getProducts()

    @GetMapping("/{productKey}")
    fun getProduct(@PathVariable productKey: String): Optional<Product> = service.getProduct(productKey)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody product: Product): Product = service.addProduct(product)

}
