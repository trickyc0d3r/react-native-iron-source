//
//  RNIronSourceBannerManager.m
//  RNIronSource
//
//  Created by Kazlouski Dmitriy on 2/21/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RNIronSourceBannerManager.h"

@implementation RNIronSourceBannerManager

RCT_EXPORT_MODULE()

- (UIView *)view
{
    return [[RNIronSourceBanner alloc] init];
}


RCT_EXPORT_VIEW_PROPERTY(size, NSString);
RCT_EXPORT_VIEW_PROPERTY(onBannerEvent, RCTBubblingEventBlock);

@end
