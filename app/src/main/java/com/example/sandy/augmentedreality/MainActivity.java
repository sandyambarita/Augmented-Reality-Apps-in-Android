package com.example.sandy.augmentedreality;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import eu.kudan.kudan.ARAPIKey;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARAPIKey key = ARAPIKey.getInstance();
        key.setAPIKey("VMSr4k0MlrsFa7IJ+FZuCCXmEzhu65GHcGvTJIsdJ8Xay3sBPqT4eljkU214wdlwo/BLJkPGdcXb4IdpPCm18D2Iv0v/6h4xu4LWrOKn8Fje+MLvNm0v1pAHZxW2/LQlN5e6EDTbcBiZfvsoRYWCF4MpRFKpfGGQwdbwiKk5X6RTE7XRbW0CUS0DnR04baIYRmMnzQ7i1cGngc+rQ8LHhX7rqk8fctgt6q6G6k7B+UWBtLgd3KLrgNqUYM1fHXzU1yKpL7VFciAL+XL0XnjsiwTZvd+BnlyxwiY3KGJzQH8MjSixkWCE8Ktk9jfCppkCShKcB/N35UnRvwZboE2UGg8MbBXluruQASLkea0+1gwbuD3Ytnyd0WaXnSOOq1InzpmYuJo1lFam9ZOObOwUdH/bfA77E50v2oqVrLhNGXfEIi3IpmKcEqF6s6EzdnwePAfmBhmzg+w+9BW0jDF4efzxeu+HKEn9dlQgT2ml2CvqDVE+sfrwv+f2v+yGeJNkahr5dAkjcb/NgmgEtzhiF2ltJKMZiIOqnCzTf91jA5sPuCbc++ua4m100QmFQIXrqLrzoh9lNDoJbTlRVQfyPdQghfttG/hB/ww/N4ucZ/4NU8htsS56aqO5RrzRk27dgg7WM+VVs27eRWW94R5GIdCJRlkisLZ+Gao/5xqELh4=");
        permissionsRequest();
    }

    // Requests app permissions
    public void permissionsRequest() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED ||ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 111);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 111: {
                if (grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED ) {

                } else {
                    permissionsNotSelected();
                }
            }
        }
    }

    private void permissionsNotSelected() {
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setTitle("Permissions Requred");
        builder.setMessage("Please enable the requested permissions in the app settings in order to use this demo app");
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener () {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                System.exit(1);
            }
        });
        AlertDialog noInternet = builder.create();
        noInternet.show();
    }


    public void startARActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ARCameraActivity.class);
        startActivity(intent);
    }
}
