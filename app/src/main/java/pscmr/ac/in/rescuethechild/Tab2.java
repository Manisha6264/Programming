package pscmr.ac.in.rescuethechild;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab2 extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    final static String url = "http://192.168.43.200/rescuethechild/update.php";
    int st,st1,st2;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);


        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        ed1=(EditText)findViewById(R.id.editText4);
        ed2=(EditText)findViewById(R.id.editText5);


        ed4=(EditText)findViewById(R.id.editText7);
        ed5=(EditText)findViewById(R.id.editText13);
        ed6=(EditText)findViewById(R.id.editText14);
    }
    public void send3(View view)

    {Log.d("hai","hai1");
        Toast.makeText(Tab2.this,"hai",Toast.LENGTH_LONG).show();
        fetch();
       /* String fn=ed1.getText().toString();
        String ln=ed2.getText().toString();
        String mid=ed3.getText().toString();
        String pwd=ed4.getText().toString();
        String add=ed5.getText().toString();
        String pn=ed6.getText().toString();
        String type="peopleregistration";

        background1 bg=new background1(this);
        bg.execute(type,fn,ln,mid,pwd,add,pn);*/
    }
    public void fetch()
    {


        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("fn", ed1.getText().toString()));
        params.add(new BasicNameValuePair("ln", ed2.getText().toString()));
        params.add(new BasicNameValuePair("pwd", ed4.getText().toString()));
        params.add(new BasicNameValuePair("add", ed5.getText().toString()));
        params.add(new BasicNameValuePair("pn", ed6.getText().toString()));

        try {
            String resultServer = Netconnectivity1.getHttpPost(url,params);
            JSONObject c = new JSONObject(resultServer);
            Log.d("test",""+c);
            msg = (c.getString("msg"));
            if (msg.equals("Hai")) {
                Toast.makeText(Tab2.this,"Updated Successfully",Toast.LENGTH_LONG).show();
                Intent i = new Intent(this, home1.class);
                i.putExtra("k1",ed1.getText().toString());
                this.startActivity(i);
            }
            else
            {
                Toast.makeText(Tab2.this,"invalid credentials",Toast.LENGTH_LONG).show();
            }


        } catch (JSONException e) {
            e.printStackTrace();



        }

    }

}
