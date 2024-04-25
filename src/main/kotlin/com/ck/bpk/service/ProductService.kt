package com.ck.bpk.service

import com.ck.bpk.model.Product
import java.util.Optional

interface ProductService {
    fun getProducts(): MutableList<Product>
    fun getProduct(productKey: String): Optional<Product>
    fun addProduct(product: Product): Product
}