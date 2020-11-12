package com.example.kotlin2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn_choice)
        btn.setOnClickListener(View.OnClickListener
        {
            startActivityForResult(Intent(this@MainActivity, MainActivity2::class.java), 1)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null) return
        if (requestCode == 1)
        {
            if (resultCode == 101)
            {

                val str1 = data.getStringExtra("drink")
                val str2 = data.getStringExtra("suger")
                val str3 = data.getStringExtra("ice")

                val tv_meal = findViewById<TextView>(R.id.tv_meal)
                tv_meal.text = "飲料:$str1\n甜度:$str2\n冰塊:$str3\n"
            }
        }
    }
}