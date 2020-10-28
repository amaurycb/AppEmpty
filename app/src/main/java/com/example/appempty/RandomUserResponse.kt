
package com.example.appempty
import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName


data class RandomUserResponse(
//    @SerializedName("info")
//    val info: IDNA.Info,
    @SerializedName("results")
    val results: List<UserProfile>
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)

data class Info(
    @SerializedName("page")
    val page: String,
    @SerializedName("results")
    val results: String,
    @SerializedName("seed")
    val seed: String,
    @SerializedName("version")
    val version: String
)

data class Location(
    @SerializedName("city")
    val city: String,
//    @SerializedName("coordinates")
//    val coordinates: Coordinates,
    @SerializedName("country")
    val country: String,
//    @SerializedName("postcode")
//    val postcode: Int,
    @SerializedName("state")
    val state: String
//    @SerializedName("street")
//    val street: Street,
//    @SerializedName("timezone")
//    val timezone: Timezone
)

data class Login(
    @SerializedName("md5")
    val md5: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("salt")
    val salt: String,
    @SerializedName("sha1")
    val sha1: String,
    @SerializedName("sha256")
    val sha256: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("uuid")
    val uuid: String
)

data class Name(
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("title")
    val title: String
)

data class Picture(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)

data class UserProfile(
    @SerializedName("email")
    val email: String = "",
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("login")
    val login: Login? = null,
    @SerializedName("name")
    val name: Name? = null,
    @SerializedName("phone")
    val phone: String = "",
    @SerializedName("picture")
    val picture: Picture? = null
)


data class Street(
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: String
)

data class Timezone(
    @SerializedName("description")
    val description: String,
    @SerializedName("offset")
    val offset: String
)