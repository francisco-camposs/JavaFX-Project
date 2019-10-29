package br.com.projetoLP.model;

import br.com.projetoLP.model.AllImage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class CsvReader {

    private String pathFile;
    private File dataSet;

    public CsvReader(String pathFile) {
        this.pathFile = pathFile;
    }

    public void searchFile(){
        try {
            dataSet = new File(pathFile);
        } catch (NullPointerException ex){
//            System.out.println(ex.getStackTrace());
        }
    }

    public void read(AllImage allImage){
        FileReader fileReader;
        String value = "";
        ProcessedImage img = new ProcessedImage();
        char tmp;
        try {
            fileReader = new FileReader(dataSet);
            while ((char) fileReader.read() != '\n'){

            }
            while (fileReader.ready()){
                tmp = (char)fileReader.read();
                if (tmp != ',' & tmp != '\n'){
                    value = value+tmp;
                } else {
                    if (',' == tmp){
                        img.addElement(value);
                        value = "";
                    }else {
                        img.addElement(value);
                        value = "";
                        allImage.add(img);
                        img = new ProcessedImage();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    
}
