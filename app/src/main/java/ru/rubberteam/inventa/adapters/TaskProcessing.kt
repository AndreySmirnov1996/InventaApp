package ru.rubberteam.inventa.adapters

import ru.rubberteam.inventa.domain.item.Item
import ru.rubberteam.inventa.domain.task.Task

class TaskProcessing(tasks: MutableList<Task>) {
    lateinit var allItems: List<Item>
    lateinit var addresses: List<String>
    lateinit var splitAddresses: List<Pair<String, String>>
    lateinit var uniqueTownAndAddress: List<String>
    lateinit var itemsGroupByAddress: Map<String?, List<Item>>

    init {
        processTasksList(tasks)
    }

    private fun processTasksList(tasks: MutableList<Task>) {
        allItems = tasks.flatMap { task -> task.items }
//		allItems = tasks.stream().flatMap { task -> task.items.stream() }.collect(Collectors.toList())
        addresses = allItems.mapNotNull { item -> item.itemLocation }
        uniqueTownAndAddress = addresses.map { it.substringBeforeLast(',') }.toSet().toList()
        splitAddresses = addresses.map {
            Pair(
                it.split(',')[1],
                it.replace(" ${it.split(',')[1]},", " ", false)
            )
        }

        itemsGroupByAddress = allItems.groupBy { it.itemLocation }
    }

    fun getCategories(position: String?): Map<String?, Int> {
        return allItems.filter { it.itemLocation.equals(position) }
            .groupingBy { it -> it.itemDescription }.eachCount()
    }
}