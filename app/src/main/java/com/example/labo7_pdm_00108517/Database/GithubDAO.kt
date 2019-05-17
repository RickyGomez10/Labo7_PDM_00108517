package com.example.labo7_pdm_00108517.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GithubDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)

    @Query("Select  * from repos")
    fun getAllRepos(): LiveData<List<GithubRepo>>

    @Query( "Delete from repos")
    fun nukeTable()
}