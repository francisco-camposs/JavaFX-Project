package br.com.projetoLP.model.distance;

import br.com.projetoLP.model.heap.HeapTree;
import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.ProcessedImage;

public abstract class Distance {
    protected HeapTree heapTree;
    protected AllImage allImage;
    protected ProcessedImage processedImage;

    public Distance(AllImage allImage, ProcessedImage processedImage) {
        this.allImage = allImage;
        this.processedImage = processedImage;
        heapTree = new HeapTree();
    }

    public abstract void calcularDistacia();

    public abstract void menoresDistancias();

    public abstract boolean hasPerson();
}
