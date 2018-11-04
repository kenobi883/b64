package com.marcdenning.base64.encode

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * See [RFC 4648 Section 4](https://tools.ietf.org/html/rfc4648#section-4) for canonical encoding specification.
 */
@RunWith(Parameterized::class)
class Base64EncoderTests(private val input: String, private val output: String) {

    private lateinit var base64Encoder: Base64Encoder

    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun data(): Collection<Array<String>> {
            return listOf(
                    arrayOf("", ""),
                    arrayOf("foobar", "Zm9vYmFy")
            )
        }
    }

    @Before
    fun setUp() {
        base64Encoder = Base64Encoder()
    }

    @Test
    fun `properly encodes the string`() {
        assert.that(base64Encoder.encode(input), equalTo(output))
    }
}
