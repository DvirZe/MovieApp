package com.androidAcademy.movieApp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.androidAcademy.movieApp.fragments.DetailsFragment

class SimplePagerAdapter(manager: FragmentManager, val fragments: List<DetailsFragment>)
            : FragmentPagerAdapter(manager) {

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size
}