package com.andro.control_ladder_game.recycler_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andro.control_ladder_game.databinding.ItemUserListLayoutBinding
import com.andro.control_ladder_game.databinding.LayoutProbabilityItemBinding
import com.andro.control_ladder_game.ladder_library.HorseData

class UserListAdapter(private val onClick : (Int) -> Unit) : RecyclerView.Adapter<UserListAdapter.ViewHolder>(){
    private var dataSet = arrayListOf<HorseData>()
    fun setUserList(horseList : ArrayList<HorseData>){
        dataSet = horseList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    inner class ViewHolder(private val binding : ItemUserListLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : HorseData){
            binding.horseData = item
            binding.itemLayout.setOnClickListener {
                onClick(absoluteAdapterPosition)
            }
        }
    }
}