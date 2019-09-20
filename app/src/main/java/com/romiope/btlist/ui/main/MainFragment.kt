package com.romiope.btlist.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.romiope.btlist.R
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        list.apply {
            layoutManager = LinearLayoutManager(context)

            adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

                val devices = viewModel.getDevices().toList()

                override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ) = object: RecyclerView.ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.list_item, null)
                ) {}

                override fun getItemCount() = devices.size

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    holder.itemView.name.text = devices[position].name
                    holder.itemView.deviceId.text = devices[position].address
                }
            }
        }
    }
}
