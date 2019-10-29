package br.com.projetoLP.model.CSV;

import br.com.projetoLP.model.AllImage;

import java.io.File;
import java.net.URL;

public abstract  class CsvReader {

    private String pathFile;
    private File dataSet;

    public CsvReader(String pathFile) {
        this.pathFile = pathFile;
    }

    public void searchFile(){
        try {
            dataSet = new File(pathFile);
        } catch (NullPointerException ex){
            System.out.println(ex.getStackTrace());
        }
    }

    public abstract void read();
    
}
