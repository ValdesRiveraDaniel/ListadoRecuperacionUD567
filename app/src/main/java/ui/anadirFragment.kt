package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.listadorecuperacionud567.R
import com.example.listadorecuperacionud567.databinding.FragmentAnadirBinding
import com.example.listadorecuperacionud567.databinding.FragmentListadoProductosBinding
import network.NetworkManager

class favFragment : Fragment() {

    private lateinit var binding: FragmentAnadirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        this.binding = FragmentAnadirBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tbnAnadir.setOnClickListener{

            NetworkManager.postProducts("0",binding.ptName.toString(),binding.ptDescripcion.toString(),binding.ptStock.toString(),binding.ptPrice.toString(),binding.ptPrecioDescuento.toString(),avaiable = "true", binding.ptImgUrl.toString())
        }
    }





}