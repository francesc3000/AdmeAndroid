package co.fullaverda.admeandroid;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView mTextView=null;
    TextView mTextView2=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        mTextView2 = (TextView) findViewById(R.id.text2);

// Instantiate the RequestQueue.
        RequestQueue queue = VolleySingleton.getInstance().getmRequestQueue();
        String url = "http://10.0.2.2:8080/v1";

// Request a string response from the provided URL.
        /*
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        mTextView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
        */
        /*
        MyObjectRequest request = new MyObjectRequest(Request.Method.GET,url + "/api", null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    String name = response.get("_links").toString();
                                    //String course = jsonObj.get("course").toString();
                                    //addToRepoList(name, course);
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }

                            }
                        } else {
                            // The user didn't have any repos.
                            listText("No repos found.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        listText("Error while calling REST API");
                        Log.e("Volley", error.toString());
                    }
                }
                ,"francesc3000"
                ,"abc123"
        );
        */

        AuthRequest request = new AuthRequest(Request.Method.GET, url + "/api/francesc3000/groups",null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Check the length of our response (to see if the user has any repos)
                if (response.length() > 0) {
                // The user does have repos, so let's loop through them all.
                for (int i = 0; i < response.length(); i++) {
                    try {
                        // For each repo, add a new line to our repo list.
                        String name = response.get("_links").toString();
                        //String course = jsonObj.get("course").toString();
                        //addToRepoList(name, course);
                    } catch (JSONException e) {
                        // If there is an error then output this to the logs.
                        Log.e("Volley", "Invalid JSON Object.");
                    }

                }
            } else {
                // The user didn't have any repos.
                listText("No repos found.");
            }
        }
    },
            new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            // If there a HTTP error then add a note to our repo list.
            listText("Error while calling REST API");
            Log.e("Volley", error.toString());
        }
    });

        /*
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url + "/api", null,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    String name = response.get("_links").toString();
                                    //String course = jsonObj.get("course").toString();
                                    //addToRepoList(name, course);
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }

                            }
                        } else {
                            // The user didn't have any repos.
                            listText("No repos found.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        listText("Error while calling REST API");
                        Log.e("Volley", error.toString());
                    }
                }
        );
        */
/*
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    // For each repo, add a new line to our repo list.
                                    JSONObject jsonObj = response.getJSONObject(i);
                                    String name = jsonObj.get("_links").toString();
                                    //String course = jsonObj.get("course").toString();
                                    //addToRepoList(name, course);
                                } catch (JSONException e) {
                                    // If there is an error then output this to the logs.
                                    Log.e("Volley", "Invalid JSON Object.");
                                }

                            }
                        } else {
                            // The user didn't have any repos.
                            listText("No repos found.");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        listText("Error while calling REST API");
                        Log.e("Volley", error.toString());
                    }
                }
        );
        */
// Add the request to the RequestQueue.
        queue.add(request);
    }

    private void addToRepoList(String name, String course) {
        mTextView.setText(name);
        mTextView2.setText(course);
    }

    private void listText(final String str) {
        // This is used for setting the text of our repo list box to a specific string.
        // We will use this to write a "No repos found" message if the user doens't have any.
        this.mTextView.setText(str);
    }
}
