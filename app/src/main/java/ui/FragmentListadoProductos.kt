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
import databases.DatabaseManager
import databases.interfaceDDBB
import network.NetworkManager


import network.ProductosResponseItem


class FragmentListadoProductos : Fragment() {

    private lateinit var binding: FragmentListadoProductosBinding
    private lateinit var adapter: PLAdapter
    private lateinit var db: interfaceDDBB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = DatabaseManager.getInstance(requireContext().applicationContext).roomDb().apply {
            NetworkManager.setDDBB(this)
        }


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


        binding.btnIrfav.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_fragmentListadoProductos_to_favFragment)
        }

        var list  = db?.getAll()
        NetworkManager.getProducts()
        adapter = PLAdapter(db?.getAll(), view.context)

        binding.rvListadoProductos.adapter = adapter
        binding.rvListadoProductos.layoutManager = GridLayoutManager(context,2)
    }
}