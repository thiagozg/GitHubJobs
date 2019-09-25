package br.com.thiagozg.githubjobs.data

import androidx.lifecycle.MutableLiveData
import br.com.thiagozg.githubjobs.coroutineIoUi
import br.com.thiagozg.githubjobs.data.model.InputQueryDTO
import br.com.thiagozg.githubjobs.data.model.StateError
import br.com.thiagozg.githubjobs.data.model.StateResponse
import br.com.thiagozg.githubjobs.data.model.StateSuccess
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Dispatchers

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class GitHubRepository(private val gitHubApi: GitHubApi) {

    fun fetchJobs(
        inputQueryDTO: InputQueryDTO,
        jobsListData: MutableLiveData<StateResponse>,
        viewModelJob: CompletableJob
    ) {
        val uiScope = Dispatchers.Main + viewModelJob
        coroutineIoUi(uiScope, {
            inputQueryDTO.run {
                gitHubApi.fetchJobsAsync(language, location)
            }
        }, {
            jobsListData.postValue(StateSuccess(it))
        }, {
            jobsListData.postValue(StateError(it))
        })
    }
}
