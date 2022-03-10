package databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ModeloProductosBBDD (


    val available: Boolean,
    val description: String,
    val discountPrice: Double,
    @PrimaryKey
    val id: String,
    val imageUrl: String,
    val name: String,
    val regularPrice: Double,
    val stock: Int,
    val fav: Boolean,

    )