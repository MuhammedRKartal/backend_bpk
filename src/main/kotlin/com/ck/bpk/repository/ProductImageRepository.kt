package com.ck.bpk.repository

import com.ck.bpk.dto.ImageDto
import com.ck.bpk.model.ProductImage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductImageRepository: JpaRepository<ProductImage, Long> {
    fun findByPk(imagePk: Long): ProductImage
}