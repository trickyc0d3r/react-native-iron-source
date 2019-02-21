//
//  RNIronSourceBanner.m
//  RNIronSource
//
//  Created by Kazlouski Dmitriy on 2/21/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RNIronSourceBanner.h"

NSString *const kIronSourceBannerDidLoad = @"onBannerLoad";
NSString *const kIronSourceBannerDidFailToLoadWithError = @"onError";
NSString *const kIronSourceBannerDidDismissScreen = @"onDismissScreen";
NSString *const kIronSourceBannerWillLeaveApplication = @"onLeaveApplication";
NSString *const kIronSourceBannerWillPresentScreen = @"onWillPresentScreen";
NSString *const kIronSourceDidClickBanner = @"onClick";

@implementation RNIronSourceBanner

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

- (void) initBanner {
    self.initialized = true;
    self.bannerViewController = [[UIViewController alloc] init];
    [IronSource setBannerDelegate:self];
}

- (void) loadBanner {
    if (!self.initialized) {
        [self initBanner];
    }
    [self destroyBanner];
    [IronSource loadBannerWithViewController:self.bannerViewController
                                        size:[[ISBannerSize alloc] initWithDescription:_size]];
}

- (void)destroyBanner {
    if (self.bannerView) {
        [IronSource destroyBanner:self.bannerView];
        self.bannerView = nil;
    }
}

- (void)setSize:(NSString *)size {
    _size = size;
    [self loadBanner];
}

- (void)bannerDidLoad:(ISBannerView *)bannerView {
    [self sendEvent:kIronSourceBannerDidLoad payload:nil];
    dispatch_async(dispatch_get_main_queue(), ^{
        bannerView.center = CGPointMake(self.frame.size.width / 2, self.frame.size.height / 2);
        [self addSubview:bannerView];
        self.bannerView = bannerView;
    });
}

- (void)bannerDidFailToLoadWithError:(NSError *)error {
    [self sendEvent:kIronSourceBannerDidFailToLoadWithError payload:nil];
}

- (void)bannerDidDismissScreen {
    [self sendEvent:kIronSourceBannerDidDismissScreen payload:nil];
}


- (void)bannerWillLeaveApplication {
    [self sendEvent:kIronSourceBannerWillLeaveApplication payload:nil];
}


- (void)bannerWillPresentScreen {
    [self sendEvent:kIronSourceBannerWillPresentScreen payload:nil];
}


- (void)didClickBanner {
    [self sendEvent:kIronSourceDidClickBanner payload:nil];
}

- (void)sendEvent:(NSString *)type payload:(NSDictionary *_Nullable)payload {
    self.onBannerEvent(@{
                         @"type": type,
                         @"payload": payload != nil ? payload : [NSNull null],
                         });
}

@end
