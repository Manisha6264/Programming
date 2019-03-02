package pscmr.ac.in.rescuethechild;


        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;

        /**
         * Created by ProgrammingKnowledge on 1/5/2016.
         */


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
        import android.os.StrictMode;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.support.v7.app.ActionBarActivity;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
        import org.json.JSONArray;
        import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {
    final static String url = "http://192.168.43.200/rescuethechild/login.php";
    EditText ed1,ed2;
    String msg,radio="";
    TextView td;
    RadioGroup rg1;
    RadioButton r1,r2;
    int st;

    Log d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        getSupportActionBar().setTitle(""); // set the top title
        String title = actionBar.getTitle().toString(); // get the title
        //actionBar.hide(); // or even hide the actionbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.o);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);

        rg1=(RadioGroup)findViewById(R.id.radio);



    }
    public void send(View view) {
        fetch();
    }
   public void fetch()
   {
       int selectedId=rg1.getCheckedRadioButtonId();
       r1=(RadioButton)findViewById(selectedId);
      // Toast.makeText(login.this,""+r1.getText(),Toast.LENGTH_LONG).show();
       radio=r1.getText().toString();
       List<NameValuePair> params = new ArrayList<NameValuePair>();
       params.add(new BasicNameValuePair("username", ed1.getText().toString()));
       params.add(new BasicNameValuePair("pwd", ed2.getText().toString()));
       params.add(new BasicNameValuePair("type",radio));

       try {
           Log.d("test",""+radio);
           String resultServer = Netconnectivity1.getHttpPost(url,params);
           JSONObject c = new JSONObject(resultServer);

           Log.d("test1",""+c);
           msg = (c.getString("msg"));
           if (msg.equals("Hai")) {

                             if(radio.equals("People")){

                                 Toast.makeText(login.this,"Login Successful",Toast.LENGTH_LONG).show();
                   Intent i = new Intent(this, home1.class);
                   i.putExtra("k1",ed1.getText().toString());
                   this.startActivity(i);
               }
               if(radio.equals("Orphanage"))
               {
                   Toast.makeText(login.this,"Login Successful",Toast.LENGTH_LONG).show();
                   Intent i = new Intent(this, home1.class);
                   i.putExtra("k1",ed1.getText().toString());
                   this.startActivity(i);
               }

           }
           else
           {
               Toast.makeText(login.this,"invalid credentials",Toast.LENGTH_LONG).show();
           }


       } catch (JSONException e) {
           e.printStackTrace();



       }

   }
}
