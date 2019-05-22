package br.com.thiagozg.githubjobs.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.domain.InputQueryDTO
import kotlinx.android.synthetic.main.fragment_input_language.*

/*
 * Created by Thiago Zagui Giacomini on 20/05/2019.
 * See thiagozg on GitHub (https://github.com/thiagozg)
 */
class InputLanguageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input_language, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btContinue.setOnClickListener {
            val inputQueryDTO = InputQueryDTO(language = tietLanguage.text.toString())
            val nextAction = InputLanguageFragmentDirections.actionToLocationFragment(inputQueryDTO)
            Navigation.findNavController(it).navigate(nextAction)
        }
    }

}
