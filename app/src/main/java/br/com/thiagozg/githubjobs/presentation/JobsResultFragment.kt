package br.com.thiagozg.githubjobs.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.thiagozg.githubjobs.R

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobsResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jobs_result, container, false)
    }

}