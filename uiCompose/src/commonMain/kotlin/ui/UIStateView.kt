package ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import app.cash.paging.LoadState
import app.cash.paging.LoadStateError
import app.cash.paging.LoadStateLoading
import app.cash.paging.LoadStateNotLoading
import androidx.compose.runtime.State
import data.ResponseError

@Composable
fun UIStateView(
    state: LoadState,
    content: @Composable (LoadState) -> Unit,
) {
    when (state) {
        is LoadStateError -> UIFailure(state)

        is LoadStateLoading -> UILoading()

        is LoadStateNotLoading -> content(state)
    }
}


@Composable
fun <T> UIStateView(
    state: State<MovieUiState<out T>>,
    content: @Composable (T) -> Unit,
) {
    when (val value = state.value) {
        is MovieUiState.Failed -> UIFailure(value.exception)

        is MovieUiState.Loading -> UILoading()

        is MovieUiState.Success -> content(value.data)
    }
}

@Composable
private fun UILoading() {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = { 0.75f },
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
private fun UIFailure(failure: LoadStateError) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = (failure.error as ResponseError).status_message,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun UIFailure(error: Throwable) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = (error as ResponseError).status_message,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center,
            )
        }
    }
}
