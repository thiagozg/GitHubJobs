package br.com.thiagozg.githubjobs.data.model

import br.com.thiagozg.githubjobs.domain.jobs.model.business.jobs.CompanyBO
import br.com.thiagozg.githubjobs.domain.jobs.model.business.jobs.JobBO

/*
 * Created by Thiago Zagui Giacomini on 28/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
fun JobResponse.toBO() = JobBO(
    CompanyBO(
        company,
        companyLogo,
        companyUrl
    ),
    createdAt,
    description,
    howToApply,
    location,
    title,
    type,
    url
)