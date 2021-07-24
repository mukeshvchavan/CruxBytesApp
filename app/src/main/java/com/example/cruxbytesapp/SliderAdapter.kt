package com.example.cruxbytesapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.slider_item.*

class SliderAdapter(var context: Context, var listCompanyData: ArrayList<CompanyData>): PagerAdapter() {

    lateinit var inflater: LayoutInflater


    override fun getCount(): Int = listCompanyData.size

    override fun isViewFromObject(view: View, obj: Any): Boolean =
        view == obj as ConstraintLayout

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view:View=inflater.inflate(R.layout.slider_item, container, false)
        var image: ImageView = view.findViewById(R.id.iv_logo)
        var tvCity:TextView = view.findViewById(R.id.tv_city)
        var tvYear:TextView = view.findViewById(R.id.tv_year)
        var tvAddress:TextView = view.findViewById(R.id.tv_address)
        var tvCompany:TextView = view.findViewById(R.id.tv_company)

        image.setBackgroundResource(listCompanyData.get(position).image)
        tvCity.setText(listCompanyData.get(position).city)
        tvYear.setText(listCompanyData.get(position).year.toString())
        tvAddress.setText(listCompanyData.get(position).address)
        tvCompany.setText(listCompanyData.get(position).companyName)


        var btn_see_profile = view.findViewById<Button>(R.id.btn_see_profile)

        btn_see_profile.setOnClickListener {
            context.startActivity(Intent(context, ProfileActivity::class.java))
        }
        container!!.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
//        container!!.removeViews(obj as ConstraintLayout)
        container!!.removeView(obj as ConstraintLayout)
    }

}