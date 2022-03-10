package network

data class ProductosResponseItem(
    val available: Boolean,
    val description: String,
    val discountPrice: Double,
    val id: String,
    val imageUrl: String,
    val name: String,
    val regularPrice: Double,
    val stock: Int
)