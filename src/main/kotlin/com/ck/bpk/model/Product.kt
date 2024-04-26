package com.ck.bpk.model

import jakarta.persistence.*

@Entity
@Table
data class Product(
    @Id
    @GeneratedValue
    val pk: Long,
    @Column(unique = true)
    var productKey: String,
    var name: String,
    var description: String,
    var shortDescription: String,
    var price: String,
    var inStock: Boolean,
){
    @OneToMany(cascade = [CascadeType.ALL])
    var images: MutableList<ProductImage> = mutableListOf()
}
