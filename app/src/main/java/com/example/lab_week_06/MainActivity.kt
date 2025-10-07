package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Glide is used here to load the images
        // Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object :
            CatAdapter.OnClickListener {
            // When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        // Setup the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        // ⬇️ Tambahkan kode ini untuk mengaktifkan swipe-to-delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.SwipeToDeleteCallback())
        itemTouchHelper.attachToRecyclerView(recyclerView)
        // ⬆️ Tambahkan di sini, sebelum catAdapter.setData()

        // Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengal,
                    "Tiger",
                    "Energetic and playful",
                    "https://cdn2.thecatapi.com/images/1f9.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Birman,
                    "Luna",
                    "Graceful and calm",
                    "https://cdn2.thecatapi.com/images/9j4.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.MaineCoon,
                    "Shadow",
                    "Big and fluffy protector",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Persian,
                    "Misty",
                    "Loves naps and grooming",
                    "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Sphynx,
                    "Baldy",
                    "Charming and unique",
                    "https://cdn2.thecatapi.com/images/BDb8ZXb1v.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Siamese,
                    "Cleo",
                    "Talkative and affectionate",
                    "https://cdn2.thecatapi.com/images/ai6.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ScottishFold,
                    "Ollie",
                    "Curious and friendly",
                    "https://cdn2.thecatapi.com/images/MTc5MjU1Mw.jpg"
                )
            )
        )
    }

    // This will create a pop up dialog when one of the items from the recycler view is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
