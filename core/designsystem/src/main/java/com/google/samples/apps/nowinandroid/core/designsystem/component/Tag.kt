/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.google.samples.apps.nowinandroid.core.designsystem.R

@Composable
fun NiaTopicTag(
    followed: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {

    Box(modifier = modifier) {
        val containerColor = if (followed) {
            MaterialTheme.colorScheme.primaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceVariant
        }
        NiaTextButton(
            onClick = onClick,
            enabled = enabled,
            small = true,
            colors = NiaButtonDefaults.textButtonColors(
                containerColor = containerColor,
                contentColor = contentColorFor(backgroundColor = containerColor),
                disabledContainerColor = if (followed) {
                    MaterialTheme.colorScheme.onBackground.copy(
                        alpha = NiaButtonDefaults.DisabledButtonContentAlpha
                    )
                } else {
                    Color.Transparent
                }
            ),
            text = text
        )
    }
}

private const val FOLLOW = 1
private const val UNFOLLOW = 2
private const val BROWSE = 3
