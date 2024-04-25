package com.ck.bpk.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.transaction.Transactional
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import kotlin.reflect.typeOf

@Entity
@Table
data class ProductImage(
    @Id
    @GeneratedValue
    val pk: Long= 0,
    val url: String,
    val altText: String
) {
}
