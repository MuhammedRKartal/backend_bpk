package com.ck.bpk.controller

import com.ck.bpk.dto.ImageDto
import com.ck.bpk.model.ProductImage
import com.ck.bpk.service.ProductImageService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products/images")
class ProductImageController(private val service: ProductImageService) {
    @GetMapping
    fun getImages(): MutableList<ProductImage> = service.getImages()

    @GetMapping("/{imagePk}")
    fun getImageById(@PathVariable imagePk: Long): ProductImage = service.getImageById(imagePk)

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addImage(@RequestBody image: ImageDto): ProductImage = service.addImage(image)

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    fun deleteImageByPk(@RequestBody imagePk: Long) = service.deleteImageByPk(imagePk)
}