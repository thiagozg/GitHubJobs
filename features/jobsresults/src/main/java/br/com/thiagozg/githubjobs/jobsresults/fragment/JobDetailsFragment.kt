package br.com.thiagozg.githubjobs.jobsresults.fragment

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.thiagozg.githubjobs.jobsresults.R
import br.com.thiagozg.githubjobs.jobsresults.fragment.models.JobVO
import br.com.thiagozg.githubjobs.jobsresults.bindImageView
import kotlinx.android.synthetic.main.fragment_job_details.*

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_job_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            JobDetailsFragmentArgs.fromBundle(it).jobDetails
        }?.run {
            val companyLabel = resources.getString(R.string.company, company)
            bindTextsLabels(companyLabel)
            ivCompanyLogo.bindImageView(companyLabel, companyLogo)
            tvDescription.movementMethod = ScrollingMovementMethod()
            bindHtmlLabels()
        }
    }

    private fun JobVO.bindTextsLabels(companyLabel: String) {
        tvTitle.text = title
        tvCompanyName.text = companyLabel
        tvCompanyLocation.text = location
        tvCreatedAt.text = getString(R.string.created_at, createdAt)
        tvWebSite.text = companyUrl
    }

    private fun JobVO.bindHtmlLabels() {
        val howToApplyLabel = getString(R.string.how_to_apply, howToApply)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvDescription.text = Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT)
            tvHowToApply.text = Html.fromHtml(howToApplyLabel, Html.FROM_HTML_MODE_COMPACT)
        } else {
            tvDescription.text = Html.fromHtml(description)
            tvHowToApply.text = Html.fromHtml(howToApplyLabel)
        }
    }
}