package com.ck.bpk.service.Impl

import com.ck.bpk.model.Product
import com.ck.bpk.model.ProductImage
import com.ck.bpk.repository.ProductImageRepository
import com.ck.bpk.repository.ProductRepository
import com.ck.bpk.service.ProductService
import com.fasterxml.jackson.annotation.JsonKey
import com.fasterxml.jackson.annotation.JsonValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.NoSuchElementException
import kotlin.reflect.full.memberProperties

@Service
class ProductServiceImpl: ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository
    @Autowired
    lateinit var productImageRepository: ProductImageRepository

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

    override fun updateProduct(productKey: String, changes: Map<String, Any?>): Product {
        val prod = productRepository.findByProductKey(productKey)

        if (prod.isPresent){
            val entity = prod.get()
            changes.forEach {
                entry ->  when(entry.key){
                    "productKey" -> entity.productKey = entry.value?.toString().toString()
                    "name" -> entity.name = entry.value?.toString().toString()
                    "description" -> entity.description = entry.value?.toString().toString()
                    "shortDescription" -> entity.shortDescription = entry.value?.toString().toString()
                    "price" -> entity.price = entry.value?.toString().toString()
                    "inStock" -> entity.inStock = entry.value as Boolean? == true
                }
            }
            return productRepository.save(entity)
        } else{
            throw NoSuchElementException("Product with $productKey key does not exists.")
        }
    }

    override fun deleteProduct(productKey: String): Optional<Product> {
        val product = productRepository.findByProductKey(productKey)
        if(product.isPresent){
            for (i in product.get().images){
                productImageRepository.delete(productImageRepository.findByPk(i.pk))
            }
            productRepository.delete(product.get())
        } else{
            throw NoSuchElementException("Product with $productKey key does not exists.")
        }
        return product
    }
}