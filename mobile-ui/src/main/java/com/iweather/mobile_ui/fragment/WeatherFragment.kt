package com.iweather.mobile_ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iweather.mobile_ui.databinding.FragmentWeatherBinding
import com.iweather.presentation.viewModel.WeatherViewModel
import com.iweather.presentation.viewModel.WeatherViewModelFactory
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
        val searchText by viewModel.searchText.collectAsState()

        TextField(
            value = searchText,
            onValueChange = {
                viewModel.searchCity(it)
            }
        )
    }
}