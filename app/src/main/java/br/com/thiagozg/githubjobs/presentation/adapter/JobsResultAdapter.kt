package br.com.thiagozg.githubjobs.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import br.com.thiagozg.githubjobs.R
import br.com.thiagozg.githubjobs.data.model.JobDTO
import br.com.thiagozg.githubjobs.presentation.bindImageView
import kotlinx.android.synthetic.main.item_job_result.view.*

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobsResultAdapter : RecyclerView.Adapter<JobsResultAdapter.JobResultHolder>() {

    private val jobsResultsList = mutableListOf<JobDTO>()
    private var listener: JobsResultListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobResultHolder =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_job_result, parent, false)
            .run { JobResultHolder(this) }

    override fun onBindViewHolder(holder: JobResultHolder, position: Int) =
        holder.bind(jobsResultsList[position])

    override fun getItemCount() = jobsResultsList.count()

    fun addItems(items: List<JobDTO>) {
        jobsResultsList.clear()
        jobsResultsList.addAll(items)
        notifyDataSetChanged()
    }

    fun setListener(listener: JobsResultListener) {
        this.listener = listener
    }

    inner class JobResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(jobDTO: JobDTO) = with(itemView) {
            val companyLabel = resources.getString(R.string.company, jobDTO.company)
            tvTitle.text = jobDTO.title
            tvCompanyName.text = companyLabel
            tvCompanyLocation.text = jobDTO.location
            ivCompanyLogo.bindImageView(companyLabel, jobDTO.companyLogo)
            setScaleAnimation()
            setOnClickListener { listener?.onClick(jobDTO) }
        }

        private fun View.setScaleAnimation() {
            val anim = ScaleAnimation(
                0.0F,
                1.0F,
                0.0F,
                1.0F,
                Animation.RELATIVE_TO_SELF,
                PIVOT_VALUE,
                Animation.RELATIVE_TO_SELF,
                PIVOT_VALUE
            ).also { it.duration = FADE_DURATION }
            startAnimation(anim)
        }
    }

    companion object {
        private const val FADE_DURATION = 400L
        private const val PIVOT_VALUE = 0.5f
    }
}