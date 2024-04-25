package com.ck.bpk.controller

import com.ck.bpk.dto.ImageDto
import com.ck.bpk.dto.ResponseObject
import com.ck.bpk.model.ProductImage
import com.ck.bpk.service.ProductImageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products/images")
class ProductImageController(private val service: ProductImageService) {
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
    fun getImages(): MutableList<ProductImage> = service.getImages()

    @GetMapping("/{imagePk}")
    fun getImageById(@PathVariable imagePk: Long): ProductImage = service.getImageById(imagePk)

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addImage(@RequestBody image: ImageDto): ProductImage = service.addImage(image)
}