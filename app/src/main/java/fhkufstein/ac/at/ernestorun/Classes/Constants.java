package fhkufstein.ac.at.ernestorun.Classes;


public class Constants {
    public interface ADMANAGER {
        boolean USE_TEST_ADS = true;
        String ADMOB_USER_ID = "ca-app-pub-8160960481527784~9523842248";
        int NO_INTERNET_CONNECTION_MAX = 5; //after 5 ads which cannot be displayed notify user that this app gets financed by ads
        //Reward for rewarded video must be changed on Admob Console AND the following constant has to be the same Value!!!!

        interface TEST {
            String BANNER_AD_ID = "ca-app-pub-3940256099942544/6300978111";
            String INTERSTITIAL_AD_ID = "ca-app-pub-3940256099942544/1033173712";
            String REWARDED_VIDEO_AD_ID = "ca-app-pub-3940256099942544/5224354917";
        }
        interface REAL {
            String BANNER_AD_ID = "ca-app-pub-8160960481527784/1262208841";
            String INTERSTITIAL_AD_ID = "ca-app-pub-8160960481527784/5118581429";
            String REWARDED_VIDEO_AD_ID = "ca-app-pub-8160960481527784/5755987624";
        }
    }
}
