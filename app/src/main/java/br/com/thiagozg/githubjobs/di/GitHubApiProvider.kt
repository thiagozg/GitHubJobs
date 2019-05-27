package br.com.thiagozg.githubjobs.di

import android.app.Application
import br.com.thiagozg.githubjobs.data.GitHubApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
object GitHubApiProvider {

    private const val BASE_GITHUB_API_URL = "https://jobs.github.com"
    private const val TIMEOUT_SECONDS = 15L

    fun buildServiceApi(application: Application): GitHubApi {
        val httpCache = provideHttpCache(application)
        val okHttpClient = providesOkHttpClient(httpCache)
        val retrofit = providesRetrofit(okHttpClient)
        return retrofit.create(GitHubApi::class.java)
    }

    private fun providesRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BASE_GITHUB_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()

    private fun providesOkHttpClient(cache: Cache): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addNetworkInterceptor(logging)
            .addInterceptor(logging)
            .cache(cache)
            .build()
    }

    private fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }
}