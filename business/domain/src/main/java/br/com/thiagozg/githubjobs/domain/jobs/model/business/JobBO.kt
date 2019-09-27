package br.com.thiagozg.githubjobs.domain.jobs.model.business

/*
 * Created by Thiago Zagui Giacomini on 25/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobBO(
    val companyBO: CompanyBO
    val createdAt: String,
    val description: String,
    val howToApply: String,
    val location: String,
    val title: String,
    val type: String,
    val url: String
)
