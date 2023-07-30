package com.example.restauranttourcompose.ui.review

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.restauranttourcompose.R
import com.example.restauranttourcompose.model.UserReview
import com.example.restauranttourcompose.ui.common.StarShape

@Composable
fun UserReviewSection(
    reviewList: List<UserReview>,
    onUserReviewTap: (UserReview) -> Unit
) {
    LazyColumn {
        reviewList.forEach { it ->
            item {
                UserReviewItem(
                    userReview = it,
                    onUserReviewTap = onUserReviewTap
                )
            }
        }
    }
}

@Composable
fun UserReviewItem(
    userReview: UserReview,
    onUserReviewTap: (UserReview) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row {
            repeat(userReview.ratings) {
                Box(
                  modifier = Modifier
                      .clip(StarShape(5))
                      .size(16.dp)
                      .background(Color.Yellow)
                      .align(Alignment.Bottom)
                      .padding(start = 12.dp, bottom = 4.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        UserProfileSection(
            userName = "User Name",
            userProfilePicture = ""
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = userReview.comment)
    }
}

@Composable
fun UserProfileSection(
    userName: String,
    userProfilePicture: String
) {
    Row {
        UserProfilePictureItem(userProfilePicture)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = userName,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun UserProfilePictureItem(picture: String) {
    Image(
        painter = painterResource(R.drawable.rinze),
        contentDescription = null,
        modifier = Modifier
            .clip(CircleShape)
            .size(32.dp)
    )
}

@Preview
@Composable
fun UserReviewPreview() {
    val userReview = UserReview(
        userName = "User Name",
        userProfilePicture = "",
        ratings = 4,
        comment = "Review text goes here. Review text goes here. Review text goes here. Review text goes here. Review text goes here. "
    )
    UserReviewItem(userReview = userReview, onUserReviewTap = {})
}