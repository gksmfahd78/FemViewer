package com.pj.femviewer.file;

import com.opencsv.CSVReader;
import com.pj.femviewer.file.FileDataService;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileData<T>  implements FileDataService {

    @Override
    public String[] fileRead(String filePath) {
        String[] str = null;
        try {
            ArrayList<String[]> data = new ArrayList<>();
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

            while ((str = reader.readNext()) != null)
                data.add(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
