package com.dsorcelli.testmvvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.dsorcelli.testmvvc.models.Book
import com.dsorcelli.testmvvc.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainActivityViewModel by lazy {
        ViewModelProviders.of(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel.getBooks().observe(this, Observer<List<Book>> {
            Log.d("Main","Books data changed")
        })

    }
}
