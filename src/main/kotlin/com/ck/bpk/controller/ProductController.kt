package com.ck.bpk.controller;

import com.ck.bpk.dto.ErrorResponseObject
import com.ck.bpk.model.Product;
import com.ck.bpk.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime
import java.util.Optional

@RestController
@RequestMapping("/products")
class ProductController(private val service: ProductService) {
    @GetMapping
    fun getProducts(): MutableList<Product> = service.getProducts()

    @GetMapping("/{productKey}")
    fun getProduct(@PathVariable productKey: String): Optional<Product> = service.getProduct(productKey)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addProduct(@RequestBody product: Product): Product = service.addProduct(product)

}
