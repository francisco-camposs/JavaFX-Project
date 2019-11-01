package br.com.projetoLP.model.heap;

import br.com.projetoLP.model.image.ProcessedImage;
import java.util.Arrays;

public class HeapTree {

    private ProcessedImage[] vector;

    // Number of elements.
    private int size;

    // Max number of elements.
    private int capacity;

    public ProcessedImage[] getVector() {
        return vector;
    }

    public HeapTree() {
        this(10);
    }

    public HeapTree(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        vector = new ProcessedImage[capacity];
    }

    public void addProcessedImage(ProcessedImage people){
        this.ensureCapacity();
        this.vector[getSize()] = people;
        heapifyUp(getSize());
        size+= 1;
    }

    private void heapifyUp(int index){
        if (!(hasParent(index))){
            return;
        }
        int parentIndex = getParentIndex(index);
        ProcessedImage node = vector[index];
        ProcessedImage pai = vector[parentIndex];

        if (node.getDistance() > pai.getDistance()){
            vector[index] = pai;
            vector[parentIndex] = node;
            heapifyUp(parentIndex);
        }
    }

    private boolean hasParent(int index){
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }

    private int getParentIndex(int index){
        return (int) Math.floor((index -1) / 2);
    }


    private void ensureCapacity() {
        if (getSize() == capacity){
            this.vector = Arrays.copyOf(this.vector, getSize()*2);
            capacity = getSize() * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public void remove() {
        vector[0] = vector[getSize()-1];
        vector[getSize() -1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int index){
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;

        if (leftChild < getSize()){
            childIndex = leftChild;
        }

        if (childIndex < 0){
            return;
        }

        if (rightChild < getSize()){
            if (vector[rightChild].getDistance() > vector[leftChild].getDistance()){
                childIndex = rightChild;
            }
        }

        if (vector[index].getDistance() < vector[childIndex].getDistance()){
            ProcessedImage tmp = vector[index];
            vector[index] = vector[childIndex];
            vector[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }

    public ProcessedImage peek() {
        if (getSize() == 0){
            return null;
        }
        return vector[0];
    }

    public void heapSort(){
        for(int i = getSize()-1; i>0; --i){
            ProcessedImage aux = vector[i];
            vector[i] = vector[0];
            vector[0] = aux;
            size--;
            heapifyDown(0, i);
        }
    }

    private void heapifyDown(int index, int length) {
        int leftChild = index*2+1;
        int rightChild = index*2+2;

        int maxIndex = index;

        if(leftChild < length && vector[leftChild].getDistance() > vector[index].getDistance()){
            maxIndex = leftChild;
        }

        if(rightChild < length && vector[rightChild].getDistance() > vector[maxIndex].getDistance()){
            maxIndex = rightChild;
        }

        if(maxIndex != index){
            ProcessedImage tmp = vector[maxIndex];
            vector[maxIndex] = vector[index];
            vector[index] = tmp;
            tmp = null;
            heapifyDown(maxIndex, length);
        }
    }


    private ProcessedImage[] heap(){
        if (size != 1){
            ProcessedImage aux;
            aux = vector[getSize() - 1];
            vector[getSize() - 1] = vector[0];
            vector[0] = aux;
            size--;
            heapifyDown(0);
            return heap();
        } else {
            return vector;
        }
    }

    @Override
    public String toString() {
        String finall = "";
        for (ProcessedImage value: vector) {
            finall = finall + value.toString();
        }
        return finall;
    }
}
