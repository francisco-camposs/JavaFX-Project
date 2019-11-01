package br.com.projetoLP.model.distance;

import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.ProcessedImage;

public class ChebychevDistance implements Distance {

    @Override
    public void calcularDistacia(ProcessedImage img, ProcessedImage target) {
        double soma = img.get(0) - target.get(0);
        for (int i = 1; i < 1000; i++){
            soma += Math.max(img.get(i) - target.get(i),soma);
        }
        img.setDistance(soma);
    }
}
