import java.util.ArrayList;
import java.util.Collections;

//每个Tour就是种群的一个  个体
public class Tour{

    // 保持所有城市的路径
    private ArrayList<City> tour = new ArrayList<City>();
    // Cache
    private double fitness = 0;
    private int distance = 0;
    
    // Constructs a blank tour
    public Tour(){
        for (int i = 0; i < TSP_GA.destinationCities.size(); i++) {
            tour.add(null);
        }
    }
    
    public Tour(ArrayList<City> tour){
        this.tour = tour;
    }

    //创建一个随机的 个体(路径)
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < TSP_GA.destinationCities.size(); cityIndex++) {
          setCity(cityIndex, TSP_GA.destinationCities.get(cityIndex));
        }
        // 打乱顺序
//        Collections.shuffle(tour);
    }

    // Gets a city from the tour
    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    // 讲城市加入到路径中
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }
    
    //Remove a City from the Tour
    public void removeCity(int tourPosition){
    	tour.remove(tourPosition);
    }
    
    // 距离小的 适应值较大
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    // 获取当前路径的总距离
	public int getDistance() {
		int tourDistance = 0;
		for (int cityIndex = 0; cityIndex < tourSize() - 1; cityIndex++) {
			// Get city we're travelling from
			City fromCity = getCity(cityIndex);
			// City we're travelling to
			City destinationCity=getCity(cityIndex+1);
			// Get the distance between the two cities
			tourDistance += fromCity.distanceTo(destinationCity);
		}
		distance = tourDistance;
		return distance;
	}
	
    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }
    
    // Check if the tour contains a city
    public boolean containsCity(City city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString="";
        for (int i = 0; i < tourSize(); i++) {
            geneString +="\"a"+(i+1)+"\":"+"{"+getCity(i)+"},";
        }
        return geneString;
    }
}