package com.rodrigo.financ.ui.fragment.balance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.financ.R
import com.rodrigo.financ.data.model.Task
import kotlinx.android.synthetic.main.custom_row.view.*

class BalanceAdapter : RecyclerView.Adapter<BalanceAdapter.BalanceAdapterViewHolder>() {
    private var taskList = emptyList<Task>()

    class BalanceAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): BalanceAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        return BalanceAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: BalanceAdapterViewHolder, position: Int) {
        val task = taskList[position]
        holder.itemView.tv_name.setText(task.tittle).toString()
        holder.itemView.tv_description.setText(task.description).toString()
        holder.itemView.tv_value.setText(task.value).toString()
        holder.itemView.custom_row.setOnClickListener {
            val actionUpdate = BalanceFragmentDirections.actionBalanceFragmentToUpdateFragment(task)
            holder.itemView.findNavController().navigate(actionUpdate)
        }
    }

    fun setData(task: List<Task>) {
        this.taskList = task
        notifyDataSetChanged()
    }
}