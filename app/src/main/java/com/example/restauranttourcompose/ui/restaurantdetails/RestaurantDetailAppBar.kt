import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.restauranttourcompose.R
import com.example.restauranttourcompose.ui.common.RestaurantTourAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailAppBar(
    onNavBack: () -> Unit
) {
    RestaurantTourAppBar(
        titleText = stringResource(R.string.restaurant_name),
        navigationIcon = {
            IconButton(onClick = onNavBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}
