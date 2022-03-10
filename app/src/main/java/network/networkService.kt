package network

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface networkService {

    @GET
    suspend fun getData(@Url url:String): Response<ProductosResponse>

    @POST("product")
    suspend fun postData(@Body requestBody: RequestBody): Response<String>
}