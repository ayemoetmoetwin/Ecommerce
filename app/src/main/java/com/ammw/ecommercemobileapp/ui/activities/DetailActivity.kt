package com.ammw.ecommercemobileapp.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.ammw.ecommercemobileapp.databinding.ActivityDetailBinding
import com.ammw.ecommercemobileapp.domain.model.ProductModel
import com.ammw.ecommercemobileapp.ui.adapter.ColorAdapter
import com.ammw.ecommercemobileapp.ui.adapter.SizeAdapter
import com.ammw.ecommercemobileapp.ui.viewmodel.DetailUiState
import com.ammw.ecommercemobileapp.ui.viewmodel.DetailViewModel
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var mColorAdapter: ColorAdapter
    private lateinit var mSizeAdapter: SizeAdapter
    private val detailViewModel: DetailViewModel by viewModel()
    private var isDescClick = true
    private var isFreeClick = true

    companion object {
        private var popularName :String? = null
        fun newIntent(context: Context, name :String): Intent {
            popularName = name
            return Intent(context, DetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
    }

    private fun initLayout() {
        setUpAdapter()
        firebaseApiCall()
    }

    private fun firebaseApiCall() {
        detailViewModel.liveData.observe(this) {
            Log.d("observerState", it.toString())
            when (it) {
                DetailUiState.Loading -> {
                    binding?.loading?.visibility = View.VISIBLE
                }

                is DetailUiState.SuccessProduct -> {
                    binding?.loading?.visibility = View.GONE
                    it.productData.map {
                        if (it.name == popularName) {
                            loadData(it)
                        }
                    }
                }

                is DetailUiState.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setUpAdapter() {
        mColorAdapter = ColorAdapter(onClickItem = {
            mColorAdapter.mPosition = it
            mColorAdapter.notifyDataSetChanged()
        })
        mSizeAdapter = SizeAdapter(
            onClickItem = {
                mSizeAdapter.mPosition = it
                mSizeAdapter.notifyDataSetChanged()
            }
        )
        binding.rvColor.apply {
            adapter = mColorAdapter
            layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL,false)
        }
        binding.rvSize.apply {
            adapter = mSizeAdapter
            layoutManager = LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun loadData(popularItemData: ProductModel) {
        binding.apply {
            popularItemData?.let {item ->
                if (item != null) {
                    if (item.sizes?.size!! > 0) {
                        item.sizes?.mapIndexed() {index, item->
                            mSizeAdapter.mPosition = index
                        }
                    }
                    if (item.color?.size!! > 0) {
                        item.color?.mapIndexed() {index, item->
                            mColorAdapter.mPosition = index
                        }
                    }
                }
                item.sizes?.let { mSizeAdapter.updateList(it) }
                item.color?.let { mColorAdapter.updateList(it) }

                tvName.text = item.name
                tvRating.text = item.rating
                tvType.text = item.categoryName
                tvPrice.text = item.price

                tvDescriptionText.text = item.description
                tvFreeDeliveryText.text = item.free_delivery_return
                Glide.with(this@DetailActivity).load(item.iconUrl?.first()).into(ivDetailImage)

                ivBack.setOnClickListener {
                    onBackPressed()
                }

                ivDescriptionDown.setOnClickListener {
                    if (isDescClick) {
                        tvDescriptionText.visibility = View.VISIBLE
                        isDescClick = false
                    } else {
                        tvDescriptionText.visibility = View.GONE
                        isDescClick = true
                    }
                }

                ivFreeDeliveryDown.setOnClickListener {
                    if (isFreeClick) {
                        tvFreeDeliveryText.visibility = View.VISIBLE
                        isFreeClick = false
                    } else {
                        tvFreeDeliveryText.visibility = View.GONE
                        isFreeClick = true
                    }
                }

            }
        }
    }
}