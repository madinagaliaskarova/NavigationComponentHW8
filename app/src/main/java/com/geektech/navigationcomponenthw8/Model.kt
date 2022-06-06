package com.geektech.navigationcomponenthw8

import java.io.Serializable

data class Model(
    var imageView: Int? = null,
    var txt_first: String? = null,
    var txt_second: String? = null
) : Serializable
