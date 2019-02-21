//
//  RNIronSourceBannerManager.h
//  RNIronSource
//
//  Created by Kazlouski Dmitriy on 2/21/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#if __has_include(<React/RCTViewManager.h>)
#import <React/RCTViewManager.h>
#else
#import "RCTViewManager.h"
#endif
#import "IronSource/IronSource.h"
#import "RNIronSourceBanner.h"

@interface RNIronSourceBannerManager : RCTViewManager

@end
