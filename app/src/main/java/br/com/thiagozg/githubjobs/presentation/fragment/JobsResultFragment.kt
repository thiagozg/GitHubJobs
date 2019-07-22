package br.com.thiagozg.githubjobs.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobsResultFragment : Fragment() {

    private val viewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_jobs_result, container, false)

    override fun onResume() {
        super.onResume()
        viewModel.jobsData
    }
}
