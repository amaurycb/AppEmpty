package com.example.appempty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class ItemAdapter(
    private val listUsers: List<UserProfile>,
    private val onUserSelectedCLick: (UserProfile) -> Unit
) :
    RecyclerView.Adapter<ItemAdapter.UserViewHolder>() {

    class UserViewHolder(private val holder: View) : RecyclerView.ViewHolder(holder) {
        fun bind(userProfile: UserProfile, onCLick: (UserProfile) -> Unit) {
            holder.first_name.text =
                userProfile.name?.let { "${it.first}  ${it.last}" } ?: "No Name"
            userProfile.picture?.let { picture ->
                Glide.with(holder.context)
                    .load(picture.large)
                    .into(holder.first_avatar)
            }
            holder.setOnClickListener { onCLick.invoke(userProfile) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val holder = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return UserViewHolder(holder)
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUsers[position], onUserSelectedCLick)
    }

}