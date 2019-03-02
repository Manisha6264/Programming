package pscmr.ac.in.rescuethechild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity  {

    String[] Names={"---Register As---","People","Orphanage"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Names);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
            {

                switch (position) {
                    case 1:
                        startActivity(new Intent(arg1.getContext(),PeopleRegistrationPage.class));
                        break;
                    case 2:
                        startActivity(new Intent(arg1.getContext(),OReg.class));
                        break;


                }
               // Toast.makeText(getApplicationContext(), Names[position], Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
            }

        });

    }
    public void login (View view)
    {
        Intent i=new Intent(this,login.class);
        startActivity(i);

    }


}
