package br.com.thiagozg.githubjobs.data

import android.app.Application
import br.com.thiagozg.githubjobs.di.GitHubApiProvider
import br.com.thiagozg.githubjobs.domain.InputQueryDTO

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class GitHubRepository(application: Application) {

    private val gitHubApi = GitHubApiProvider.buildServiceApi(application)

    fun fetchJobs(inputQueryDTO: InputQueryDTO) {
        inputQueryDTO.run {
            gitHubApi.fethJobs(language, location)
        }
    }
}