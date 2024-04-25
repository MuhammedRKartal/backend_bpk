package com.ck.bpk.service.Impl

import com.ck.bpk.model.Product
import com.ck.bpk.repository.ProductRepository
import com.ck.bpk.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.NoSuchElementException

@Service
class ProductServiceImpl: ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository;

    override fun getProducts(): MutableList<Product> = productRepository.findAll()
    override fun getProduct(productKey: String): Optional<Product> {
        val product = productRepository.findByProductKey(productKey)
        if(product.isEmpty){
            throw NoSuchElementException("No product is with product key: $productKey!")
        }
        return product

    }
    override fun addProduct(product: Product): Product {
        val temp = productRepository.findByProductKey(product.productKey)
        if(temp.isPresent){
            throw Exception("Product with ${temp.get().productKey} already exists!")
        }
        return productRepository.save(product)
    }
}