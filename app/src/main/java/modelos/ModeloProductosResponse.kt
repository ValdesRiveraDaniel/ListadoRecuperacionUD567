package modelos

data class ModeloProductosResponse (

    val id: String,
    val nombre: String,
    val descripcion: String,
    val stock: Int,
    val regularPrice: Int,
    val discountPrice: Int,
    val available: Boolean,
    val imgurl: String,

)