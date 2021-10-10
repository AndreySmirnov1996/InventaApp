package ru.rubberteam.inventa.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.rubberteam.inventa.activities.login.LoginConstants
import ru.rubberteam.inventa.adapters.ItemsAdapter
import ru.rubberteam.inventa.databinding.ActivityItemsBinding
import ru.rubberteam.inventa.domain.item.Item

class ItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityItemsBinding

    lateinit var itemsAdapter: ItemsAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerItemList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerItemList.layoutManager = layoutManager

        val extras = intent.extras
        if (extras != null) {
            val itemsList = extras.getSerializable(LoginConstants.ITEMS_KEY) as (ArrayList<Item>)

            itemsAdapter =
                ItemsAdapter(baseContext, itemsList) //need to consume specific items here

            itemsAdapter.notifyDataSetChanged()
            binding.recyclerItemList.adapter = itemsAdapter

        }

    }
}