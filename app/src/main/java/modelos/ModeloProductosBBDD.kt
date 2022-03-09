package modelos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ModeloProductosBBDD (

    @PrimaryKey
    val id: String,
    val nombre: String,
    val descripcion: String,
    val stock: Int,
    val regularPrice: Int,
    val discountPrice: Int,
    val available: Boolean,
    val imgurl: String,
    val fav: Boolean,

    )