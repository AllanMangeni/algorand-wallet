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

package com.algorand.android.discover.utils

import com.algorand.android.BuildConfig
import com.algorand.android.discover.common.ui.model.WebViewTheme
import com.algorand.android.utils.UrlBuilder

class DiscoverUrlBuilder private constructor(customBaseUrl: String? = null) : UrlBuilder() {

    override val baseUrl: StringBuilder =
        StringBuilder(customBaseUrl ?: BuildConfig.DISCOVER_URL).append(QUERY_SYMBOL)

    fun addTheme(themePreference: WebViewTheme): DiscoverUrlBuilder {
        addQuery(Query.THEME, themePreference.key)
        return this
    }

    fun addVersion(version: String): DiscoverUrlBuilder {
        addQuery(Query.VERSION, version)
        return this
    }

    fun addPlatform(): DiscoverUrlBuilder {
        addQuery(Query.PLATFORM, PLATFORM_NAME)
        return this
    }

    fun addCurrency(currency: String): DiscoverUrlBuilder {
        addQuery(Query.CURRENCY, currency)
        return this
    }

    fun addLocale(locale: String): DiscoverUrlBuilder {
        addQuery(Query.LOCALE, locale)
        return this
    }

    fun addTokenDetail(tokenId: String, poolId: String?): DiscoverUrlBuilder {
        addUrlSlug(UrlSlug.TOKEN_DETAIL, tokenId)
        poolId?.let {
            addQuery(Query.POOL_ID, it)
        }
        return this
    }

    companion object {
        const val PLATFORM_NAME = "android"
        fun create(customBaseUrl: String? = null): DiscoverUrlBuilder {
            return DiscoverUrlBuilder(customBaseUrl)
        }
    }
}
