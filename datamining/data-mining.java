// Describes how we take an input CSV file, preprocess it and then predict for missing values of energy using a pre-made classifier
// The file paths for the input csv file and the classifier are hard-coded for Shivan's machine; once we get the web side of it running, we'll change this (obviously)

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import weka.core.converters.*;
import weka.classifiers.misc.SerializedClassifier;
import weka.core.Instances;



public class data-mining {
	
	public static void main(String[] args) throws IOException, Exception{
		System.out.println(learn("/home/max/Desktop/codejam/simple_input.csv"));
	}

	public static String learn(String string) throws Exception, IOException {
		//Current location:
		File directory = new File (".");
		
		CSVLoader loader = new CSVLoader();
		// Preprocessing
		loader.setSource(new File(string));
		loader.setDateAttributes("1");
		loader.setDateFormat("yyyy-MM-dd'T'HH:mm-ss':00'");
		loader.setMissingValue("null");

		Instances unlabeled = loader.getDataSet();
		if (loader.getDataSet().classIndex() == -1) {
			unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
		}

		Instances labeled = new Instances(unlabeled);
		
		// Load the classifier. We trained this on the data set provided using the M5P algorithm
		SerializedClassifier my_classifier = new SerializedClassifier();
		my_classifier.setModelFile(new File("C:/Code Jam 2013/test3.model"));

		// label instances
		for (int i = 0; i < unlabeled.numInstances(); i++) {
			double clsLabel = my_classifier.classifyInstance(unlabeled.instance(i));
			labeled.instance(i).setClassValue(clsLabel);
		}
		// save labeled data
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(directory.getAbsolutePath() + "out.cvs"));
		writer.write(labeled.toString());
		writer.newLine();
		writer.flush();
		writer.close();
		return directory.getAbsolutePath()+"out.csv";
	}
}
