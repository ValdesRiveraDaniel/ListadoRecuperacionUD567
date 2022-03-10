package network

import android.util.Log
import databases.DatabaseManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import modelos.interfaceDDBB
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    var db: interfaceDDBB? = null

    fun setDDBB(db: interfaceDDBB){
        this.db = db
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(
            "http://192.168.1.50:1111/"
        ).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getProducts(){
        CoroutineScope(Dispatchers.IO).launch {

            val call = getRetrofit().create(networkService::class.java).getData("product")
            val user = call.body()

            if(call.isSuccessful){

            }else{

            }

        }
    }
}