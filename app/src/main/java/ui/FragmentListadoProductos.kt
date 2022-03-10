package ui

import android.content.AbstractThreadedSyncAdapter
import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.FragmentListadoProductosBinding
import com.example.listadorecuperacionud567.databinding.ProductoBinding
import modelos.ModeloProductos


class FragmentListadoProductos : Fragment() {

    private lateinit var binding: FragmentListadoProductosBinding
    private lateinit var adapter: PLAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = FragmentListadoProductosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PLAdapter {
            ModeloProductos ->
            val args = Bundle()
            args.putString("id",ModeloProductos.id)
            findNavController().navigate(R.id.action_fragmentListadoProductos_to_detalleProductos)
        }

        var list  = mutableListOf<ModeloProductos>()
        list.add(ModeloProductos("0","APEX","descripcion",0,0,0,true,"https://logodownload.org/wp-content/uploads/2019/02/apex-legends-logo-3.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","APEX","descripcion",0,0,0,true,"https://logodownload.org/wp-content/uploads/2019/02/apex-legends-logo-3.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","nombre","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))
        list.add(ModeloProductos("0","chocolate","descripcion",0,0,0,true,"https://www.pngmart.com/files/17/Thing-PNG-Free-Download.png"))

        adapter.submitList(list)
        binding.rvListadoProductos.adapter = adapter
        binding.rvListadoProductos.layoutManager = GridLayoutManager(context,2)
    }
}