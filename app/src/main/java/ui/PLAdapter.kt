package ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.ProductoBinding
import com.squareup.picasso.Picasso

class PLAdapter(private val onClickProductos: (ModeloProductosResponse) -> Unit) :
    ListAdapter<ModeloProductosResponse, PLAdapter.ViewHolder>(DiffUtilCallback) {

    inner class ViewHolder(val binding: ProductoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ProductoBinding = ProductoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = getItem(position)
        holder.binding.tvNombre.text = producto.nombre
        Picasso.get().load(producto.imgurl).placeholder(R.mipmap.ic_launcher).into(holder.binding.ivImagen)
        holder.binding.root.setOnClickListener { (onClickProductos(producto)) }
    }

}

private object DiffUtilCallback : DiffUtil.ItemCallback<ModeloProductosResponse>() {

    override fun areItemsTheSame(oldItem: ModeloProductosResponse, newItem: ModeloProductosResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ModeloProductosResponse, newItem: ModeloProductosResponse): Boolean {
        return oldItem.id == newItem.id
    }

}

