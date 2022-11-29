package com.example.frag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private val firstFragment = FragmentOne()
    private val secondFragment = FragmentTwo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initSubView()
        initButton()
    }

    private fun initButton(){
      button.setOnClickListener {
          showSecondFrag()
      }
        button_two.setOnClickListener {
            removeFrag(secondFragment)
        }
    }

    private fun showSecondFrag(){
       replaceFrag(secondFragment)
    }

    private fun initSubView(){
       addFrag(firstFragment)
    }
    private fun  addFrag(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_view_tag,fragment)
        transaction.commit()

    }
    private fun  replaceFrag(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view_tag,fragment)
        transaction.commit()

    }
    private fun  removeFrag(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.remove(fragment)
        transaction.commit()

    }
}