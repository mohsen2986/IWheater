package com.iweather.mobile_ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.ViewModelProvider
import com.iweather.presentation.viewModel.weather.WeatherViewModel
import com.iweather.presentation.viewModel.weather.WeatherViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class WeatherFragment : Fragment() , KodeinAware{
    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: WeatherViewModelFactory by instance()

    private lateinit var viewModel: WeatherViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = applyCompose()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this , viewModelFactory).get(WeatherViewModel::class.java)
//        viewModel.showWeather("")
//        viewModel.viewState.observe(viewLifecycleOwner, Observer { state ->
//
//            if (state.error != null) {
//                // TODO: Enable reload here
////                Snackbar.make(binding.root, R.string.something_went_wrong, Snackbar.LENGTH_SHORT)
////                    .show()
//            } else if (state.data != null) {
//                Toast.makeText(context , "${state.data}" , Toast.LENGTH_SHORT).show()
////                binding.tvCityName.text = state?.data?.tempData?.degrees.toString()
//            }
//        })
    }
    private fun applyCompose() =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WeatherScreen(viewModel)
            }
        }


}


@Composable
fun WeatherScreen(viewModel: WeatherViewModel){
    Box {
    }
}