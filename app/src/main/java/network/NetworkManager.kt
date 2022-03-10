package network

import databases.ModeloProductosBBDD
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import databases.interfaceDDBB
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
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
            val products = call.body()

            if(call.isSuccessful){
                if (products != null) {
                    for (content in products) {
                        db?.insert(ModeloProductosBBDD(content.available,content.description, content.discountPrice, content.id,content.imageUrl,content.name,content.regularPrice,content.stock,false))
                    }
                }
            }
        }
    }

    fun postProducts(id: String, name: String, description: String, stock:String, regularPrice:String, discountPrice:String, avaiable: String, imageUrl: String){
        CoroutineScope(Dispatchers.IO).launch {
            var jsonRequest1 = createJsonRequestBody("id" to id, "name" to name, "description" to description, "stock" to stock,
                "regularPrice" to regularPrice, "discountPrice" to discountPrice, "available" to avaiable, "imageUrl" to imageUrl)

            val call = getRetrofit().create(networkService::class.java).postData(jsonRequest1)
            val products = call.body()
        }
    }

    private fun createJsonRequestBody(vararg params: Pair<String, String>) =
        JSONObject(mapOf(*params)).toString()
            .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())



}