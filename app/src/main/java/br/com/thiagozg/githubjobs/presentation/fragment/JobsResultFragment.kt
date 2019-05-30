package br.com.thiagozg.githubjobs.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.domain.InputQueryDTO
import kotlinx.android.synthetic.main.fragment_input_location.*

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobsResultFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = MainViewModel.providesViewModel(requireActivity().application)
        observeJobsData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jobs_result, container, false)
    }

    override fun onResume() {
        super.onResume()
        val inputQueryDTO = arguments?.let {
            InputLocationFragmentArgs.fromBundle(it).inputQueryDTO
        } ?: InputQueryDTO()
        viewModel.fetchJobs(inputQueryDTO)
    }
}
