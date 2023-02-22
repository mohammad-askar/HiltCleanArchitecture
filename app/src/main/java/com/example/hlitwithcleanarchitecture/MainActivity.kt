package com.example.hlitwithcleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hlitwithcleanarchitecture.presentation.view_model.PaymentViewModel
import com.example.hlitwithcleanarchitecture.presentation.view_model.ProductViewModel
import com.example.hlitwithcleanarchitecture.ui.theme.HlitWithCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ProductViewModel>()
    private val paymentViewModel by viewModels<PaymentViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val products by viewModel.productFlow.collectAsState()
            val firstPayment by paymentViewModel.paymentFirstFlow.collectAsState()
            val secondPayment by paymentViewModel.paymentSecondFlow.collectAsState()
            val notification by paymentViewModel.notifierFlow.collectAsState()
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
                        ShowMessage(message = "the Product Quantity is $products")
                        Divider()
                        ShowMessage(message = firstPayment)
                        Divider()
                        ShowMessage(message = secondPayment)
                        Divider()
                        ShowMessage(message = notification)
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
