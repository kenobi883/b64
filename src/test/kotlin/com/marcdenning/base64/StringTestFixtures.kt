package com.marcdenning.base64

import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments

class StringTestFixtures {

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
