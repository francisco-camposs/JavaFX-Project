package br.com.projetoLP.model.image;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.HOGDescriptor;

public class HogExtract {

    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

    public void extract(String pathFile, ProcessedImage processedImage) {

        HOGDescriptor hog = new HOGDescriptor();
        Mat img = new Mat();
        MatOfFloat features = new MatOfFloat();
        img = Imgcodecs.imread(pathFile, Imgcodecs.IMREAD_GRAYSCALE);
        Imgproc.resize(img, img, new Size(64, 128), 0.5, 0.5, Imgproc.INTER_LINEAR);
        hog.compute(img, features);
        for (var i = 0; i < 1000; i++) {
            processedImage.addElement((double) features.toList().get(i));
        }
    }

};
