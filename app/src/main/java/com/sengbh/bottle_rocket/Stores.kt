package com.sengbh.bottle_rocket

import java.io.Serializable


data class Store constructor(
    val address: String? = null,
    val phone: String? = null,
    val storeLogoURL: String? = null
) : Serializable

data class Stores constructor(
    val stores: List<Store> = emptyList()
)