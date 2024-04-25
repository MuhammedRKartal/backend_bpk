package com.ck.bpk.dto.mock

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class MockProductServiceTest {
    private  val mockDataSource = MockProductService()

    @Test
    fun `Should provide collection of products` () {
        //given

        //when
        val products = mockDataSource.getProducts()

        //then
        Assertions.assertThat(products).isNotEmpty()
    }

    @Test
    fun `Should provide not null data`(){
        val products = mockDataSource.getProducts()
        Assertions.assertThat(products).allMatch {it.productKey.isNotBlank()}
    }
}