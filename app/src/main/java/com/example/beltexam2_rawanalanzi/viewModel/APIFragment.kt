package com.example.beltexam2_rawanalanzi.viewModel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.beltexam2_rawanalanzi.databinding.FragmentAPIBinding
import com.example.beltexam2_rawanalanzi.model.data.TvShowItemItem
import com.example.beltexam2_rawanalanzi.view.APIAdapter
import java.lang.Exception


class APIFragment : Fragment() , APIAdapter.TvShowClickInterface{

    private lateinit var binding: FragmentAPIBinding
    private lateinit var rvAdapter: APIAdapter
    lateinit var apiInterface: APIInterface
    lateinit var input:String
//    private val tvShowDao by lazy { TvShowLocalDatabase.getDatabase(requireActivity() as MainActivity).tvShowDao() }
    private lateinit var tvShowList: ArrayList<TvShowItemItem>
//    var apiKey="1255cfc2cc28d37d8ac0d027a6c6c13c"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvShowList= ArrayList()
        binding=FragmentAPIBinding.inflate(layoutInflater)
        binding.apply {
            rvAdapter = APIAdapter(this@APIFragment)
            rvMain.adapter = rvAdapter
            btSearch.setOnClickListener {
                input = etSearch.text.toString()

                if (input!=null)
                { retrofit()}
                else
                {
                    Toast.makeText(requireContext(), "you cant input empty value", Toast.LENGTH_LONG).show()
                }
                etSearch.text.clear()
            }

        }
        return binding.root

    }

    private fun retrofit(){

//        CoroutineScope(Dispatchers.IO).launch {
            try{
                apiInterface = APIClint().getClint()!!.create(APIInterface::class.java)
                val response = apiInterface.getAllTvShows(input)
                Log.d("TAG", "coroutinesAndSuspend: ")
                if(response.isSuccessful){

                    tvShowList = response.body()!!
                }else{
                    Log.d("MAIN", "Unable to get data.")
                }
            }catch(e: Exception){
                Log.d("MAIN", "Exception: $e")
            }
//            withContext(Dispatchers.Main){
//                rvAdapter.update(recipes)
                rvAdapter.submitList(tvShowList)
//            }
//        }
    }

    override fun seveToLocalDB(tvShow: TvShowItemItem) {

//            CoroutineScope(Dispatchers.IO).launch {
//
//                var newTvShowRoom= TvShowItemItem(
//                    tvShow._links,tvShow.airdate,
//                    tvShow.airstamp,tvShow.airtime,
//                    tvShow.id,tvShow.image,tvShow.name,
//                    tvShow.number,tvShow.rating,tvShow.runtime,
//                    tvShow.season,tvShow.show,tvShow.summary,
//                    tvShow.type,tvShow.url
//                )
//                tvShowDao.addTvShow(newTvShowRoom)
//
//            }
//            Toast.makeText(requireContext(), "Added successfully", Toast.LENGTH_LONG).show()


    }


}