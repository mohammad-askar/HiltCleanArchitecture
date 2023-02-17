package com.example.hlitwithcleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.hlitwithcleanarchitecture.app.ApplicationWithAppContainer
import com.example.hlitwithcleanarchitecture.data.local.ProductDataBase
import com.example.hlitwithcleanarchitecture.data.remote.ProductApi
import com.example.hlitwithcleanarchitecture.data.repository.ProductRepositoryImp
import com.example.hlitwithcleanarchitecture.domain.entity.ProductModel
import com.example.hlitwithcleanarchitecture.domain.repository.ProductRepository
import com.example.hlitwithcleanarchitecture.manual.AppContainer
import com.example.hlitwithcleanarchitecture.presentation.view_model.ProductViewModel
import com.example.hlitwithcleanarchitecture.ui.theme.HlitWithCleanArchitectureTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Retrofit
import retrofit2.create

class MainActivity : ComponentActivity() {

    private lateinit var productViewModel: ProductViewModel
    private lateinit var appContainer: AppContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        appContainer = (application as ApplicationWithAppContainer).appContainer

        productViewModel = appContainer.productViewModelFactory.create()
        setContent {
            val products by productViewModel.productFlow.collectAsState()
            HlitWithCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(state = rememberScrollState())
                            .padding(8.dp)
                    ) {
                        ShowMessage(message = "the Product Quantity is ${products.size}")
                    }
                }
            }
        }
    }
}

@Composable
fun ShowMessage(message: String) {
    Text(text = message, modifier = Modifier.padding(8.dp))
}
