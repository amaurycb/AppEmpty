package com.example.appempty

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.item_list.view.*



class rvAdapter(  myDataset: ArrayList< UserProfile>, contexto:Context) :  RecyclerView.Adapter<rvAdapter.UserViewHolder>() {

    var usuarios: ArrayList<UserProfile>? = null
    var contexto: Context?= null
    init {
        this.usuarios = myDataset
        this.contexto = contexto
    }


    class UserViewHolder (vista: View) : RecyclerView.ViewHolder(vista){
       var imagen : ImageView? = null
       var nombre : TextView? = null

        init {
            imagen = vista.first_avatar
            nombre = vista.first_name
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): UserViewHolder {
        // create a new view
        val ViewUser: View = LayoutInflater.from(contexto).inflate(R.layout.item_list,parent,false)  //esto no entiendo ni la mitad
        val personaViewHolder = UserViewHolder(ViewUser)
        ViewUser.tag = personaViewHolder
        return personaViewHolder
    }


    override fun getItemCount(): Int {
        return this.usuarios!!.count()
    }


    override fun onBindViewHolder(holder: rvAdapter.UserViewHolder, position: Int) {
        holder.nombre!!.text = usuarios!![position].name.toString()

        usuarios!![position].picture?.let{ picture ->
                Glide.with(holder.itemView.context)
                    .load(picture.large)
                    .into(holder.itemView.first_avatar)
        }
    }

}


