package javasm.java7;

/*
 * 接口的应用：代理模式（Proxy）
 *
 */
public class StaticProxyTest {

	public static void main(String[] args) {
		Star s = new Proxy(new RealStar());
		s.confer();
		s.signContract();
		s.bookTicket();
		s.sing();
		s.collectMoney();
	}
}

interface Star {
	void confer();// 面谈

	void signContract();// 签合同

	void bookTicket();// 订票

	void sing();// 唱歌

	void collectMoney();// 收钱
}

//被代理类
class RealStar implements Star {

	public void confer() {
	}

	public void signContract() {
	}

	public void bookTicket() {
	}

	public void sing() {
		System.out.println("明星：歌唱~~~");
	}

	public void collectMoney() {
	}
}

//代理类
class Proxy implements Star {
	private Star real;

	public Proxy(Star real) {
		this.real = real;
	}

	public void confer() {
		System.out.println("经纪人面谈");
	}

	public void signContract() {
		System.out.println("经纪人签合同");
	}

	public void bookTicket() {
		System.out.println("经纪人订票");
	}

	public void sing() {
		real.sing();
	}

	public void collectMoney() {
		System.out.println("经纪人收钱");
	}
}



class ProxyTest {
	public static void main(String[] args) {

		Server server=new Server();
		ProxyServer proxyServer=new ProxyServer(server); 	//代理类代替接口
		proxyServer.browse();
	}
}

interface NetWork{

	public void browse();

}

//被代理类
class Server implements NetWork{

	@Override
	public void browse() {
		System.out.println("真实的服务器来访问网络");
	}

}

//代理类
class ProxyServer implements NetWork{

	private NetWork work;

	public ProxyServer(NetWork work){
		this.work=work;
	}

	public void check(){
		System.out.println("联网之前的检查工作");
	}

	@Override
	public void browse() {
		check();

		work.browse();
	}

}