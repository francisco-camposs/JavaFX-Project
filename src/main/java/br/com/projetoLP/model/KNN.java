package br.com.projetoLP.model;

import br.com.projetoLP.model.distance.ChebychevDistance;
import br.com.projetoLP.model.distance.Distance;
import br.com.projetoLP.model.distance.EuclideanDistance;
import br.com.projetoLP.model.distance.ManhathanDistance;
import br.com.projetoLP.model.enumeration.DistanceType;
import br.com.projetoLP.model.heap.HeapTree;
import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.ProcessedImage;

public class KNN {

    HeapTree heapTree;
    AllImage allImage;
    ProcessedImage processedImage;
    Distance distance;

    public KNN(AllImage allImage, ProcessedImage processedImage, DistanceType distanceType) {
        this.allImage = allImage;
        this.processedImage = processedImage;
        heapTree = new HeapTree();
        if (distanceType == DistanceType.MANHATHAN){
            distance = new ManhathanDistance();
        } else if (distanceType == DistanceType.CHEBYCHEV){
            distance = new ChebychevDistance();
        } else {
            distance = new EuclideanDistance();
        }
    }

    public void calcularDistancia(){

        for (var image: allImage.getAllImage()){
            distance.calcularDistacia(image, processedImage);
            if (heapTree.getSize() < 10){
                heapTree.addProcessedImage(image);
            } else {
                if (heapTree.peek().getDistance() > image.getDistance()) {
                    heapTree.remove();
                    heapTree.addProcessedImage(image);
                    heapTree.heapSort();
                }
            }
        }
        heapTree.heapSort();
    }

    public boolean hasPerson(){
        ProcessedImage processedImage = new ProcessedImage();
        int True = 0;
        int False = 0;
        int max = heapTree.getSize();
        for (int i = 0; i < max; i++) {
            if (heapTree.peek().isHasPerson()){
                True +=1;
            } else {
                False += 1;
            }
            processedImage = heapTree.peek();
            heapTree.remove();
        }


        if (True > False){
            return true;
        } else if (True < False) {
            return false;
        } else {
            return processedImage.isHasPerson();
        }
    }
}
