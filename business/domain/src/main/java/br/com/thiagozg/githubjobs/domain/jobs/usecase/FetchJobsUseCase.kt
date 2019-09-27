package br.com.thiagozg.githubjobs.domain.jobs.usecase

import br.com.thiagozg.githubjobs.domain.UseCase
import br.com.thiagozg.githubjobs.domain.jobs.GitHubRepository
import br.com.thiagozg.githubjobs.domain.jobs.model.business.JobBO

/*
 * Created by Thiago Zagui Giacomini on 25/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class FetchJobsUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<JobBO, FetchJobsUseCase.Params>() {

    override suspend fun run(params: Params): JobBO {
        gitHubRepository.fetchJobs(params.language, params.location)

    }

    inner class Params(
        val language: String?,
        val location: String?
    )

}