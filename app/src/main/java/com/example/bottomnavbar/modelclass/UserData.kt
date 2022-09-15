package com.example.bottomnavbar.modelclass

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("login")
    val login: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("node_id")
    val nodeID: String,

    @SerializedName("avatar_Url")
    val avatarUrl: String,

    @SerializedName("gravatar_id")
    val gravatarID: String?,

    @SerializedName("url")
    val url: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("followers_url")
    val followerUrl: String,

    @SerializedName("following_url")
    val followingUrl: String,

    @SerializedName("gists_url")
    val gistsUrl: String,

    @SerializedName("starred_url")
    val starredUrl: String,

    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String,

    @SerializedName("organizations_url")
    val organizationUrl: String,

    @SerializedName("repos_url")
    val reposUrl: String,

    @SerializedName("events_url")
    val eventsUrl: String,

    @SerializedName("received_events_url")
    val receivedEventsUrl: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("site_admin")
    val siteAdmin: Boolean,

    @SerializedName("name")
    val name: Boolean,

    @SerializedName("company")
    val company: Boolean,

    @SerializedName("blog")
    val blog: String,

    @SerializedName("location")
    val location: Boolean,

    @SerializedName("email")
    val email: Boolean,

    @SerializedName("hireable")
    val hireable: Boolean,

    @SerializedName("bio")
    val bio: Boolean,

    @SerializedName("twitter_username")
    val twitterUserName: Boolean,

    @SerializedName("public_repos")
    val publicRepos: Int,

    @SerializedName("public_gists")
    val publicGists: Int,

    @SerializedName("followers")
    val followers: Int,

    @SerializedName("following")
    val following: Int,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String
)
