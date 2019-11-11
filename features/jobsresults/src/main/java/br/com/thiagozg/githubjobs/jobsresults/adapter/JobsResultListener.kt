package br.com.thiagozg.githubjobs.jobsresults.adapter

import br.com.thiagozg.githubjobs.jobsresults.fragment.models.JobVO

/*
 * Created by Thiago Zagui Giacomini on 22/07/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
interface JobsResultListener {
    fun onClick(jobVO: JobVO)
}