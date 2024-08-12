package com.ammw.ecommercemobileapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ammw.ecommercemobileapp.databinding.FragmentBookmarkBinding
import com.ammw.ecommercemobileapp.domain.model.BrandModel
import com.ammw.ecommercemobileapp.domain.model.PopularItemModel
import com.ammw.ecommercemobileapp.domain.model.ProductModel
import com.ammw.ecommercemobileapp.ui.activities.DetailActivity
import com.ammw.ecommercemobileapp.ui.adapter.BrandAdapter
import com.ammw.ecommercemobileapp.ui.adapter.PopularItemAdapter
import com.ammw.ecommercemobileapp.ui.viewmodel.BookmarkUiState
import com.ammw.ecommercemobileapp.ui.viewmodel.BookmarkViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarkFragment : Fragment() {
    private var binding :FragmentBookmarkBinding? = null
    private lateinit var mBrandAdapter: BrandAdapter
    private lateinit var mPopularItemAdapter: PopularItemAdapter
    private val bookmarkViewModel: BookmarkViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkBinding.inflate(inflater ,container ,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        setUpAdapter()

        bookmarkViewModel.liveData.observe(viewLifecycleOwner) {
            Log.d("observerState", it.toString())
            when (it) {
                BookmarkUiState.Loading -> {
                    binding?.loading?.visibility = View.VISIBLE
                }

                is BookmarkUiState.SuccessProduct -> {
                    binding?.loading?.visibility = View.GONE
                    mPopularItemAdapter.updateList(it.productData)
                }

                is BookmarkUiState.SuccessCategory -> {
                    if (it.categoryData.size > 0) {
                        mBrandAdapter.mPosition = it.categoryData[0].id
                    }
                    binding?.loading?.visibility = View.GONE
                    mBrandAdapter.updateList(it.categoryData)
                }
                is BookmarkUiState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setUpAdapter() {
        mBrandAdapter = BrandAdapter(
            onClickItem = {
                mBrandAdapter.mPosition = it
                mBrandAdapter.notifyDataSetChanged()
            }
        )
        mPopularItemAdapter = PopularItemAdapter(onClickItem = {
            startActivity(DetailActivity.newIntent(requireContext(), it))
        })
        binding?.rvBrandIcon?.apply {
            adapter = mBrandAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        }
        binding?.rvPopular?.apply {
            adapter = mPopularItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}