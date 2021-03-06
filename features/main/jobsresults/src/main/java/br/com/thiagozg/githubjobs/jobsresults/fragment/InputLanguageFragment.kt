package br.com.thiagozg.githubjobs.jobsresults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.thiagozg.githubjobs.jobsresults.R
import br.com.thiagozg.githubjobs.jobsresults.fragment.models.InputQueryDTO
import kotlinx.android.synthetic.main.fragment_input_language.*

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub https://github.com/thiagozg
 */
class InputLanguageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_input_language, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btContinue.setOnClickListener {
            val inputQueryDTO =
                InputQueryDTO(
                    language = tietLanguage.text.toString()
                )
            val nextAction =
                InputLanguageFragmentDirections.actionToLocationFragment(
                    inputQueryDTO
                )
            findNavController().navigate(nextAction)
        }
    }
}
