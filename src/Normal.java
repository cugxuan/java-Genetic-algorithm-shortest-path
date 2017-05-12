public class Normal {
	private static final int minSize = 99999;
	public static Tour getFittest(){
		//首先把第一个元素起点放在ans中
		Tour temp=new Tour();
		Tour ans=new Tour();
		temp.generateIndividual();
		
		int pos=0,minPosition=0;
		double min;
		City nowCity=temp.getCity(pos);
		ans.setCity(pos++, temp.getCity(0));
		temp.removeCity(pos-1);
		//不断找最近的加入路径中去
		while(temp.tourSize()>0){
			min=(double)minSize;
			for(int i=0;i<temp.tourSize();i++){
				if(nowCity.distanceTo(temp.getCity(i))<min){
					min=nowCity.distanceTo(temp.getCity(i));
					minPosition=i;
				}
			}
			ans.setCity(pos++,temp.getCity(minPosition));
			nowCity=temp.getCity(minPosition);
			temp.removeCity(minPosition);
		}
		return ans;
	}
}