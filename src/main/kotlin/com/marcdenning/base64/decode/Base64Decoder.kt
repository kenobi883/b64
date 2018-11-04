package com.marcdenning.base64.decode

import java.util.*

class Base64Decoder : Decoder {

    override fun decode(input: String): String = Base64.getDecoder()
            .decode(input.toByteArray(Charsets.US_ASCII))
            .toString(Charsets.US_ASCII)
}
