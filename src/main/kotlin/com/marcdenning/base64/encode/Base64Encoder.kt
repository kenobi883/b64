package com.marcdenning.base64.encode

import java.util.*

class Base64Encoder : Encoder {

    override fun encode(source: String): String = Base64.getEncoder()
            .encode(source.toByteArray(Charsets.US_ASCII))
            .toString(Charsets.US_ASCII)
}
