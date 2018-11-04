package com.marcdenning.base64.encode

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.OutputStream

class EncodeCommand(
        private val outputStream: OutputStream,
        private val encoder: Encoder
) : CliktCommand(name = "encode") {

    val input by argument()

    override fun run() {
        outputStream.write(encoder.encode(input).toByteArray())
        outputStream.write("\r\n".toByteArray())
        outputStream.flush()
    }
}
