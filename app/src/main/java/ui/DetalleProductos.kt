package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.FragmentDetalleProductosBinding
import com.example.listadorecuperacionud567.databinding.FragmentListadoProductosBinding
import network.ProductosResponseItem


class DetalleProductos : Fragment() {

    private lateinit var binding: FragmentDetalleProductosBinding
    private lateinit var adapter: DLAdapter

    val args: DetalleProductosArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_detalle_productos, container, false)
//    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val test = args.idItem
        println("Valdes la chupa")
        println(test)
        this.binding = FragmentDetalleProductosBinding.inflate(inflater,container,false)
        return binding.root

    }


}