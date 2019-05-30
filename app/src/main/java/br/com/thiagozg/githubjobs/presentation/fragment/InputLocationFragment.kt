package br.com.thiagozg.githubjobs.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.thiagozg.domain.api.StateError
import br.com.thiagozg.domain.api.StateSuccess
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.domain.api.fetchjobs.InputQueryDTO
import br.com.thiagozg.githubjobs.domain.api.fetchjobs.JobVO
import br.com.thiagozg.githubjobs.domain.api.fetchjobs.JobsListVO
import br.com.thiagozg.githubjobs.presentation.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_input_location.*

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class InputLocationFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainViewModel.providesViewModel(
            requireActivity().application)
        observeJobsData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_input_location, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btContinue.setOnClickListener { onContinueClick() }
    }

    private fun onContinueClick() {
        val inputQueryDTO = arguments?.let {
            InputLocationFragmentArgs.fromBundle(it).inputQueryDTO
        }?.also {
            it.location = tietLocation.text.toString()
        } ?: InputQueryDTO()
        viewModel.fetchJobs(inputQueryDTO)
    }

    private fun observeJobsData() {
        viewModel.jobsData.observe(this, Observer { stateResponse ->
            when (stateResponse) {
                is StateSuccess<*> -> showJobsList(stateResponse.data as? List<JobVO> ?: listOf())
                is StateError -> showSnackbarError()
            }
        })
    }

    private fun showJobsList(jobsVO: List<JobVO>) {
        val jobsListVO = JobsListVO(jobsVO)
        val nextAction =
            InputLocationFragmentDirections.actionToJobsResultFragment(jobsListVO)
        findNavController().navigate(nextAction)
    }

    private fun showSnackbarError() {
        val contentViewGroup = requireActivity().findViewById<ViewGroup>(android.R.id.content)
        Snackbar.make(
            contentViewGroup,
            getString(R.string.error_api_message),
            Snackbar.LENGTH_SHORT
        ).show()
    }
}
