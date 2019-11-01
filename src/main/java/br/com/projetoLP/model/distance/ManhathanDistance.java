package br.com.projetoLP.model.distance;

import br.com.projetoLP.model.image.AllImage;
import br.com.projetoLP.model.image.ProcessedImage;

public class ManhathanDistance implements Distance{

    public void calcularDistacia(ProcessedImage img, ProcessedImage target) {
        double soma = 0;
        for (int i = 0; i < 1000; i++){
            soma += Math.abs(img.get(i) - target.get(i));
        }
        img.setDistance(soma);
    }
}
