package br.com.thiagozg.githubjobs.jobsresults

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.thiagozg.githubjobs.domain.jobs.model.business.jobs.JobBO
import br.com.thiagozg.githubjobs.domain.jobs.usecase.FetchJobsUseCase
import br.com.thiagozg.githubjobs.jobsresults.fragment.models.InputQueryDTO
import br.com.thiagozg.githubjobs.jobsresults.fragment.models.JobVO
import br.com.thiagozg.githubjobs.jobsresults.fragment.models.toVO
import kotlinx.coroutines.launch

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class MainViewModel(private val fetchJobsUseCase: FetchJobsUseCase) : ViewModel() {

    private val _jobsLiveData = MutableLiveData<JobsResultState>()
    val jobsLiveData: LiveData<JobsResultState>
        get() = _jobsLiveData

    fun fetchJobs(inputQueryDTO: InputQueryDTO) {
        viewModelScope.launch {
            _jobsLiveData.postValue(JobsResultState.Loading)
            val params = inputQueryDTO.run {
                FetchJobsUseCase.Params(language, location)
            }
            val stateBusiness = fetchJobsUseCase(params)
            val jobsResultState = stateBusiness.fold<List<JobBO>, JobsResultState>(
                { JobsResultState.Success(it.map { bo -> bo.toVO() }) },
                { JobsResultState.Error }
            )
            _jobsLiveData.postValue(jobsResultState)
        }
    }

    sealed class JobsResultState {
        data class Success(val jobsListVO: List<JobVO>) : JobsResultState()
        object Loading : JobsResultState()
        object Error : JobsResultState()
    }
}