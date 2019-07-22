package br.com.thiagozg.githubjobs.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/*
 * Created by Thiago Zagui Giacomini on 24/05/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
@Parcelize
class JobVO(
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
) : Parcelable

@Parcelize
class JobsListVO(val jobsVO: List<JobVO>) : ArrayList<JobVO>(jobsVO), Parcelable
