package br.com.thiagozg.githubjobs.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.domain.InputQueryDTO
import kotlinx.android.synthetic.main.fragment_input_location.*

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class InputLocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_input_location, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btContinue.setOnClickListener { buttonView ->
            val inputQueryDTO = arguments?.let {
                InputLocationFragmentArgs.fromBundle(it).inputQueryDTO
            }?.also {
                it.location = tietLocation.text.toString()
            } ?: InputQueryDTO()
            val nextAction = InputLocationFragmentDirections.actionToJobsResultFragment(inputQueryDTO)
            Navigation.findNavController(buttonView).navigate(nextAction)
        }
    }
}
