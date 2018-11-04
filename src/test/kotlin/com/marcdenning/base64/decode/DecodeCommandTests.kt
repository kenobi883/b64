package com.marcdenning.base64.decode

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.endsWith
import com.natpryce.hamkrest.startsWith
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class DecodeCommandTests {

    private lateinit var outputStream: ByteArrayOutputStream
    private lateinit var decoder: Decoder
    private lateinit var decodeCommand: DecodeCommand

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        decoder = mock()
        decodeCommand = DecodeCommand(outputStream, decoder)
    }

    @Test
    fun `writes output to output stream when provided input`() {
        val input = "Zm9vYmFy"
        val output = "yFmYv9mZ"

        whenever(decoder.decode(input)).thenReturn(output)
        decodeCommand.main(arrayOf(input))

        val actualOutput = outputStream.toByteArray().toString(Charsets.US_ASCII)

        assert.that(actualOutput, startsWith(output))
        assert.that(actualOutput, endsWith("\r\n"))
    }
}
