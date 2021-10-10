package ru.rubberteam.inventa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.rubberteam.inventa.R
import ru.rubberteam.inventa.databinding.ItemCardBinding
import ru.rubberteam.inventa.domain.item.Item

class ItemsAdapter(private val context: Context,
				   private val data: ArrayList<Item>
) :
	RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		var binding: ItemCardBinding = ItemCardBinding.bind(itemView)

		val desc: TextView = binding.description
		val location: TextView = binding.location

//		fun bind(position: Int, items: MutableList<Item>) {
//			itemView.setOnClickListener {
//				items[position]
//				Toast.makeText(
//					it.context,
//					"нажал на ${items[position].itemLocation}",
//					Toast.LENGTH_SHORT
//				).show()
//				it.context.startActivity(Intent(it.context, ErrorActivity::class.java))
//			}
//		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val itemView =
			LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
		return ItemsAdapter.ViewHolder(itemView)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//		holder.bind(position, taskProcessing.allItems as MutableList<Item>)
		holder.desc.text = data[position].itemDescription
		holder.location.text = data[position].itemLocation
	}

	override fun getItemCount() = data.size


}