package br.com.thiagozg.githubjobs.domain.jobs.usecase

import br.com.thiagozg.githubjobs.domain.UseCase
import br.com.thiagozg.githubjobs.domain.jobs.GitHubRepository
import br.com.thiagozg.githubjobs.domain.jobs.model.business.StateBusiness
import br.com.thiagozg.githubjobs.domain.jobs.model.business.jobs.JobBO
import br.com.thiagozg.githubjobs.domain.jobs.model.business.runCatchingState

/*
 * Created by Thiago Zagui Giacomini on 25/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class FetchJobsUseCase(
    private val gitHubRepository: GitHubRepository
) : UseCase<FetchJobsUseCase.Params, List<JobBO>>() {

    override suspend fun run(params: Params): StateBusiness<List<JobBO>> = runCatchingState {
        gitHubRepository.fetchJobsAsync(params.language, params.location)
    }

//    try {
//        val jobsBoList = gitHubRepository.fetchJobsAsync(params.language, params.location)
//        StateBusiness.success(jobsBoList)
//    } catch (e: Exception) {
//        StateBusiness.error(e)
//    }

    class Params(
        val language: String?,
        val location: String?
    )

}