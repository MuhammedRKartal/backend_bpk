package com.ck.bpk.dto

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponseObject(
    val isSuccess : Boolean?,
    val status: Int?,
    val statusLabel: HttpStatus?,
    val message: String?,
    val timeStamp : LocalDateTime?
)
