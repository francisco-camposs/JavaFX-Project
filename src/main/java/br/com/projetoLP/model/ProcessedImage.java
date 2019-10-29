package br.com.projetoLP.model;

import java.util.ArrayList;

/**
 * The type Processed image. Essa classe é responsável por definir as imagens nos programas após processadas.
 */
public class ProcessedImage{

    private ArrayList<Double> param;
    private boolean hasPerson;

    /**
     * Instantiates a new Processed image.
     */
    public ProcessedImage() {
        this.param = new ArrayList<Double>(1000);
    }

    /**
     * Add element in param list.
     *
     * @param element the element
     */
    public void addElement(Double element){
        param.add(element);
    }

    /**
     * Add element in param list.
     *
     * @param element the element
     */
    public void addElement(String element){
        try {
            param.add(Double.parseDouble(element));
        } catch (NumberFormatException ex){
            setHasPerson(element);
        }
    }

    /**
     * Gets param.
     *
     * @return the param
     */
    public ArrayList<Double> getElements() {
        return param;
    }

    public Double get(int index){
        return param.get(index);
    }

    /**
     * Sets if has person.
     *
     * @param hasPerson the has person
     */
    public void setHasPerson(boolean hasPerson) {
        this.hasPerson = hasPerson;
    }

    /**
     * Set if has person.
     *
     * @param hasPerson the has person
     */
    public void setHasPerson(String hasPerson){
        if (hasPerson.equals("\"person\"")){
            this.hasPerson = true;
        } else {
            this.hasPerson = false;
        }
    }

    /**
     * Is has person boolean.
     *
     * @return the boolean
     */
    public boolean isHasPerson() {
        return hasPerson;
    }
}
