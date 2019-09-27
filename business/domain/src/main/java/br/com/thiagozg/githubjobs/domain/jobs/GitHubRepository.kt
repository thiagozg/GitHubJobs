package br.com.thiagozg.githubjobs.domain.jobs

import br.com.thiagozg.githubjobs.domain.model.datasource.JobResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response

/*
 * Created by Thiago Zagui Giacomini on 26/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
interface GitHubRepository {

    fun fetchJobs(
        language: String?,
        location: String?
    ): Deferred<Response<List<JobResponse>>>

}