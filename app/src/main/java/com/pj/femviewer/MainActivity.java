package com.pj.femviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FileData {

    private Variable variable = new Variable();
    private Canvas canvas = new Canvas();
    private Paint paint = new Paint();
    private Path path = new Path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test path
        variable.setFilePath("");
        drawLine(fileRead());
    }

    //test code
    @Override
    public String[] fileRead() {
        String[] str = null;
        try {
            ArrayList<String[]> data = new ArrayList<>();
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(variable.getFilePath()), "UTF-8"));

            while ((str = reader.readNext()) != null)
                data.add(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public void drawLine(String[] str) {
        for(int i = 0; i < str.length; i += 3) {

            int startX = Integer.parseInt(str[i+1].split(" ")[0]);
            int startY = Integer.parseInt(str[i+1].split(" ")[1]);
            int endX = Integer.parseInt(str[i+2].split(" ")[0]);
            int endY = Integer.parseInt(str[i+2].split(" ")[1]);

            if(!str[i].equals("\n")) {
                if (str[i].equals("직선")) {
                    straightLine(startX, startY, endX, endY);
                } else {
                    curvedLine(startX, startY, endX, endY);
                }
            } else {
                continue;
            }
        }
    }

    public void straightLine(int startX, int startY, int endX, int endY) {
        drawOption();
        path.moveTo(startX, startY);
        path.lineTo(endX, endY);
        canvas.drawPath(path, paint);
    }

    public void curvedLine(int startX, int startY, int endX, int endY) {
        int mx1 = (endX-startX)/2,
                my1 = endY,
                mx2 = (endX-startX)/2,
                my2 = startY;

        drawOption();
        path.moveTo(startX, startY);
        path.cubicTo(mx1, my1, mx2, my2, endX, endY);
        canvas.drawPath(path, paint);
    }

    public void drawOption() {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void drawClear() {
        path.reset();
        canvas.drawPath(path, paint);
    }
}