package jp.hack4.safety_transmission;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;

public class PreferenceActivity extends android.preference.PreferenceActivity {

    private HashMap<Integer, Intent> mHashMap;
    
    
    
    public PreferenceActivity() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
        

        mHashMap = new HashMap<Integer, Intent>();
        Intent intent;
        /*
         * Activity for Email Setting.
         */
        // intent = new Intent(getApplicationContext(), EmailPreferenceActivity.class);
        // mHashMap.put(R.string.email_preference_category_title, intent);
        /*
         * Activity for SMS setting.
         */
        Context context = getApplicationContext();
        intent = new Intent(context, SMSPreferences.class);
        Preference pref = findPreference(getString(R.string.sms_preference_key));
        pref.setIntent(intent);
        
        // mHashMap.put(R.string.sms_preference_category_title, intent);
        
        
        // setIntentForPreferences();
    }
    
    private void setIntentForPreferences() {
        
        for (Integer key_int : mHashMap.keySet()) {
            Intent intent = mHashMap.get(key_int);
            String key = getString(key_int);
            setIntentForPreference(key, intent);
        }
        
    }
    
    private void setIntentForPreference(String key, Intent intent) {
        Preference pref = findPreference(key);
        pref.setIntent(intent);
    }

    

}
