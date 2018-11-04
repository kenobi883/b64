package com.marcdenning.base64

import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.versionOption
import com.marcdenning.base64.decode.Base64Decoder
import com.marcdenning.base64.decode.DecodeCommand
import com.marcdenning.base64.encode.Base64Encoder
import com.marcdenning.base64.encode.EncodeCommand
import kotlin.system.exitProcess

class Base64Cli

fun main(args: Array<String>) {
    try {
        val encoder = Base64Encoder()
        val decoder = Base64Decoder()

        Base64Command()
                .subcommands(EncodeCommand(System.out, encoder), DecodeCommand(System.out, decoder))
                .versionOption("0.1.0")
                .main(args)

        exitProcess(0)
    } catch (e: Exception) {
        println(e.message)
        exitProcess(1)
    }
}
