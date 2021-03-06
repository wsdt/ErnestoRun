package fhkufstein.ac.at.ernestorun.Classes;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import fhkufstein.ac.at.ernestorun.R;

import static com.google.android.gms.ads.AdRequest.ERROR_CODE_NETWORK_ERROR;

public class AdManager {
    private static final String TAG = "AdManager";
    private Activity context;


    //TODO: für internet permission prüfen und verlangen usw.
    public AdManager(Activity context) {
        this.setContext(context);
    }

    public void initializeAdmob() {
        MobileAds.initialize(this.getContext(), Constants.ADMANAGER.ADMOB_USER_ID);
        Log.d(TAG, "initializeAdMob: Tried to initialize Admob. Maybe regardless of temporarily ad-free, because we always want to display rewarded ads!");
    }


    public RewardedVideoAd loadRewardedVideoInRewardActivity(@Nullable RewardedVideoAdListener adListener, @Nullable final Intent goToActivityAfterShown) {
        final String REWARDED_VIDEO_ID = Constants.ADMANAGER.USE_TEST_ADS ? Constants.ADMANAGER.TEST.REWARDED_VIDEO_AD_ID : Constants.ADMANAGER.REAL.REWARDED_VIDEO_AD_ID;

        final RewardedVideoAd rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this.getContext());
        rewardedVideoAd.setRewardedVideoAdListener((adListener == null) ? new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                //just in case validate whether app is loaded
                if (rewardedVideoAd.isLoaded()) {
                    rewardedVideoAd.show(); //show ad if loaded
                    Log.d(TAG, "onRewardedVideoAdLoaded: Tried to show rewarded video ad.");
                } else {
                    Log.e(TAG, "onRewardedVideoAdLoaded: This error should not happen.");
                }
            }

            @Override
            public void onRewardedVideoAdOpened() {
                Log.d(TAG, "onRewardedVideoAdOpened: Opened Rewarded video ad and have informed user.");
                Toast.makeText(getContext(), "After watching you can continue the game and get 10 coins.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {
                //if ad closed go to gotoActivity
                Log.d(TAG, "onRewardedVideoAdClosed: Rewarded video ad got closed and new activity got started.");
                if (goToActivityAfterShown != null) {
                    Log.d(TAG, "onRewardedVideoAdClosed: gotoActivity is not null.");
                    getContext().startActivity(goToActivityAfterShown);
                } else {
                    //IMPORTANT: In this case (because this ad has its own activity) we finish the activity if no target activity is specified.
                    Log.d(TAG, "onRewardedVideoAdClosed: Tried to finish activity.");
                    getContext().finish();
                }
            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                //Toast.makeText(getContext(), String.format(getContext().getResources().getString(R.string.adManager_loadRewardedVideoInRewardActivity_reward_successMessage), rewardItem.getAmount()), Toast.LENGTH_LONG).show();

                //Restart activity (to reload all ads [in this case remove them])
                //Log.d(TAG, "loadRewardedVideoInRewardActivity:onRewarded: Trying to remove Banner Ad on the bottom of MainActivity.");
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int errorcode) {
                Log.e(TAG, "onAdFailedToLoad: Could not load interstitial ad. Errorcode: " + errorcode);
                if (errorcode == ERROR_CODE_NETWORK_ERROR) {
                    //only error code where user might be the reason so increment counter
                    Log.d(TAG, "onAdFailedToLoad: Tried to increment noInternetConnectionCounter.");
                    Toast.makeText(getContext(), "Do you have internet?", Toast.LENGTH_SHORT).show();
                }

                if (goToActivityAfterShown != null) {
                    Log.d(TAG, "onAdClosed: gotoActivity is not null.");
                    getContext().startActivity(goToActivityAfterShown); //does app not prevent from being executed without internet
                } else {
                    //IMPORTANT: In this case (because this ad has its own activity) we finish the activity if no target activity is specified.
                    Log.d(TAG, "onRewardedVideoAdFailedToLoad: Tried to finish activity.");
                    getContext().finish();
                }
            }
        } : adListener); //add given listener or create default one
        Log.d(TAG, "loadRewardedVideoInRewardActivity: Created reward video instance etc.");

        rewardedVideoAd.loadAd(REWARDED_VIDEO_ID, new AdRequest.Builder().build());
        Log.d(TAG, "loadRewardedVideoInRewardActivity: Tried to load rewarded video.");

        return rewardedVideoAd;
    }


    public void loadFullPageAd(@Nullable final AdListener adListener, @Nullable final Intent goToActivityAfterShown) {
        Log.d(TAG, "executeIfProductIsBought:is_false: App is NOT ad-free, so full page ad will be loaded.");

        //IMPORTANT: ADMOB-GUIDELINE only place interestials between activities with contents and not too much!! Showing Fullpage Ad only allowed if loadingActivity shows BEFORE ad! (see: https://support.google.com/admob/answer/6201362?hl=de&ref_topic=2745287)
        final String FULLPAGE_ID = Constants.ADMANAGER.USE_TEST_ADS ? Constants.ADMANAGER.TEST.INTERSTITIAL_AD_ID : Constants.ADMANAGER.REAL.INTERSTITIAL_AD_ID;

        final InterstitialAd fullpageAd = new InterstitialAd(getContext());
        fullpageAd.setAdUnitId(FULLPAGE_ID);
        fullpageAd.loadAd(new AdRequest.Builder().build());
        fullpageAd.setAdListener((adListener == null) ? new AdListener() {
            @Override
            public void onAdLoaded() {
                //just in case validate whether app is loaded
                if (fullpageAd.isLoaded()) {
                    fullpageAd.show(); //show ad if loaded
                    Log.d(TAG, "onAdLoaded: Tried to show fullpage ad.");
                } else {
                    Log.e(TAG, "onAdLoaded: This error should not happen.");
                }
            }

            @Override
            public void onAdClosed() {
                //if ad closed go to gotoActivity
                Log.d(TAG, "onAdClosed: Interstitial ad got closed and new activity might get started.");
                if (goToActivityAfterShown != null) {
                    Log.d(TAG, "onAdClosed: gotoActivity is not null.");
                    getContext().startActivity(goToActivityAfterShown);
                }
            }

            @Override
            public void onAdFailedToLoad(int errorcode) {
                Log.e(TAG, "onAdFailedToLoad: Could not load interstitial ad. Errorcode: " + errorcode);
                if (errorcode == ERROR_CODE_NETWORK_ERROR) {
                    //only error code where user might be the reason so increment counter
                    Toast.makeText(getContext(), "Do you have internet?", Toast.LENGTH_SHORT).show(); //here and not outside because of frequency capping (e.g.) errorcode = 3
                }

                if (goToActivityAfterShown != null) {
                    Log.d(TAG, "onAdClosed: gotoActivity is not null.");
                    getContext().startActivity(goToActivityAfterShown); //does app not prevent from being executed without internet
                }
            }
        } : adListener); //IMPORTANT: add given adListener, if null create default one
    }

    //Helper method for loadBannerAd() (e.g. when watched RewardedVideoAd then to refresh activity)
   /* private void removeBannerAd(RelativeLayout viewGroup) {
        AdView adView = (AdView) viewGroup.findViewById(R.id.RL_BannerAd_ID);
        if (adView != null) {
            Log.d(TAG, "loadBannerAd: Removed ad (im Nachhinein), because ad was displayed but now should be removed.");
            adView.destroy();
            adView.setVisibility(View.GONE);
        } else {
            Log.d(TAG, "loadBannerAd: There was no banner ad to remove.");
        }
    }*/

    public void loadBannerAd(@NonNull final RelativeLayout viewGroup) {
        final String BANNER_ID = Constants.ADMANAGER.USE_TEST_ADS ? Constants.ADMANAGER.TEST.BANNER_AD_ID : Constants.ADMANAGER.REAL.BANNER_AD_ID;

        final AdView adView = new AdView(getContext());
        //adView.setId(R.id.RL_BannerAd_ID); //so we can remove it afterwards when e.g. temporarly inactive
        adView.setAdSize(AdSize.SMART_BANNER); //IMPORTANT: adsize and adunit should be added in the same manner! (programmatically | xml)
        adView.setAdUnitId(BANNER_ID);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adView.setLayoutParams(lp);

        adView.loadAd(new AdRequest.Builder().build());
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorcode) {
                if (errorcode == ERROR_CODE_NETWORK_ERROR) {
                    //only error code where user might be the reason so increment counter
                    Toast.makeText(getContext(), "Do you have internet?", Toast.LENGTH_SHORT).show();
                }
                Log.e(TAG, "onAdFailedToLoad (loadBannerAd): Banner could not be loaded.");
            }

            @Override
            public void onAdLoaded() {
                viewGroup.removeView(adView);
                viewGroup.addView(adView); //add to layout if loaded
                Log.d(TAG, "onAdLoaded (loadBannerAd): Banner successfully loaded.");
            }
        });
    }


    // GETTER / SETTER ---------------------------
    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }
}
