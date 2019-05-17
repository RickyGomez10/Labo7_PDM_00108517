package com.example.labo7_pdm_00108517.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7_pdm_00108517.Database.GithubDAO
import com.example.labo7_pdm_00108517.Database.GithubRepo

class GithubRepoRepository(private val repoDao: GithubDAO) {

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll(): LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke() = repoDao.nukeTable()
}