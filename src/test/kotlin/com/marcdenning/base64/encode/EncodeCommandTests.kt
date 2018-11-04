package com.marcdenning.base64.encode

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.endsWith
import com.natpryce.hamkrest.startsWith
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class EncodeCommandTests {

    private lateinit var outputStream: ByteArrayOutputStream
    private lateinit var encoder: Encoder
    private lateinit var encodeCommand: EncodeCommand

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        encoder = mock()
        encodeCommand = EncodeCommand(outputStream, encoder)
    }

    @Test
    fun `writes output to output stream when provided input`() {
        val input = "foobar"
        val output = "raboof"

        whenever(encoder.encode(input)).thenReturn(output)
        encodeCommand.main(arrayOf(input))

        val actualOutput = outputStream.toByteArray().toString(Charsets.US_ASCII)

        assert.that(actualOutput, startsWith(output))
        assert.that(actualOutput, endsWith("\r\n"))
    }
}
