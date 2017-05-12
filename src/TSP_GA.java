import java.util.ArrayList;


public class TSP_GA extends Thread {
	public static ArrayList<City> destinationCities = new ArrayList<City>();
	static Population popAns;
	public static void add(int x,int y){
		City city=new City(x,y);
		destinationCities.add(city);
        // Create and add our cities
	}
	public void run(){
		// Initialize population
        Population pop1 = new Population(50, true);
		// 进化到1000代就停止程序
        for (int i = 0; i < 1000; i++) {
            pop1 = GA.evolvePopulation(pop1);
        }
        System.out.println("work down");
        if(popAns.getFittest().getDistance()>pop1.getFittest().getDistance()){
        	popAns=pop1;
        }
	}
    public String get() throws InterruptedException{
    	//使用遗传算法进行计算,得到最短路径
        popAns=new Population(50, true);
    	Thread a1=new Thread(this);
    	Thread a2=new Thread(this);
    	a1.start();
    	a2.start();
        // 打印最终的结果
        a1.join();
        a2.join();
        System.out.println("main work down");
        String s=popAns.getFittest().toString()+"\"distance\":"+popAns.getFittest().getDistance();
        destinationCities.clear();
        return s;
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