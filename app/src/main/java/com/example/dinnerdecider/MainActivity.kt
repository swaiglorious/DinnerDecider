package com.example.dinnerdecider

import android.content.SharedPreferences
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dinnerdecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var opt: SharedPreferences
    lateinit var edittor:SharedPreferences.Editor

    var choice: Int = 0
    var newchoice: Int = 0
    lateinit var food: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        opt = applicationContext.getSharedPreferences("lastchoice", MODE_PRIVATE)
        edittor = opt.edit()

        binding.button.setOnClickListener {
            choice= Random.nextInt(0, 5)
            when (choice) {
                0 -> {
                    //option when 0
                    food = "Chips"
                    binding.backgroud.setBackgroundColor(Color.BLUE)
                    binding.backgroud.setBackgroundResource(R.drawable.chips)
                }
                1 -> {
                    food = "Rice"
                    binding.backgroud.setBackgroundColor(Color.GREEN)
                    binding.backgroud.setBackgroundResource(R.drawable.rice)
                }
                2 -> {food = "Chicken"
                binding.backgroud.setBackgroundColor(Color.CYAN)
                    binding.backgroud.setBackgroundResource(R.drawable.chicken)}
                3 ->{ food = "Matoke"
                    binding.backgroud.setBackgroundColor(Color.MAGENTA)
                    binding.backgroud.setBackgroundResource(R.drawable.matoke)}

                4 -> {food = "Chapati"
                    binding.backgroud.setBackgroundColor(Color.LTGRAY)
                    binding.backgroud.setBackgroundResource(R.drawable.chapati)}
                5 -> {food = "Pilau"
                    binding.backgroud.setBackgroundColor(Color.TRANSPARENT)
                    binding.backgroud.setBackgroundResource(R.drawable.pilau)}

                

                else -> food = "We could not decide"

            }
            binding.textView.text = food


        }


    }

    override fun onStart() {
        super.onStart()
        retrieveData()
    }

    override fun onStop() {
        super.onStop()
        saveData()
    }

    override fun onPause() {
        super.onPause()
    }
    fun saveData(){
       edittor.putInt("lastchoice", choice)
       edittor.commit()
    }
    fun retrieveData(){
      newchoice = opt.getInt("lastchoice", 0)
        when (newchoice) {
            0 -> {
                //option when 0
                food = "Chips"
                binding.backgroud.setBackgroundColor(Color.BLUE)
                binding.backgroud.setBackgroundResource(R.drawable.chips)
            }
            1 -> {
                food = "Rice"
                binding.backgroud.setBackgroundColor(Color.GREEN)
                binding.backgroud.setBackgroundResource(R.drawable.rice)
            }
            2 -> {food = "Chicken"
                binding.backgroud.setBackgroundColor(Color.CYAN)
                binding.backgroud.setBackgroundResource(R.drawable.chicken)}
            3 ->{ food = "Matoke"
                binding.backgroud.setBackgroundColor(Color.MAGENTA)
                binding.backgroud.setBackgroundResource(R.drawable.matoke)}

            4 -> {food = "Chapati"
                binding.backgroud.setBackgroundColor(Color.LTGRAY)
                binding.backgroud.setBackgroundResource(R.drawable.chapati)}
            5 -> {food = "Pilau"
                binding.backgroud.setBackgroundColor(Color.TRANSPARENT)
                binding.backgroud.setBackgroundResource(R.drawable.pilau)}



            else -> food = "We could not decide"

        }
        binding.textView.text = food

    }
}