package ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.FragmentDetalleProductosBinding
import com.example.listadorecuperacionud567.databinding.ProductoBinding
import com.squareup.picasso.Picasso
import network.ProductosResponseItem

class DLAdapter(private val onClickProductos: (ProductosResponseItem) -> Unit) : ListAdapter<ProductosResponseItem, DLAdapter.ViewHolder>(DiffUtilCallback) {

    inner class ViewHolder(val binding: FragmentDetalleProductosBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FragmentDetalleProductosBinding = FragmentDetalleProductosBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = getItem(position)
        val precio = getItem(position)
        holder.binding.tvNombreDt.text = producto.name
        holder.binding.tvPrecioDt.text = precio.regularPrice.toString()
        Picasso.get().load(producto.imageUrl).placeholder(R.mipmap.ic_launcher).into(holder.binding.ivDetalle)
        holder.binding.root.setOnClickListener { (onClickProductos(producto)) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
    }

    private object DiffUtilCallback : DiffUtil.ItemCallback<ProductosResponseItem>() {

        override fun areItemsTheSame(oldItem: ProductosResponseItem, newItem: ProductosResponseItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductosResponseItem, newItem: ProductosResponseItem): Boolean {
            return oldItem.id == newItem.id
        }

    }

}