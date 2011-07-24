package jp.hack4.safety_transmission;

import java.util.List;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {
    private LocationManager mgr;
    
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /* �ʒu���̎擾 */  
		 // ���P�[�V�����}�l�[�W���̎擾  
		 LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);  
		 // �œK�Ȉʒu���v���o�C�_�̑I��  
		 // Criteria��ύX���邱�ƂŁC�e��ݒ�ύX�\  
		 String bs = lm.getBestProvider(new Criteria(), true);  
		   
		 Location locate = lm.getLastKnownLocation(bs);  
		 if(locate == null){  
		  // ���ݒn���擾�ł��Ȃ������ꍇ�CGPS�Ŏ擾���Ă݂�  
		  locate = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);  
		 }  
		 if(locate == null){  
		  // ���ݒn���擾�ł��Ȃ������ꍇ�C�������ʂŎ擾���Ă݂�  
		  locate = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);  
		 }  
		 
		 if(locate != null){ // ���ݒn���擾����  
		  // �ܓx�̎擾  
		  int latitude = (int) (locate.getLatitude() * 1e6);  
		  // �o�x�̎擾  
		  int longitude = (int) (locate.getLongitude() * 1e6);  
		  Log.d("MYTAG", String.valueOf(latitude));  
		  Log.d("MYTAG", String.valueOf(longitude));  
		 } else {  
		  /* ���ݒn���擾���s���� */
			 // �[���̈ʒu���ݒ��ʂ֑J��  
			 try {  
			  startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));  
			 } catch (final ActivityNotFoundException e) {  
			  // �ʒu���ݒ��ʂ��Ȃ��[���̏ꍇ  
			 } 
			 
		 }
		 
		
        
        Button button = (Button)findViewById(R.id.save_button);
        button.setOnClickListener(new View.OnClickListener() {
			
        	
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("TEST","Enter here2");

												
			    Intent intent = new Intent();  
			    // �A�N�V�������w��  
			    intent.setAction(Intent.ACTION_SENDTO);  
			    // �f�[�^���w��  
			    intent.setData(Uri.parse("mailto:kawamurh@gmail.com"));  
			    // �������w��  
			    intent.putExtra(Intent.EXTRA_SUBJECT, "����");  
			    // �{�����w��  
			    intent.putExtra(Intent.EXTRA_TEXT, "�{���̓��e");  
			    // Intent�𔭍s  
			    startActivity(intent);  
			    
			}

		});
    }


	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}


	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}


	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}


}