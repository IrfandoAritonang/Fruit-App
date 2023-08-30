package com.example.fruitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitapp.databinding.ActivityDetailBinding
import com.example.fruitapp.model.Fruit

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val DATA_FOOD = "data_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Fruit>(DATA_FOOD)

        if (data != null) {
            binding.imgFood.setImageResource(data.photo)
            binding.textTitle.text = data.title
            binding.textDescription.text = data.description

        }

        supportActionBar?.title = data?.title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}