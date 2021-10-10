package ru.rubberteam.inventa.adapters

import ru.rubberteam.inventa.domain.item.Item
import ru.rubberteam.inventa.domain.task.Task
import java.io.Serializable

class TaskProcessing(tasks: MutableList<Task>) : Serializable {
    lateinit var allAddresses: List<String>
    lateinit var uniqueTownAndAddress: List<String>
    lateinit var mapUniqueTownAddressAndItems: Map<String, ArrayList<Item>>

    lateinit var itemsGroupByAddress: Map<String?, List<Item>?>

    init {
        processTasksList(tasks)
    }

    private fun processTasksList(tasks: MutableList<Task>) {
        val allItems = tasks.flatMap { task -> task.items }
        allAddresses = allItems.map { item -> item.itemLocation }

        uniqueTownAndAddress = allAddresses.map {
            it.substringBeforeLast(',')
        }.toSet().toList()

        mapUniqueTownAddressAndItems = HashMap()

        allItems.map {
            val itemLocationSub = it.itemLocation.substringBeforeLast(',')

            if (mapUniqueTownAddressAndItems.containsKey(itemLocationSub)) {
                val items = mapUniqueTownAddressAndItems[itemLocationSub]
                items?.add(it)
            } else {
                val items = ArrayList<Item>()
                items.add(it)
                mapUniqueTownAddressAndItems =
                    mapUniqueTownAddressAndItems + (itemLocationSub to items)
            }
        }

        mapUniqueTownAddressAndItems.map { it.value = it.value.groupBy{it.itemLocation}}

        itemsGroupByAddress = allItems.groupBy { it.itemLocation }
    }

}