package br.com.projetoLP.model.distance;

import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.ProcessedImage;

public class ManhathanDistance extends Distance{

    public ManhathanDistance(AllImage allImage, ProcessedImage processedImage) {
        super(allImage, processedImage);
    }

    @Override
    public void calcularDistacia() {

    }

    @Override
    public void menoresDistancias() {

    }

    @Override
    public boolean hasPerson() {
        return false;
    }
}
