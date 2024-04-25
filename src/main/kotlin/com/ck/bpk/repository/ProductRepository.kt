package com.ck.bpk.repository

import com.ck.bpk.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
    fun findByProductKey(productKey: String): Optional<Product>;
    fun findByPk(pk: Long): Optional<Product>
}