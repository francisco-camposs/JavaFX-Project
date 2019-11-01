package br.com.projetoLP.model;

import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.ProcessedImage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
                if (tmp != ',' & tmp != '\n' & tmp != '\13'){
                    value = value+tmp;
                } else {
                    if (',' == tmp){
                        img.addElement(value, "numero");
                    } else {
                        value = value.substring(0,value.length()-1);
                        img.addElement(value, "letra");
                        allImage.add(img);
                        img = new ProcessedImage();
                    }
                    value = "";
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    
}
