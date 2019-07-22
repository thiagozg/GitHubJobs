package br.com.thiagozg.githubjobs.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.data.StateError
import br.com.thiagozg.githubjobs.data.StateSuccess
import br.com.thiagozg.githubjobs.data.model.InputQueryDTO
import br.com.thiagozg.githubjobs.presentation.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_input_location.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class InputLocationFragment : Fragment() {

    private val viewModel by sharedViewModel<MainViewModel>()

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
                is StateSuccess<*> -> showJobsList()
                is StateError -> showSnackbarError()
            }
        })
    }

    private fun showJobsList() {
        val nextAction =
            InputLocationFragmentDirections.actionToJobsResultFragment()
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
