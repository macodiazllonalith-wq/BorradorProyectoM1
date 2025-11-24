package com.example.nutritionalinformation.ui.viewmodel

import MenuRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.entity.MenuItem
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MenuViewModel(private val repository: MenuRepository) : ViewModel() {

    val menuItems: StateFlow<List<MenuItem>> = repository.getAll()
        .map { items -> items.sortedBy { it.name } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addItem(item: MenuItem) {
        viewModelScope.launch {
            repository.insert(item)
        }
    }

    fun updateItem(item: MenuItem) {
        viewModelScope.launch {
            repository.update(item)
        }
    }

    fun deleteItem(item: MenuItem) {
        viewModelScope.launch {
            repository.delete(item)
        }
    }
}
