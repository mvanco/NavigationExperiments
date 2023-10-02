package eu.matoosh.navigation.api

import com.google.gson.annotations.SerializedName
import eu.matoosh.navigation.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

data class ApiLoginResponse(
    @field:SerializedName("token") val token: String?,
    @field:SerializedName("validity") val validity: String?,
    @field:SerializedName("user_id") val userId: Int?,
    @field:SerializedName("error") val error: String?,
)

interface IceAppService {
    @FormUrlEncoded
    @POST("rest/ice/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("device_id") deviceId: String
    ): ApiLoginResponse

    companion object {
        fun create(): IceAppService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IceAppService::class.java)
        }
    }
}
