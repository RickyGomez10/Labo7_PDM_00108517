package com.example.labo7_pdm_00108517

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.labo7_pdm_00108517.Database.GithubRepo
import com.example.labo7_pdm_00108517.ViewModels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel=ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)

        btn_Add.setOnClickListener{
            val name = et_add.text.toString()
            if(name.isNotEmpty() && name.isNotBlank()){
                viewModel.insert(GithubRepo(name))
            }
        }
        viewModel.getAll().observe(this, Observer { repos ->
            Log.d("Lista de repos", "____________________________")
            for(repo in repos){
                Log.d("Lista de repos", repo.name)

            }

        })
    }
}
