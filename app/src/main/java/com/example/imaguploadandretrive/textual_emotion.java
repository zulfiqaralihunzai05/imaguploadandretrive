package com.example.imaguploadandretrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class textual_emotion extends AppCompatActivity {

    EditText name;
    Button b1;
    String url="http://192.168.17.2/AndroidImageUpload/insertdata.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textual_emotion);

        name=(EditText)findViewById(R.id.text_message);

        b1=(Button)findViewById(R.id.prediction_button);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final String sname=name.getText().toString();

               RequestQueue queue = Volley.newRequestQueue(textual_emotion.this);

               StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {

                       Toast.makeText(textual_emotion.this, "Insertion Is:" + response, Toast.LENGTH_SHORT).show();
                       Log.d("response",response);
                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                       Toast.makeText(textual_emotion.this, "my error :" + error, Toast.LENGTH_LONG).show();
                       Log.i("My error", "" + error);

                   }
               }) {
                   @Override
                   protected Map<String, String> getParams() throws AuthFailureError {

                       Map<String, String> map = new HashMap<String, String>();
                       map.put("name",sname);

                       return map;
                   }
               };
               queue.add(request);
           }
       });
    }
}
