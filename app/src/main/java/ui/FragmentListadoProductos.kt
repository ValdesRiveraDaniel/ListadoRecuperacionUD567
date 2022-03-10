package ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.FragmentListadoProductosBinding
import network.ProductosResponseItem


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

        binding.btnIrfav.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentListadoProductos_to_favFragment)
        }

        var list  = mutableListOf<ProductosResponseItem>()
        list.add(ProductosResponseItem(available = true,"APEX",2.0,"agua","agu","pe",2.0,3))



        adapter.submitList(list)
        binding.rvListadoProductos.adapter = adapter
        binding.rvListadoProductos.layoutManager = GridLayoutManager(context,2)
    }
}