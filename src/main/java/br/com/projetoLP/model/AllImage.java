package br.com.projetoLP.model;

import java.util.ArrayList;

/**
 * The type All image.
 */
public class AllImage {

    /**
     * @Alterar de ArrayList para HeapTree mais tarde.
     */
    private ArrayList<ProcessedImage> allImage;

    /**
     * Instantiates a new All image.
     */
    public AllImage() {
        this.allImage = new ArrayList<>();
    }

    /**
     * Add.
     *
     * @param img the img
     */
    public void add (ProcessedImage img){
        allImage.add(img);
    }

    /**
     * Get image processed image.
     *
     * @param num the num
     * @return the processed image
     */
    public ProcessedImage getImage(int num){
        return allImage.get(num);
    }

    /**
     * Get value float.
     *
     * @param index  the index
     * @param column the column
     * @return the float
     */
    public Long getValue(int index, int column){
        return  allImage.get(index).get(column);
    }

    /**
     * Gets all image.
     *
     * @return the all image
     */
    public ArrayList<ProcessedImage> getAllImage() {
        return allImage;
    }

}
