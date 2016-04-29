package edu.sjsu.digitalLibrary.prj.Recommendations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.impl.model.*;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class Recommendations {
	static Random rand = new Random();
	public List<Integer> getBookRecommendationsMahout(int userId, int number){
		List<Integer> lstBooks = new ArrayList<Integer>();
		try {
			//enterData();
			DataModel model = new GenericBooleanPrefDataModel( GenericBooleanPrefDataModel.toDataMap(new FileDataModel(new File("../userBookData.csv"))));
			
			UserSimilarity similarity = new TanimotoCoefficientSimilarity(model);
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(10, similarity, model);
			UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
			List<RecommendedItem> recommendations = recommender.recommend(userId, number);
			for (RecommendedItem recommendation : recommendations) {
				lstBooks.add(Integer.parseInt(recommendation.getItemID() + ""));
			  System.out.println(recommendation);
			}
			System.out.println("End with recommendations for userID: " + userId);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (TasteException e) {
			
			e.printStackTrace();
		}
		return lstBooks;
	}
}
