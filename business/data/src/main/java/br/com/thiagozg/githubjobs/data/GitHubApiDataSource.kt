package br.com.thiagozg.githubjobs.data

import br.com.thiagozg.githubjobs.domain.jobs.model.datasource.JobResponse
import retrofit2.http.GET
import retrofit2.http.Query

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
interface GitHubApiDataSource {

    @GET("/positions.json")
    suspend fun fetchJobsAsync(
        @Query("description") language: String?,
        @Query("location") location: String?
    ): List<JobResponse>
}