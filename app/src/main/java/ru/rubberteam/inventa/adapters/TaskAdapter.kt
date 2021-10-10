package ru.rubberteam.inventa.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.rubberteam.inventa.R
import ru.rubberteam.inventa.activities.ItemsActivity
import ru.rubberteam.inventa.activities.login.LoginConstants.ITEMS_KEY
import ru.rubberteam.inventa.databinding.TaskCardBinding


class TaskAdapter(
    private val context: Context,
    private val taskProcessing: TaskProcessing
) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: TaskCardBinding = TaskCardBinding.bind(itemView)

        val streetTitle: TextView = binding.street

        fun bind(position: Int, taskProcessing: TaskProcessing) {
            itemView.setOnClickListener {
                val address = taskProcessing.uniqueTownAndAddress[position]
                val intent = Intent(it.context, ItemsActivity::class.java)

                intent.putExtra(ITEMS_KEY, taskProcessing.mapUniqueTownAddressAndItems[address])
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.task_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, taskProcessing)
        holder.streetTitle.text = taskProcessing.uniqueTownAndAddress[position]
    }

    override fun getItemCount() = taskProcessing.uniqueTownAndAddress.size

}