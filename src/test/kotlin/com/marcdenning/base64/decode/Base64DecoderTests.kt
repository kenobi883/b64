package com.marcdenning.base64.decode

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class Base64DecoderTests {

    private lateinit var base64Decoder: Base64Decoder

    @BeforeEach
    fun setUp() {
        base64Decoder = Base64Decoder()
    }

    @ParameterizedTest
    @MethodSource("com.marcdenning.base64.StringTestFixtures#base64Data")
    fun `properly decodes the string`(output: String, input: String) {
        assert.that(base64Decoder.decode(input), equalTo(output))
    }
}
