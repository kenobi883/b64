package com.marcdenning.base64.decode

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.OutputStream

class DecodeCommand(
        private val outputStream: OutputStream,
        private val decoder: Decoder
) : CliktCommand(name = "decode") {

    val input by argument()

    override fun run() {
        outputStream.write(decoder.decode(input).toByteArray(Charsets.US_ASCII))
        outputStream.write("\r\n".toByteArray())
        outputStream.flush()
    }
}
