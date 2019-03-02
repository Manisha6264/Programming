package pscmr.ac.in.rescuethechild;

import android.app.AlertDialog;
import android.content.Context;
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

import static android.R.attr.type;

public class background1 extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog ad;
    String login_url="";
    String type="";
    String fn="";
    String ln="";
    String mid="";
    String pwd="";
    String add="";
    String pn="";


    background1(Context ctx)
    {
        context=ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        String fn=params[1];
        String ln=params[2];
        String mid=params[3];

        String pwd=params[4];
        String add=params[5];
        String pn=params[6];


        if(type.equals("peopleregistration"))
        {
            login_url="http://192.168.43.200/rescuethechild/peopleregistration.php";
        }
        else if(type.equals("orphanageregistration"))
        {
            login_url="http://192.168.43.200/rescuethechild/orphanageregistration.php";
        }

        try {
            URL url=new URL(login_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_data= URLEncoder.encode("fn","UTF-8")+"="+URLEncoder.encode(fn,"UTF-8")+"&"+
                    URLEncoder.encode("ln","UTF-8")+"="+URLEncoder.encode(ln,"UTF-8")+"&"+
                    URLEncoder.encode("mid","UTF-8")+"="+URLEncoder.encode(mid,"UTF-8")+"&"+
                    URLEncoder.encode("pwd","UTF-8")+"="+URLEncoder.encode(pwd,"UTF-8")+"&"+
                    URLEncoder.encode("add","UTF-8")+"="+URLEncoder.encode(add,"UTF-8")+"&"+

                    URLEncoder.encode("pn","UTF-8")+"="+URLEncoder.encode(pn,"UTF-8") ;
            bw.write(post_data);
            bw.flush();
            bw.close();
            outputStream.close();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line="";
            while((line=br.readLine())!=null )
            {
                result+=line;
            }
            br.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPreExecute() {
        ad=new AlertDialog.Builder(context).create();
        ad.setTitle("Saved Status");

    }

    @Override
    protected void onPostExecute(String result) {
        ad.setMessage(result);
        ad.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
