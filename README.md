# java-routing
在网页点击然后服务器使用遗传算法计算后返回最短路径

使用Java Servlet
使用了D3可视化库进行画图。
使用原生ajax进行JavaScript前端和后台Java Servlet的交互。


***
src文件中为Java的源文件
WebContent为网页内容的文件夹

commit:
1.完成了基本的内容，贪心算法并不正确，准备修改提交方法，现在方法，每次使用POST提交一个点，然后使用
GET获得返回内容，~~打算修改成：保存所有点然后使用POST方法一次提交。~~
<font color=red>已经修改，使用字符串保存，然后一次上传，也可以对多客户端的情况进行处理，不会干扰</font>
