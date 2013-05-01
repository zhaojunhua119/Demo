package lambdazhao.java.serveraccesstest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	Button btnTest=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest=(Button)findViewById(R.id.btnTest);
        btnTest.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				AsyncHttpClient client = new AsyncHttpClient();
//http://sportsplus.oicp.net:8080/shroms/jiaoyimingxi/recoverybuy_getAllEnterprise.action
				client.get("http://10.0.2.2:8080/abc.json", new JsonHttpResponseHandler() {
		            
		            public void onSuccess(JSONArray timeline) {
		                // Pull out the first event on the public timeline
		            	try
		            	{
			                JSONObject firstEvent = timeline.getJSONObject(0);
			                String tweetText=firstEvent.toString();

			                Gson gson = new Gson();
			                Entity returndata = (Entity)
			                		gson.fromJson( tweetText, Entity.class);
			                Log.i("RESULT DATA",tweetText.toString());
			                
			                // Do something with the response
			                System.out.println(tweetText);
		            	}
		            	catch(JSONException ex)
		            	{
		            		
		            	}
		            }
		            
				});
			
				System.out.print(true);
			}
        	
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
class Entity
{
	public String text=null;
	public String pic=null;
}
