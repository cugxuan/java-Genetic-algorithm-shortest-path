import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

//@WebServlet(name="Routing",urlPatterns={"/Routing"})
@WebServlet("/Routing")
public class Routing extends HttpServlet {
	private PrintWriter writer;
	long startTime,endTime;
	int func;
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		func=Integer.parseInt(req.getParameter("fun"));
		if(func==1){
			//如果请求使用遗传算法
			startTime=System.currentTimeMillis();
			String s=TSP_GA.get();   //进行路径计算
			endTime=System.currentTimeMillis();		
			s="({\"status\":200,"+s+",\"time\":"+(endTime-startTime)+"})";
			res.setContentType("application/json;charset=UTF-8");
			writer = res.getWriter();
			writer.print(s);
			writer.flush();
			System.out.println(s);
		}else if(func==2){
			//如果请求使用穷举算法
//			System.out.println(TSP_GA.normalGet());
			startTime=System.currentTimeMillis();
			String s=TSP_GA.normalGet();
			endTime=System.currentTimeMillis();
			s="({\"status\":200,"+s+",\"time\":"+(endTime-startTime)+"})";
			res.setContentType("application/json;charset=UTF-8");
			writer = res.getWriter();
			writer.print(s);
			writer.flush();
			System.out.println(s);
		}else if(func==3){
			//进行数据的清除
			TSP_GA.clean();
		}
	}
    public void doPost (HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException{
        int x=Integer.parseInt(req.getParameter("x"));
        int y=Integer.parseInt(req.getParameter("y"));
        TSP_GA.add(x,y);
     }
}