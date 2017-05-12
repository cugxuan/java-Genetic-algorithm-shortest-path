import java.io.*;
import java.net.Socket;

//@WebServlet(name="Routing",urlPatterns={"/Routing"})
public class Routing{
	private PrintWriter writer;
	long startTime,endTime;
	int func,num;
	TSP_GA TSP=new TSP_GA(); 
	public void doPost(String line, Socket socket,String ConTentType) throws IOException {
		//将所有的点添加进城市中
        String [] fri = line.split("&");
        String[] pair = fri[0].split("=");
        int num=Integer.parseInt(pair[1]);
        pair = fri[1].split("=");
        int func=Integer.parseInt(pair[1]);
        int x,y;
        for (int i=2;i<num*2+1;i++) {
            pair = fri[i++].split("=");
            x=Integer.parseInt(pair[1]);
            pair = fri[i].split("=");
            y=Integer.parseInt(pair[1]);
            TSP.add(x, y);
        }
        
        String s="";
        if(func==1){
			//如果请求使用遗传算法
			startTime=System.currentTimeMillis();
			try {
				s = TSP.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //进行路径计算
			endTime=System.currentTimeMillis();		
			s="({\"status\":200,"+s+",\"time\":"+(endTime-startTime)+"})";
			}else if(func==2){
			//如果请求使用穷举算法
			startTime=System.currentTimeMillis();
			s=TSP.normalGet();
			endTime=System.currentTimeMillis();
			s="({\"status\":200,"+s+",\"time\":"+(endTime-startTime)+"})";
		}
        System.out.println(s);
        //开始传输数据到客户端
        PrintStream out=new PrintStream(socket.getOutputStream());
        out.println("HTTP/1.0 200 OK");//返回应答消息,并结束应答
        out.println(ConTentType);   //返回文件的格式
        out.println("Content-Length: " + s.length());// 返回内容字节数
        out.println();// 根据 HTTP 协议, 空行将结束头信息
        out.println(s);;
        out.close();
	}
    public void doGet (){

    }
}