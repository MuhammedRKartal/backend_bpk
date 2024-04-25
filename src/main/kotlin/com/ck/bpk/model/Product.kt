package com.ck.bpk.model

import jakarta.persistence.*

@Entity
@Table
data class Product(
    @Id
    @GeneratedValue
    val pk: Long,
    @Column(unique = true)
    val productKey: String,
    val name: String,
    val description: String,
    val shortDescription: String,
    val price: String,
    val inStock: Boolean,
){
    @OneToMany(cascade = [CascadeType.ALL])
    var images: MutableList<ProductImage> = mutableListOf()
}
