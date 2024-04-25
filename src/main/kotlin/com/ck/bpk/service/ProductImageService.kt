package com.ck.bpk.service

import com.ck.bpk.dto.ImageDto
import com.ck.bpk.model.ProductImage

interface ProductImageService {
    fun getImages(): MutableList<ProductImage>
    fun getImageById(imagePk: Long): ProductImage
    fun addImage(image: ImageDto): ProductImage
}