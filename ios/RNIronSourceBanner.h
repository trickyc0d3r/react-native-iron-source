//
//  RNIronSourceBanner.h
//  RNIronSource
//
//  Created by Kazlouski Dmitriy on 2/21/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <React/RCTComponent.h>
#import <React/RCTBridgeModule.h>

#import "IronSource/IronSource.h"
#import "IronSource/ISBannerDelegate.h"

@interface RNIronSourceBanner : UIView <ISBannerDelegate>

@property BOOL initialized;
@property ISBannerView  *bannerView;
@property UIViewController  *bannerViewController;
@property (nonatomic, copy) NSString *size;
@property (nonatomic, copy) RCTBubblingEventBlock onBannerEvent;

@end
