package br.com.thiagozg.githubjobs.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.thiagozg.githubjobs.di.GitHubApiProvider
import br.com.thiagozg.githubjobs.domain.InputQueryDTO
import br.com.thiagozg.githubjobs.domain.JobsVO
import kotlinx.coroutines.*

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class GitHubRepository(application: Application) {

    private val gitHubApi = GitHubApiProvider.buildServiceApi(application)

    fun fetchJobs(
        inputQueryDTO: InputQueryDTO,
        jobsData: MutableLiveData<List<JobsVO>>,
        viewModelJob: CompletableJob
    ) {
        val uiScope = Dispatchers.Main + viewModelJob
        GlobalScope.launch(uiScope) {
            withContext(Dispatchers.Default) {
                jobsData.postValue(
                    inputQueryDTO.run {
                        gitHubApi.fethJobs(language, location)
                    }.await()
                )
            }
        }
    }
}