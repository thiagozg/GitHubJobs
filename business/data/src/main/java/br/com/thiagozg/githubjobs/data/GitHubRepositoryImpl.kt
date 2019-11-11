package br.com.thiagozg.githubjobs.data

import br.com.thiagozg.githubjobs.data.model.toBO
import br.com.thiagozg.githubjobs.domain.jobs.GitHubRepository
import br.com.thiagozg.githubjobs.domain.jobs.model.business.jobs.JobBO

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class GitHubRepositoryImpl(private val gitHubApi: GitHubApiDataSource) : GitHubRepository {

    override suspend fun fetchJobsAsync(
        language: String?,
        location: String?
    ): List<JobBO> = gitHubApi
        .fetchJobsAsync(language, location)
        .map { it.toBO() }

}
