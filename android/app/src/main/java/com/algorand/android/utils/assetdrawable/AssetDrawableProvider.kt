/*
 * Copyright 2022 Pera Wallet, LDA
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.algorand.android.utils.assetdrawable

import android.content.Context
import android.graphics.drawable.Drawable
import com.algorand.android.utils.AssetName
import com.algorand.android.utils.createPrismUrl
import com.algorand.android.utils.loadImage
import kotlinx.parcelize.Parcelize

@Parcelize
class AssetDrawableProvider : BaseAssetDrawableProvider() {

    override fun getAssetDrawable(
        context: Context,
        assetName: AssetName,
        logoUri: String?,
        width: Int,
        onResourceReady: (Drawable?) -> Unit
    ) {
        onResourceReady(createAssetShortNameDrawable(context, assetName))
        if (!logoUri.isNullOrBlank()) {
            context.loadImage(
                uri = createPrismUrl(url = logoUri, width = width),
                onResourceReady = { onResourceReady(it) },
                onLoadFailed = { onResourceReady(createAssetShortNameDrawable(context, assetName)) }
            )
        }
    }

    private fun createAssetShortNameDrawable(context: Context, assetName: AssetName): Drawable {
        return ShortAssetNameDrawable(assetName.getAsAvatarNameOrDefault(context.resources)).toDrawable(context)
    }
}