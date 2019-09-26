package br.com.thiagozg.githubjobs.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.thiagozg.githubjobs.data.GitHubRepository
import br.com.thiagozg.githubjobs.data.model.StateResponse
import br.com.thiagozg.githubjobs.data.model.InputQueryDTO
import kotlinx.coroutines.SupervisorJob

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class MainViewModel(private val repository: GitHubRepository) : ViewModel() {

    val jobsData = MutableLiveData<StateResponse>()

    private val viewModelJob = SupervisorJob()

    fun fetchJobs(inputQueryDTO: InputQueryDTO) {
        repository.fetchJobs(inputQueryDTO, jobsData, viewModelJob)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}