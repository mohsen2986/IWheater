package com.iweather.mobile_ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import androidx.compose.ui.text.TextStyle
import com.iweather.presentation.viewModel.searchCity.SearchCityViewModel
import com.iweather.presentation.viewModel.searchCity.SearchCityViewModelFactory

class SearchCityFragment : Fragment(), KodeinAware {
    override val kodein: Kodein by closestKodein()

    private val viewModelFactory: SearchCityViewModelFactory by instance()

    private lateinit var viewModel: SearchCityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = applyCompose()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[SearchCityViewModel::class.java]
    }

    private fun applyCompose() =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                SearchCityScreen(viewModel)
            }
        }

}

@Composable
fun SearchCityScreen(viewModel: SearchCityViewModel) {
    val searchText by viewModel.searchText.collectAsState()
    val uiState by viewModel.searchResult.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2E3358),
                        Color(0xFF1C1B33),
                    )
                ))
            .shadow(ambientColor = Color(0xB23B267B), clip = false, elevation = 1.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 44.dp , top = 9.dp , bottom = 9.dp),
            text = "Weather",
            color = Color.White,
            fontSize = 28.sp
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(15.dp))


            ,
            value = searchText,
            onValueChange = {
                viewModel.searchCity(it)
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = "Search for a city or airport",
                    color = Color(0x99EBEBF5)
                )
            },
            textStyle =  TextStyle(color = Color.White, fontSize = 16.sp),
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.disabled),
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = Color(0x99EBEBF5)
                    )
                }
            },
        )

        LazyColumn(
            modifier = Modifier.padding(horizontal = 25.dp)
        ){
            items(
                items = uiState.data
            ){ item ->
                Box {
                    SearchItem(city = item.name , state = item.state, country = item.country)
                }
            }
        }
    }
}

@Composable
fun SearchItem(city: String, country: String , state: String){
    Box(
        modifier = Modifier.fillMaxWidth().height(69.dp).padding(10.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.TopStart) ,
            text = city ,
            fontSize = 16.sp ,
            color = Color.White
        )
        Text(
            modifier = Modifier.align(Alignment.BottomStart),
            text = "$country $state" ,
            fontSize = 14.sp ,
            color = Color(0x99EBEBF5)
        )
        Icon(
            modifier = Modifier.align(Alignment.CenterEnd),
            imageVector = Icons.Filled.Add,
            tint = Color.White,
            contentDescription = "Add city"
        )
    }
}
