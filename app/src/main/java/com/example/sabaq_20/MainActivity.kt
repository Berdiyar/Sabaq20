package com.example.sabaq_20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myadapter: Adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycV.adapter = myadapter
        recycV.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        setData()

    }

    private fun setData(){
        val models: MutableList<ListItem> = mutableListOf()
        for (i in 0 until 20){
            if(i%5==0){
                val reklama = Ads(1,"","","")
                models.add(reklama)
            }
            else{
                val post = Post(2,"","")
                models.add(post)
            }
        }
        myadapter.models = models
    }

}
