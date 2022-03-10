package network

import androidx.room.PrimaryKey

class ProductosResponse : ArrayList<ProductosResponseItem>()

data class ModeloProductosResponse (

    val available: Boolean,
    val description: String,
    val discountPrice: Double,
    val id: String,
    val imageUrl: String,
    val name: String,
    val regularPrice: Double,
    val stock: Int

    )