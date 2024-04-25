package com.ck.bpk.dto

import org.springframework.http.HttpStatus

data class ResponseObject(
    val status: Int?,
    val statusLabel: HttpStatus?,
    val message: String?,
)
