// Copyright 2022 Pera Wallet, LDA

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//    http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

//   InfoBoxViewTheme.swift

import MacaroonUIKit
import UIKit

protocol InfoBoxViewTheme:
    StyleSheet,
    LayoutSheet {
    var contentPaddings: LayoutPaddings { get }
    var iconContentEdgeInsets: LayoutOffset { get }
    var icon: ImageStyle { get }
    var title: TextStyle { get }
    var message: TextStyle { get }
    var spacingBetweenTitleAndMessage: LayoutMetric { get }
}