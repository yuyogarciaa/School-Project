package com.example.projectc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class signup_fragment extends Fragment {

    String str_fullname, str_email,str_password, str_username;
    String url="https://projects-insane.000webhostapp.com/login/insertar.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment,container,false);


        EditText email = root.findViewById(R.id.email);
        EditText pass = root.findViewById(R.id.pass);
        EditText name = root.findViewById(R.id.fullname);
        EditText user = root.findViewById(R.id.username);
        Button signup = root.findViewById(R.id.buttonsignup);
        float v = 0;

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("")){
                    Toast.makeText(getContext().getApplicationContext(), "enter your Fullname",Toast.LENGTH_SHORT).show();
                }
                else if (email.getText().toString().equals("")){
                    Toast.makeText(getContext().getApplicationContext(), "enter your email",Toast.LENGTH_SHORT).show();
                }
                else if (pass.getText().toString().equals("")){
                    Toast.makeText(getContext().getApplicationContext(), "enter your password",Toast.LENGTH_SHORT).show();
                }
                else if (user.getText().toString().equals("")){
                    Toast.makeText(getContext().getApplicationContext(), "enter your username",Toast.LENGTH_SHORT).show();
                }
                else {
                    str_fullname = name.getText().toString().trim();
                    str_email = email.getText().toString().trim();
                    str_password = pass.getText().toString().trim();
                    str_username = user.getText().toString().trim();

                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            name.setText("");
                            email.setText("");
                            pass.setText("");
                            user.setText("");
                            Toast.makeText(getContext().getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getContext().getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    ) {
                        @Override
                        protected java.util.Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("fullname", str_fullname);
                            params.put("username", str_username);
                            params.put("password", str_password);
                            params.put("email", str_email);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getContext().getApplicationContext());
                    requestQueue.add(request);
                }
            }
        });

        email.setTranslationX(800);
        pass.setTranslationX(800);
        name.setTranslationX(800);
        user.setTranslationX(800);
        signup.setTranslationX(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        name.setAlpha(v);
        user.setAlpha(v);
        signup.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        name.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        user.animate().translationX(0).alpha(1).setDuration(800).setDuration(500).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setDuration(800).start();

        return root;
    }
}
