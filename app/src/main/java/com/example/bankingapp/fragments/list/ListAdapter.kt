package com.example.bankingapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankingapp.R
import database.UserEntity
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<UserEntity>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.textViewRowName.text = currentItem.name
        holder.itemView.textViewRowEmail.text = currentItem.email
        holder.itemView.textViewRowAmount.text = currentItem.amount.toString()

        holder.itemView.constraintLayoutCustomRow.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToTransferFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }


    }
    fun setData(userEntity: List<UserEntity>) {
        this.userList=userEntity
        notifyDataSetChanged()
    }
}