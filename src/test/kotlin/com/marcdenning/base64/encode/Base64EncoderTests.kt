package com.marcdenning.base64.encode

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

/**
 * See [RFC 4648 Section 4](https://tools.ietf.org/html/rfc4648#section-4) for canonical encoding specification.
 */
class Base64EncoderTests {

    private lateinit var base64Encoder: Base64Encoder

    @BeforeEach
    fun setUp() {
        base64Encoder = Base64Encoder()
    }

    @ParameterizedTest
    @MethodSource("base64Data")
    fun `properly encodes the string`(input: String, output: String) {
        assert.that(base64Encoder.encode(input), equalTo(output))
    }

    companion object {
        @JvmStatic
        fun base64Data(): Collection<Arguments> {
            return listOf(
                    arguments("", ""),
                    arguments("f", "Zg=="),
                    arguments("foobar", "Zm9vYmFy")
            )
        }
    }
}
