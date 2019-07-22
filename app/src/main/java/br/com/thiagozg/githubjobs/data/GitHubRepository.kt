package br.com.thiagozg.githubjobs.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import br.com.thiagozg.githubjobs.data.model.InputQueryDTO
import br.com.thiagozg.githubjobs.di.GitHubApiProvider
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Dispatchers

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class GitHubRepository(application: Application) {

    private val gitHubApi = GitHubApiProvider.buildServiceApi(application)

    fun fetchJobs(
        inputQueryDTO: InputQueryDTO,
        jobsListData: MutableLiveData<StateResponse>,
        viewModelJob: CompletableJob
    ) {
        val uiScope = Dispatchers.Main + viewModelJob
        coroutineIoUi(uiScope, {
            inputQueryDTO.run {
                gitHubApi.fethJobs(language, location)
            }
        }, {
            jobsListData.postValue(StateSuccess(it))
        }, {
            jobsListData.postValue(StateError(it))
        })
    }
}
