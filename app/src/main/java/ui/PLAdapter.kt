package ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.ProductoBinding
import com.squareup.picasso.Picasso
import modelos.ModeloProductos

class PLAdapter(private val onClickProductos: (ModeloProductos) -> Unit) :
    ListAdapter<ModeloProductos, PLAdapter.ViewHolder>(DiffUtilCallback) {

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

private object DiffUtilCallback : DiffUtil.ItemCallback<ModeloProductos>() {

    override fun areItemsTheSame(oldItem: ModeloProductos, newItem: ModeloProductos): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ModeloProductos, newItem: ModeloProductos): Boolean {
        return oldItem.id == newItem.id
    }

}

