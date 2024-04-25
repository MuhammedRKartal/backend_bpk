package com.ck.bpk.service.Impl

import com.ck.bpk.dto.ImageDto
import com.ck.bpk.model.Product
import com.ck.bpk.model.ProductImage
import com.ck.bpk.repository.ProductImageRepository
import com.ck.bpk.repository.ProductRepository
import com.ck.bpk.service.ProductImageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class ProductImageServiceImpl: ProductImageService {
    @Autowired
    lateinit var productImageRepository: ProductImageRepository;
    @Autowired
    lateinit var productRepository: ProductRepository;

    override fun getImages(): MutableList<ProductImage> = productImageRepository.findAll()
    override fun getImageById(imagePk: Long): ProductImage = productImageRepository.findByPk(imagePk)
    override fun addImage(image: ImageDto): ProductImage {

        val newImage = ProductImage(url = image.url, altText = image.altText)
        val temp:Optional<Product> = productRepository.findByProductKey(image.productKey)

        if(temp.isPresent){
            temp.get().images.add(newImage)


        } else {
            throw NoSuchElementException("No product is with product key: ${image.productKey}")
        }

        return productImageRepository.save(newImage)

    }

}