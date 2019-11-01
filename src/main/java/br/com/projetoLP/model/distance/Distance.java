package br.com.projetoLP.model.distance;

import br.com.projetoLP.model.heap.HeapTree;
import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.ProcessedImage;

public interface Distance {

    public void calcularDistacia(ProcessedImage img, ProcessedImage Target);

}
