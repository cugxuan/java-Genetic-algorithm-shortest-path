import java.util.ArrayList;


public class TSP_GA {
	public static ArrayList<City> destinationCities = new ArrayList<City>();
	public static void add(int x,int y){
		City city=new City(x,y);
		destinationCities.add(city);
        // Create and add our cities
	}
    public static String get(){
//使用遗传算法进行计算,得到最短路径
        // Initialize population
        Population pop = new Population(50, true);
        // 进化到1000代就停止程序
        for (int i = 0; i < 1000; i++) {
            pop = GA.evolvePopulation(pop);
        }
        // 打印最终的结果
        destinationCities.clear();
        return pop.getFittest().toString()+"\"distance\":"+pop.getFittest().getDistance();
    }
    public  static String normalGet(){
    	//使用普通方法进行计算
    	//每次选择离当前点最近的一个.然后计算完成后即可得到所需要的路径
    	if(destinationCities.size()<2)
    		return "\"distance\":"+0;
    	String s=Normal.getFittest().toString()+"\"distance\":"+Normal.getFittest().getDistance();
    	destinationCities.clear();
    	return s;
    }
    public static void clean(){
    	destinationCities.clear();
    }
}