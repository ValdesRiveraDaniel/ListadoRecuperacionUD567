package ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.ProductoBinding

import com.squareup.picasso.Picasso
import databases.ModeloProductosBBDD
import network.ProductosResponseItem




class PLAdapter (val items:List<ModeloProductosBBDD>, val context: Context): RecyclerView.Adapter<PLAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PLAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.producto, parent, false))
    }

    override fun onBindViewHolder(holder: PLAdapter.ViewHolder, position: Int) {
        val data = items[position]
        holder.put(data)
    }


    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding = ProductoBinding.bind(view)
        fun put(item: ModeloProductosBBDD){
            binding.tvNombre.text = item.name
            binding.tvPrecio.text = item.regularPrice.toString()
        }

    }

}
