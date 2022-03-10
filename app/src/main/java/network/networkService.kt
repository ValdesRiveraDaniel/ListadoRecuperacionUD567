package network

import modelos.ModeloProductosResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface networkService {

    @GET
    suspend fun getData(@Url url:String): Response<ModeloProductosResponse>

    @POST("product")
    suspend fun login(@Body requestBody: RequestBody)
}