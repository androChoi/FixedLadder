package com.andro.control_ladder_game.recycler_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andro.control_ladder_game.databinding.LayoutProbabilityItemBinding

private const val TAG = "ProbabilityAdapter"
class ProbabilityAdapter(private val dataSet : ArrayList<ProbabilityItem>) : RecyclerView.Adapter<ProbabilityAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutProbabilityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    class ViewHolder(private val binding : LayoutProbabilityItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : ProbabilityItem){
            binding.id = item.userId
            val probability = item.probability.toDoubleOrNull()

            binding.content = if (probability != null && probability >= 0.1f) {
                String.format("%.1f", probability)
            } else {
                "0"
            }

            binding.perUnit.visibility = if(!item.visible) View.INVISIBLE else View.VISIBLE
        }
    }
}
data class ProbabilityItem(val userId : String, val probability : String, val visible : Boolean)