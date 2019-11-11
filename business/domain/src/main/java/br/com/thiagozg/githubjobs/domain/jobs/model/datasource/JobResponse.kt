package br.com.thiagozg.githubjobs.domain.jobs.model.datasource

import com.google.gson.annotations.SerializedName

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
class JobResponse(
    @SerializedName("company")
    val company: String,
    @SerializedName("company_logo")
    val companyLogo: String?,
    @SerializedName("company_url")
    val companyUrl: String?,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("how_to_apply")
    val howToApply: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)
