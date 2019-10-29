package br.com.projetoLP.model;

import java.util.ArrayList;

/**
 * The type Processed image. Essa classe é responsável por definir as imagens nos programas após processadas.
 */
public class ProcessedImage{

    private ArrayList<Long> param;
    private boolean hasPerson;

    /**
     * Instantiates a new Processed image.
     */
    public ProcessedImage() {
        this.param = new ArrayList<Long>(1000);
    }

    /**
     * Add element in param list.
     *
     * @param element the element
     */
    public void addElement(Long element){
        param.add(element);
    }

    /**
     * Add element in param list.
     *
     * @param element the element
     */
    public void addElement(String element){
        try {
            param.add(Long.parseLong(element));
        } catch (NumberFormatException ex){
            System.out.println(element+" is invalid for conversion");
        }
    }

    /**
     * Gets param.
     *
     * @return the param
     */
    public ArrayList<Long> getElements() {
        return param;
    }

    public Long get(int index){
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
        switch (hasPerson){
            case "person":
                this.hasPerson = true;
                break;
            case "notPerson":
                this.hasPerson = false;
                break;
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
