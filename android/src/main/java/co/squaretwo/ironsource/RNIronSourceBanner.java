package co.squaretwo.ironsource;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.FrameLayout;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ColorUtil;
import com.facebook.react.views.view.ReactViewGroup;
import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerListener;


public class RNIronSourceBanner extends SimpleViewManager<FrameLayout> implements BannerListener, LifecycleEventListener {

    private FrameLayout bannerContainer;

//    @Override
//    public IronSourceBannerLayout createViewInstance(ThemedReactContext context) {
//        return IronSource.createBanner(context.getCurrentActivity(), ISBannerSize.LARGE);
//    }
//
//    @ReactProp(name = "size")
//    public void setSize(IronSourceBannerLayout banner, String size) {
//        banner.setBannerListener(this);
//        IronSource.loadBanner(banner);
//    }

    private ReactContext context;

    public RNIronSourceBanner(ReactApplicationContext reactContext) {
        this.context = reactContext;
    }


    @Override
    public FrameLayout createViewInstance(ThemedReactContext context) {
        return new FrameLayout(context);
    }

    @ReactProp(name = "size")
    public void setSize(FrameLayout layout, String size) {
        final IronSourceBannerLayout banner = IronSource.createBanner(
                this.context.getCurrentActivity(), ISBannerSize.BANNER);
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                840,
                131
        );
//        view.setLayoutParams(layoutParams);
//        view.setWillNotDraw(false);
//        banner.setLayoutParams(layoutParams);
        banner.setBackgroundColor(Color.BLUE);
//        banner.setBannerListener(this);
//        banner.setWillNotDraw(false);
        IronSource.loadBanner(banner);
//        view.removeAllViews();
        layout.removeAllViews();
        layout.addView(banner);
        layout.setBackgroundColor(Color.GREEN);
//        banner.setMeasureAllChildren(true);
//        banner.setLeft(3);
//        banner.setRight(969);
//        banner.setTop(54);
//        banner.setBottom(448);
//        banner.setX(10);
//        banner.setY(10);

//        view.setLeft(3);
//        view.setRight(969);
//        view.setTop(54);
//        view.setBottom(448);
    }

//    @ReactProp(name = "size")
//    public void setSize(FrameLayout view, String size) {
//        final IronSourceBannerLayout banner = IronSource.createBanner(
//                this.context.getCurrentActivity(), ISBannerSize.BANNER);
//        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
//                840,
//                131
//        );
//        view.setLayoutParams(layoutParams);
//        view.setBackgroundColor(Color.GREEN);
//        view.setWillNotDraw(false);
//        banner.setLayoutParams(layoutParams);
//        banner.setBackgroundColor(Color.BLUE);
//        banner.setBannerListener(this);
//        banner.setWillNotDraw(false);
//        IronSource.loadBanner(banner);
////        view.removeAllViews();
//        view.addView(banner);
//        banner.setMeasureAllChildren(true);
////        banner.setLeft(3);
////        banner.setRight(969);
////        banner.setTop(54);
////        banner.setBottom(448);
//        banner.setX(10);
//        banner.setY(10);
//
////        view.setLeft(3);
////        view.setRight(969);
////        view.setTop(54);
////        view.setBottom(448);
//    }

    @Override
    public void onBannerAdLoaded() {
        int a = 1;
    }

    @Override
    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {

    }

    @Override
    public void onBannerAdClicked() {

    }

    @Override
    public void onBannerAdScreenPresented() {

    }

    @Override
    public void onBannerAdScreenDismissed() {

    }

    @Override
    public void onBannerAdLeftApplication() {

    }

    @Override
    public String getName() {
        return "RNIronSourceBanner";
    }

    @Override
    public void onHostResume() {
        IronSource.onResume(this.context.getCurrentActivity());
    }

    @Override
    public void onHostPause() {
        IronSource.onPause(this.context.getCurrentActivity());
    }

    @Override
    public void onHostDestroy() {

    }
}
