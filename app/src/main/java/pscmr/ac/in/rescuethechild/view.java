package pscmr.ac.in.rescuethechild;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class view extends AppCompatActivity
{
    String name,age,gname,phoneno,address;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view);

        final ConnectivityManager connMgr = (ConnectivityManager) view.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifi.isConnectedOrConnecting() || mobile.isConnectedOrConnecting())
        {
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            final ListView listView = (ListView) findViewById(R.id.offersListView);
            //String url = "http://pvp.pscmrcetonline.com/jsondata1.php";
            final String url = "http://192.168.0.8/hackthon/jsonmissing.php";
            // String url = "http://192.168.43.34/pvppscmrpq/facjsondata1.php";
            try {
                JSONArray data = new JSONArray(getJSONUrl(url));

                final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
                HashMap<String, String> map;

                for (int i = 0; i < data.length(); i++) {
                    JSONObject c = data.getJSONObject(i);
                    map = new HashMap<String, String>();
                    //  map.put("ImageID", c.getString("storename"));
                    // map.put("ImageDesc", c.getString("offername"));
                    //map.put("Gender",c.getString("gender"));
                    //map.put("ImagePath", c.getString("name"));
                    map.put("name", c.getString("name"));
                    map.put("age", c.getString("age"));
                    map.put("gname", c.getString("gname"));
                    map.put("phoneno", c.getString("phoneno"));
                    map.put("address", c.getString("address"));
                    map.put("ImagePath", c.getString("imgpath"));
                    MyArrList.add(map);
                }


                listView.setAdapter(new ImageAdapter(view.this, MyArrList));

               // listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                //    @Override
                //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //Intent intent = new Intent(view.this, fullview.class);
                        //intent.putExtra("key1",url);
                         // Object clickItemObj=parent.getAdapter().getItem(position);
                        //Toast.makeText(view.this, clickItemObj.toString(),Toast.LENGTH_LONG).show();
                       // intent.putExtra("key1",clickItemObj.toString());

                         //  startActivity(intent);*/

                        //Toast.makeText(ViewfacultyActivity1.this, clickItemObj.toString()+"FOR OFFERS SECTION PlEASE CHECK INTERNET CONNECTIVITY", Toast.LENGTH_LONG).show();
                   // }
                //});


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Object listItem = listView.getItemAtPosition(position);
                        Toast.makeText(view.this,""+listItem,Toast.LENGTH_LONG).show();
                    }
                });




            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            Toast.makeText(view.this, "FOR OFFERS SECTION PlEASE CHECK INTERNET CONNECTIVITY", Toast.LENGTH_LONG).show();
        }


    }//oncreate






    /*** Get JSON Code from URL ***/
    public String getJSONUrl(String url)
    {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try
        {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200)
            { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null)
                {
                    str.append(line);
                }
                Log.e("Results", ""+str);
            }
            else
            {
                Log.e("Log", "Failed to download file..");
            }
        }
        catch (ClientProtocolException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str.toString();
    }

    /***** Get Image Resource from URL (End) *****/
    public class ImageAdapter extends BaseAdapter
    {
        private Context context;
        private ArrayList<HashMap<String, String>> MyArr = new ArrayList<HashMap<String, String>>();

        public ImageAdapter(Context c, ArrayList<HashMap<String, String>> list)
        {
            // TODO Auto-generated method stub
            context = c;
            MyArr = list;
        }

        public int getCount() {
            // TODO Auto-generated method stub
            return MyArr.size();
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            // TODO Auto-generated method stub
            final ViewHolder holder ;


            //  LayoutInflater inflater = (LayoutInflater) context
            // .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            if (convertView == null)
            {

                holder = new ViewHolder();

                LayoutInflater inflater = view.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.activity_view1, null);
                holder.imageView = (ImageView) convertView.findViewById(R.id.imageView_logo);
                holder.imageView.getLayoutParams().height = 500;
                holder.imageView.getLayoutParams().width = 500;
                holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                holder.txtPosition = (TextView) convertView.findViewById(R.id.textView_name);
                holder.txtPosition.setPadding(10, 0, 0, 0);

                holder.txtPicName = (TextView) convertView.findViewById(R.id.textView_description);
                holder.txtPicName.setPadding(50, 0, 0, 0);

               // holder.b=(Button)convertView.findViewById(R.id.action);

                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }

            // ColImage
            /*ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView_logo);
            imageView.getLayoutParams().height = 100;
            imageView.getLayoutParams().width = 100;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);*/
            try
            {
                holder.imageView.setImageBitmap(loadBitmap(MyArr.get(position).get("ImagePath")));
            }
            catch (Exception e)
            {
                // When Error
                holder.imageView.setImageResource(android.R.drawable.ic_menu_report_image);
            }

            // ColPosition
            //TextView txtPosition = (TextView) convertView.findViewById(R.id.textView_name);
            //txtPosition.setPadding(10, 0, 0, 0);
            holder.txtPosition.setText(Html.fromHtml("<h5>Name:\t\t" + MyArr.get(position).get("name")+"</h5>"));


            // Html.fromHtml(value)

            // ColPicname
            //TextView txtPicName = (TextView) convertView.findViewById(R.id.textView_description);
            // txtPicName.setPadding(50, 0, 0, 0);
            holder.txtPicName.setText(Html.fromHtml("<h5><font color=#2ECC71>Age:\t</font><font color=#D0D3D4>" + MyArr.get(position).get("age")+"<br></font>"+
                    "<font color=#2ECC71>Gardien Name:\t</font><br><font color=#D0D3D4>"+MyArr.get(position).get("gname")+"<br></font>"+
                    "<font color=#2ECC71>Phone No:\t</font><font color=#D0D3D4>"+MyArr.get(position).get("phoneno")+"<br></font>"+
                    "<font color=#2ECC71>Address:\t</font><font color=#D0D3D4>"+MyArr.get(position).get("address")+"<br></font>"));



            holder.b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   View tempview = (View) holder.b.getTag(R.id.textView_description);
                    //TextView tv = (TextView) tempview.findViewById(R.id.number);
                    //Integer pos = (Integer) holder.btn_plus.getTag(R.integer.btn_plus_pos);

                    //int number = Integer.parseInt(tv.getText().toString()) + 1;
                   // tv.setText(String.valueOf(number));

                    //view.MyArr.get(pos);
                    //view.


                    Toast.makeText(view.this, "FOR OFFERS SECTION PlEASE CHECK INTERNET CONNECTIVITY"+tempview.getTag().toString(), Toast.LENGTH_LONG).show();

                }
            });

            return convertView;

        }

    }//ImageAdapter class

    static class ViewHolder {
        public ImageView imageView;
        public Button b;
        public TextView txtPosition,txtPicName,tv_total_bed,tv_total_bath,tv_area_sqft;
        //public MaterialIconView btn_like;
    }

    /***** Get Image Resource from URL (Start) *****/
    private static final String TAG = "ERROR";
    private static final int IO_BUFFER_SIZE = 10 * 2048;
    public static Bitmap loadBitmap(String url)
    {
        Bitmap bitmap = null;
        InputStream in = null;
        BufferedOutputStream out = null;
        try
        {
            in = new BufferedInputStream(new URL(url).openStream(), IO_BUFFER_SIZE);

            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
            out = new BufferedOutputStream(dataStream, IO_BUFFER_SIZE);
            copy(in, out);
            out.flush();

            final byte[] data = dataStream.toByteArray();
            BitmapFactory.Options options = new BitmapFactory.Options();
            //options.inSampleSize = 1;

            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,options);
        }
        catch (IOException e)
        {
            Log.e(TAG, "Could not load Bitmap from: " + url);
        }
        finally
        {
            closeStream(in);
            closeStream(out);
        }
        return bitmap;
    }

    private static void copy(InputStream in, OutputStream out) throws IOException
    {
        byte[] b = new byte[IO_BUFFER_SIZE];
        int read;
        while ((read = in.read(b)) != -1)
        {
            out.write(b, 0, read);
        }
    }
    private static void closeStream(Closeable stream)
    {
        if (stream != null)
        {
            try
            {
                stream.close();
            }
            catch (IOException e)
            {
                Log.e(TAG, "Could not close stream", e);
            }
        }
    }
}
