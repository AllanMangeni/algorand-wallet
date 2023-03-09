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

package com.algorand.android.modules.webimport.result.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.algorand.android.R
import com.algorand.android.databinding.ItemAccountBinding
import com.algorand.android.models.AccountIconResource
import com.algorand.android.models.BaseViewHolder
import com.algorand.android.modules.webimport.result.ui.model.BaseAccountResultListItem
import com.algorand.android.utils.AccountIconDrawable

class WebImportResultAccountItemViewHolder(
    private val binding: ItemAccountBinding
) : BaseViewHolder<BaseAccountResultListItem>(binding.root) {

    private fun setAccountStartIconDrawable(accountIconResource: AccountIconResource?) {
        with(binding.accountItemView) {
            val accountIconSize = resources.getDimension(R.dimen.account_icon_size_large).toInt()
            val accountIconDrawable = AccountIconDrawable.create(
                context = context,
                accountIconResource = accountIconResource
                    ?: AccountIconResource.DEFAULT_ACCOUNT_ICON_RESOURCE,
                size = accountIconSize
            )
            setStartIconDrawable(accountIconDrawable)
        }
    }

    private fun setAccountTitleText(accountTitleText: String?) {
        binding.accountItemView.setTitleText(accountTitleText)
    }

    private fun setAccountDescriptionText(accountDescriptionText: String?) {
        binding.accountItemView.setDescriptionText(accountDescriptionText)
    }

    override fun bind(item: BaseAccountResultListItem) {
        if (item !is BaseAccountResultListItem.AccountItem) return
        with(item.accountAssetIconNameConfiguration) {
            setAccountStartIconDrawable(startAccountIconResource)
            setAccountTitleText(title)
            setAccountDescriptionText(description)
        }
    }

    companion object {
        fun create(parent: ViewGroup): WebImportResultAccountItemViewHolder {
            val binding = ItemAccountBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return WebImportResultAccountItemViewHolder(binding)
        }
    }
}
