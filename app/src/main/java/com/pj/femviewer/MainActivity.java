package com.pj.femviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.pj.femviewer.draw.DrawLine;
import com.pj.femviewer.file.FileData;

public class  MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private String testInputPath = "";

    private Variable variable = new Variable();
    private FileData fileData = new FileData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imv);

        //test path
        variable.setFilePath(testInputPath);
        DrawLine drawLine = new DrawLine();
        drawLine.drawLine(fileData.fileRead(variable.getFilePath()));
    }

    public void init() {

    }
}
