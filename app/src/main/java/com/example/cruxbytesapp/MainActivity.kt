package com.example.cruxbytesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.slider_item.*
import me.kaelaela.verticalviewpager.transforms.DefaultTransformer

class MainActivity : AppCompatActivity() {

    var listCompanyData: ArrayList<CompanyData> = ArrayList<CompanyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listCompanyData.add(CompanyData(R.drawable.infosys, "Infosys", "Pune, Maharashtra", 2021, "Mumbai"))
        listCompanyData.add(CompanyData(R.drawable.zomato, "Zomato", "Delhi, Delhi", 2021, "Mumbai"))
        listCompanyData.add(CompanyData(R.drawable.reliance, "Reliance", "Bangalore, Karnataka", 2021, "Mumbai"))
        listCompanyData.add(CompanyData(R.drawable.bajajlogo, "Bajaj", "Aurangabad, Maharashtra", 2021, "Mumbai"))

        var sliderAdapter:SliderAdapter = SliderAdapter(this, listCompanyData)
        vertical_viewPager.adapter = sliderAdapter
        vertical_viewPager.setPageTransformer(false, DefaultTransformer())


}
}