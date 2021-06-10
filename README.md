# The Official Algorand Wallet #
### Overview: ###
Welcome to the code that powers the official Algorand Wallet! This repo will always contain the source code for the latest publicly available Algorand Wallet version (official download links can be found at www.algorandwallet.com). The Algorand Wallet is built by the same team that built (and maintains) the Algorand Blockchain. As with any product that we build, we want to make sure that we focus not only on great features and experiences but also security, transparency, and community involvement.

Other than version numbers changing, news and other important release information (like release notes) will not be posted here. To stay up to date on the latest news, features, release notes, tutorials, and more, please check out www.algorandwallet.com  

### Contributing: ###
While the Algorand community is always welcome to contribute, please note that new feature development happens outside of this repo which means that open issues/PRs might not see a lot of activity. We do this in order to make sure that all code that is pushed here has passed our rigorous QA testing and high security standards. That being said, we’ll do our best to take note of feature requests or additions - some of which we might potentially incorporate into our codebase via our main development pipeline. 

If you simply need help, want to report a bug, or want to suggest a feature, the best place to do so is via www.algorandwallet.com/support. We try to monitor all of the different mechanisms for leaving Algorand Wallet feedback (such as Twitter, Discord, forums, etc.), but please know that the aforementioned link is by far the fastest way to get in touch with us. 
### Deployment ###
In order to build and run the app from source, you will need to provide the following:
- Firebase config file: Because the app uses Firebase, you will need to provide a Firebase config file for it to use. See this link for instructions on how to download and set up this config file: https://support.google.com/firebase/answer/7015592
- Algod and Indexer API access: The app needs access to instances of Algod and Indexer for both TestNet and MainNet in order to function. See this link for information on how to obtain an address and access token for Algod: https://developer.algorand.org/docs/build-apps/setup/#how-do-i-obtain-an-algod-address-and-token. Once you have addresses and tokens for both Algod and Indexer, they must be placed in these locations:
  - Access tokens/API keys: For iOS, access tokens must be replaced in the `*.plist` files in the `ios/Support/` directory. For Android, the `android/app/build.gradle` file loads these access tokens from the files `android/app/src/staging/api-key.properties` and `android/app/src/prod/api-key.properties`. You can either create these files, or modify the `build.gradle` file to hardcode your access tokens.
  - Addresses: For iOS, Algod and Indexer addresses must be updated in the `ios/Classes/Core/Environment/Environment.swift` file. For Android, these addresses must be updated in the `android/app/src/staging/java/com/algorand/android/utils/NodeList.kt` and `android/app/src/prod/java/com.algorand.android/utils/NodeList.kt` files.

If you’re mostly interested in the Android APK, we will be hosting the latest versions on www.algorandwallet.com (starting with version 4.9.1 and on).
