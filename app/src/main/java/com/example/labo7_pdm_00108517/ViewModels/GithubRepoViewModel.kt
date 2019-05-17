package com.example.labo7_pdm_00108517.ViewModels

import android.app.Application
import android.view.KeyEvent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7_pdm_00108517.Database.GithubRepo
import com.example.labo7_pdm_00108517.Database.RoomDB
import com.example.labo7_pdm_00108517.Repository.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app : Application)  : AndroidViewModel(app){
    private val repository : GithubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDao)
    }
    fun insert(repo : GithubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)

    }

    fun getAll() : LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll()  =repository.nuke()
}