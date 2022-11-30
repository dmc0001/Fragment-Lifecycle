package com.example.frag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {

    private val firstFragment = FragmentOne()
    private val secondFragment = FragmentTwo()
    private val thirdFragment = FragmentThird()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initSubView()
        //initButton()
        addNavListener()
    }

    private fun addNavListener(){
        button_nav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.pageHome ->{
                    replaceFrag(firstFragment)
                    true
                }
            R.id.pageFavorite ->{
                replaceFrag(secondFragment)
                true
            }
                R.id.pageSettings ->{
                    replaceFrag(thirdFragment)
                    true
                }

                else -> false
            }

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