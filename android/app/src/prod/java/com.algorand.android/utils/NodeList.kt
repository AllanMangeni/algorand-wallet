package com.algorand.android.utils

import com.algorand.android.BuildConfig
import com.algorand.android.models.Node

const val CURRENT_DEFAULT_NODE_LIST_VERSION = 14

val defaultNodeList = listOf(
    Node(
        name = "MainNet",
        algodAddress = "http://localhost:4001",
        algodApiKey = BuildConfig.ALGORAND_API_KEY,
        indexerAddress = "http://localhost:8980",
        indexerApiKey = BuildConfig.INDEXER_API_KEY,
        isActive = true,
        isAddedDefault = true,
        networkSlug = MAINNET_NETWORK_SLUG
    ),
    Node(
        name = "TestNet",
        algodAddress = "http://localhost:4001",
        algodApiKey = BuildConfig.ALGORAND_API_KEY,
        indexerAddress = "http://localhost:8980",
        indexerApiKey = BuildConfig.INDEXER_API_KEY,
        isActive = false,
        isAddedDefault = true,
        networkSlug = TESTNET_NETWORK_SLUG
    )
)
