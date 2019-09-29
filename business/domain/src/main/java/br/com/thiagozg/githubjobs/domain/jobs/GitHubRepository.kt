package br.com.thiagozg.githubjobs.domain.jobs

import br.com.thiagozg.githubjobs.domain.jobs.model.business.jobs.JobBO

/*
 * Created by Thiago Zagui Giacomini on 26/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
interface GitHubRepository {

    suspend fun fetchJobsAsync(
        language: String?,
        location: String?
    ): List<JobBO>

}