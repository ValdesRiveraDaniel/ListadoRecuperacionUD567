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
import databases.DatabaseManager
import databases.interfaceDDBB
import network.NetworkManager
import network.ProductosResponseItem


class DetalleProductos : Fragment() {

    private lateinit var binding: FragmentDetalleProductosBinding
    private lateinit var adapter: DLAdapter
    private lateinit var db: interfaceDDBB

    val args: DetalleProductosArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = DatabaseManager.getInstance(requireContext().applicationContext).roomDb().apply {

        }
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


        binding = FragmentDetalleProductosBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idItem = args.idItem
        val item = db.findByTitle(idItem)
        binding.tvNombreDt.text = item.name

    }

}