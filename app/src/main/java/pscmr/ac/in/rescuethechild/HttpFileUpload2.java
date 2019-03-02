package pscmr.ac.in.rescuethechild;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpFileUpload2 implements Runnable{
    URL connectURL;
    String responseString;
    String Title;
    String fileName;
    String Description;
    byte[ ] dataToServer;
    String user,lat1,lng1,templename,t1,t2,t3,t4,t5;
    FileInputStream fileInputStream = null;
    HttpFileUpload2(String urlString, String file,String name,String age,String gname,String phoneno,String address){
        try{
            connectURL = new URL(urlString);
            //Title= vTitle;
            //Description = vDesc;
            fileName = file;
            t1=name;
            t2=age;
            t3=gname;
            t4=phoneno;
            t5=address;
            Log.d("entries",t1+t2+t3+t4+t5);

        }
        catch(Exception ex)
        {
            Log.i("HttpFileUpload","URL Malformatted");
        }
    }

    Boolean Send_Now(FileInputStream fStream){
        fileInputStream = fStream;
        return Sending();
    }

    Boolean Sending(){

        System.out.println("file Name is :"+fileName);

        String iFileName = fileName;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        String Tag="fSnd";
        try
        {
            Log.e(Tag,"Starting Http File Sending to URL"+t1+t2+t3+t4+t5);

            // Open a HTTP connection to the URL
            HttpURLConnection conn = (HttpURLConnection)connectURL.openConnection();

            // Allow Inputs
            conn.setDoInput(true);

            // Allow Outputs
            conn.setDoOutput(true);

            // Don't use a cached copy.
            conn.setUseCaches(false);

            // Use a post method.
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Connection", "Keep-Alive");

            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());

           /* dos.writeBytes(twoHyphens + boundary + lineEnd);
            dos.writeBytes("Content-Disposition: form-data; name=\"title\""+ lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(Title);
            dos.writeBytes(lineEnd);
            dos.writeBytes(twoHyphens + boundary + lineEnd);

            dos.writeBytes("Content-Disposition: form-data; name=\"description\""+ lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(Description);
            dos.writeBytes(lineEnd);*/
           // dos.writeBytes(twoHyphens + boundary + lineEnd);


            dos.writeBytes(twoHyphens + boundary + lineEnd);


            dos.writeBytes("Content-Disposition: form-data; name=\"t1\""+t1+"\""+ lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(t1);
            dos.writeBytes(lineEnd);

            dos.writeBytes(twoHyphens + boundary + lineEnd);

            dos.writeBytes("Content-Disposition: form-data; name=\"t2\""+t2+"\""+ lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(t2);
            dos.writeBytes(lineEnd);

            dos.writeBytes(twoHyphens + boundary + lineEnd);

            dos.writeBytes("Content-Disposition: form-data; name=\"t3\""+t3+"\""+ lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(t3);
            dos.writeBytes(lineEnd);

            dos.writeBytes(twoHyphens + boundary + lineEnd);

            dos.writeBytes("Content-Disposition: form-data; name=\"t4\""+t4+"\""+ lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(t4);
            dos.writeBytes(lineEnd);

            dos.writeBytes(twoHyphens + boundary + lineEnd);

            dos.writeBytes("Content-Disposition: form-data; name=\"t5\""+t5+"\""+ lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(t5);
            dos.writeBytes(lineEnd);

            dos.writeBytes(twoHyphens + boundary + lineEnd);


            dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + iFileName +"\"" + lineEnd);
            dos.writeBytes(lineEnd);

            Log.e(Tag,"Headers are written");

            // create a buffer of maximum size
            int bytesAvailable = fileInputStream.available();

            int maxBufferSize = 1024;
            int bufferSize = Math.min(bytesAvailable, maxBufferSize);
            byte[ ] buffer = new byte[bufferSize];

            // read file and write it into form...
            int bytesRead = fileInputStream.read(buffer, 0, bufferSize);

            while (bytesRead > 0)
            {
                dos.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable,maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0,bufferSize);
            }
            dos.writeBytes(lineEnd);
            dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            // close streams
            fileInputStream.close();

            dos.flush();

            Log.e(Tag,"File Sent, Response: "+String.valueOf(conn.getResponseCode()));

            InputStream is = conn.getInputStream();

            // retrieve the response from server
            int ch;

            StringBuffer b =new StringBuffer();
            while( ( ch = is.read() ) != -1 ){ b.append( (char)ch ); }
            String s=b.toString();
            Log.e(Tag,"Response"+s);
            dos.close();

            if(String.valueOf(conn.getResponseCode()).equals("200"))
            {
                return true;
            }else{
                return false;
            }
        }
        catch (MalformedURLException ex)
        {
            Log.e(Tag, "URL error: " + ex.getMessage(), ex);
        }

        catch (IOException ioe)
        {
            Log.e(Tag, "IO error: " + ioe.getMessage(), ioe);
        }
        return false;
    }

    @Override
    public void run() {
    }
}