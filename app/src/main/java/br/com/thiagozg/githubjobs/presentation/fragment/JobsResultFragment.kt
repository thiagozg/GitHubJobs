package br.com.thiagozg.githubjobs.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.data.model.JobDTO
import br.com.thiagozg.githubjobs.data.model.StateSuccess
import br.com.thiagozg.githubjobs.presentation.MainViewModel
import br.com.thiagozg.githubjobs.presentation.adapter.JobsResultAdapter
import br.com.thiagozg.githubjobs.presentation.adapter.JobsResultListener
import kotlinx.android.synthetic.main.fragment_jobs_result.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobsResultFragment : Fragment(), JobsResultListener {

    private val viewModel by sharedViewModel<MainViewModel>()
    private val jobsResultAdapter: JobsResultAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_jobs_result, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jobsResultList = viewModel.jobsData.value as? StateSuccess<List<JobDTO>>
        jobsResultList?.let {
            rvJobsResults.run {
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
                jobsResultAdapter.run {
                    // TODO: make this convertion on Domain
                    val jobVOList = it.data.map { it.toVO() }
                    addItems(jobVOList)
                    setListener(this@JobsResultFragment)
                }
                adapter = jobsResultAdapter
            }
        }
    }

    override fun onClick(jobVO: JobVO) {
        val nextAction =
            JobsResultFragmentDirections.actionJobsResultToJobDetails(jobVO)
        findNavController().navigate(nextAction)
    }
}
