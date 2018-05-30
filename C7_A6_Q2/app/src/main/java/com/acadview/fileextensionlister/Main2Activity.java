package com.acadview.fileextensionlister;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    String extension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        extension= getIntent().getStringExtra("extension");

        List validFiles=new ArrayList<>();
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,validFiles);
        ListView listView=findViewById(R.id.list);
        Log.d("TEST","Inside function");

        File base= new File(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));



        File[]listOfFiles=base.listFiles();
       // Log.d("TEST","length = "+listOfFiles.length);

        for(File file:listOfFiles){
            if(file.isFile()){

                //call the function to check extension
                if(checkFileExtension(file)){
                     validFiles.add(file.getName());
                    Log.d("TEST","file.getName()");
                }
                Log.d("TEST","Inside loop ");
            }
        }

        listView.setAdapter(arrayAdapter);
    }

    private boolean checkFileExtension(File file) {

        if(file.getName().endsWith("."+extension))
        return true;
        else{

            return false;
        }
    }
}
