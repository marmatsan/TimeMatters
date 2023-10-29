package com.marmatsan.onboarding_ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marmatsan.core_domain.util.Empty
import com.marmatsan.core_ui.dimensions.LocalSpacing
import com.marmatsan.core_domain.R as coreDomainR
import com.marmatsan.onboarding_ui.R as onboardingUiR

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    val pagerState = rememberPagerState(
        pageCount = { 3 }
    )

    HorizontalPager(
        state = pagerState
    ) { page ->
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = onboardingUiR.drawable.image_placeholder),
                contentDescription = stringResource(id = coreDomainR.string.cd_image_page_1)
            )
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = spacing.spaceSmall),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    )
                }
            }
            Text(
                modifier = modifier,
                text = when (page) {
                    0 -> stringResource(coreDomainR.string.title_page_1)
                    1 -> stringResource(coreDomainR.string.title_page_2)
                    2 -> stringResource(coreDomainR.string.title_page_3)
                    else -> String.Empty
                },
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                modifier = modifier.padding(
                    start = spacing.spaceSmall,
                    end = spacing.spaceSmall
                ),
                text = when (page) {
                    0 -> stringResource(coreDomainR.string.description_page_1)
                    1 -> stringResource(coreDomainR.string.description_page_2)
                    2 -> stringResource(coreDomainR.string.description_page_3)
                    else -> String.Empty
                },
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}

@Preview
@Composable
fun OnBoardingScreenPreview() {
    OnboardingScreen()
}