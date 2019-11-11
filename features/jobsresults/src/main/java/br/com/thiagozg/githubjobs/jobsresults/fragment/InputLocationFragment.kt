package br.com.thiagozg.githubjobs.jobsresults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.thiagozg.githubjobs.jobsresults.MainViewModel
import br.com.thiagozg.githubjobs.jobsresults.R
import br.com.thiagozg.githubjobs.jobsresults.fragment.models.InputQueryDTO
import br.com.thiagozg.githubjobs.jobsresults.observeNonNull
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_input_location.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class InputLocationFragment : Fragment() {

    private val viewModel by sharedViewModel<MainViewModel>()
    private var hasClickedOnContinue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        hasClickedOnContinue = true
        val inputQueryDTO = arguments?.let {
            InputLocationFragmentArgs.fromBundle(it).inputQueryDTO
        }?.also {
            it.location = tietLocation.text.toString()
        } ?: InputQueryDTO()
        viewModel.fetchJobs(inputQueryDTO)
    }

    private fun observeJobsData() {
        viewModel.jobsLiveData.observeNonNull(this) { state ->
            showProgress(false)
            when (state) {
                is MainViewModel.JobsResultState.Success -> showJobsList()
                is MainViewModel.JobsResultState.Loading -> showProgress(true)
                is MainViewModel.JobsResultState.Error -> showSnackbarError()
            }
        }
    }

    private fun showJobsList() {
        if (hasClickedOnContinue) {
            val nextAction =
                InputLocationFragmentDirections.actionToJobsResultFragment()
            findNavController().navigate(nextAction)
        }
    }

    private fun showProgress(showLoading: Boolean) {
        val progressVisibility: Int
        val viewsVisibility: Int
        if (showLoading) {
            progressVisibility = View.VISIBLE
            viewsVisibility = View.GONE
        } else {
            progressVisibility = View.GONE
            viewsVisibility = View.VISIBLE
        }

        lottieView.visibility = viewsVisibility
        tilLocation.visibility = viewsVisibility
        btContinue.visibility = viewsVisibility
        progressBar.visibility = progressVisibility
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
