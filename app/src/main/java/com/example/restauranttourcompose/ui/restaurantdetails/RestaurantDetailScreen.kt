package com.example.restauranttourcompose.ui.restaurantdetails

import RestaurantDetailAppBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restauranttourcompose.R
import com.example.restauranttourcompose.model.Address
import com.example.restauranttourcompose.model.UserReview
import com.example.restauranttourcompose.ui.common.StarShape
import com.example.restauranttourcompose.ui.review.UserReviewItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreen(
    onNavBack: () -> Unit,
    onReviewTap: (UserReview) -> Unit
) {
    Scaffold(
        topBar = {
            RestaurantDetailAppBar(onNavBack)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            item {
                Image(
                    painter = painterResource(R.drawable.restaurant),
                    contentDescription = null,
                    modifier = Modifier
                        .height(361.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.FillHeight
                )
            }

            val contentPadding =
                Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 0.dp)
            item {
                Column(
                    modifier = Modifier.then(contentPadding)
                )
                {
                    RestaurantTypeAndStatus(
                        restaurantType = "Italic",
                        isOpenNow = true
                    )
                    DividerItem(modifier = Modifier.padding(vertical = 18.dp))
                    RestaurantAddress(
                        address = Address(
                            firstLine = "102 Lakeside Ave",
                            secondLine = "Seattle, WA 98122"
                        )
                    )
                    DividerItem(modifier = Modifier.padding(vertical = 18.dp))
                    RestaurantRating(
                        4.5
                    )
                    DividerItem(modifier = Modifier.padding(vertical = 18.dp))
                }
            }

            getMockUserReviews().forEach { it ->
                item {
                    UserReviewItem(
                        userReview = it,
                        onUserReviewTap = onReviewTap,
                        modifier = Modifier.then(contentPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun RestaurantTypeAndStatus(
    restaurantType: String,
    isOpenNow: Boolean,
) {
    Row {
        Text(
            modifier = Modifier.weight(1f),
            text = restaurantType
        )

        if (isOpenNow) {
            Text(
                text = stringResource(R.string.open_now),
                fontStyle = FontStyle.Italic
            )
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(15.dp)
                    .clip(CircleShape)
                    .background(Color.Green)
                    .align(Alignment.CenterVertically)
            )
        } else {
            Text(
                text = stringResource(R.string.close_now),
                fontStyle = FontStyle.Italic
            )
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(15.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun RestaurantAddress(
    address: Address,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = stringResource(R.string.address))
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = address.firstLine,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = address.secondLine,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun RestaurantRating(
    rating: Double,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = stringResource(R.string.address))
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Text(
                text = rating.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Box(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 4.dp)
                    .size(18.dp)
                    .clip(StarShape(5))
                    .background(Color.Yellow)
                    .align(Alignment.Bottom)
            )
        }
    }
}

@Composable
fun DividerItem(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
    )
}

fun getMockUserReviews(): List<UserReview> {
    return (0..20).map {
        UserReview(
            userName = "User Name",
            userProfilePicture = "",
            ratings = (1..5).random(),
            comment = "Review text goes here. Review text goes here. Review text goes here. Review text goes here. Review text goes here. "
        )
    }
}
