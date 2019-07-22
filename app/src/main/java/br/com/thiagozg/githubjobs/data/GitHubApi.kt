package br.com.thiagozg.githubjobs.data

import br.com.thiagozg.githubjobs.data.model.JobDTO
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
interface GitHubApi {

    @GET("/positions.json")
    fun fethJobs(
        @Query("description") language: String?,
        @Query("location") location: String?
    ): Deferred<Response<List<JobDTO>>>
}