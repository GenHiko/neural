package cn.ms.neural.moduler.neure;

import org.junit.Assert;
import org.junit.Test;

import cn.ms.neural.moduler.Moduler;
import cn.ms.neural.moduler.neure.core.NeureFactory;
import cn.ms.neural.moduler.neure.handler.INeureHandler;

public class NeureTest {

	@Test
	public void test_route() {
		INeure<String, String> neure=new NeureFactory<>();
		neure.notify(new Moduler<String, String>());
		String res=neure.neure("这是请求报文", new INeureHandler<String, String>() {
			public String route(String req, Object... args) throws Throwable {
				return "这是响应报文";
			}
			public String faulttolerant(String req, Object... args) {
				return null;
			}
			public void callback(String res, Object... args) throws Throwable {
			}
			public long breath(long nowTimes, long nowExpend, long maxRetryNum, Object... args) throws Throwable {
				return 0;
			}
			public void alarm(String req, Throwable t, Object... args) throws Throwable {
			}
		});
		
		Assert.assertEquals("这是响应报文", res);
	}
	
	
	@Test
	public void test_faulttolerant() {
		INeure<String, String> neure=new NeureFactory<>();
		try {
			neure.notify(new Moduler<String, String>());
			String res=neure.neure("这是请求报文", new INeureHandler<String, String>() {
				public String route(String req, Object... args) throws Throwable {
					throw new RuntimeException();
				}
				public String faulttolerant(String req, Object... args) {
					return "这是响应报文";
				}
				public void callback(String res, Object... args) throws Throwable {
				}
				public long breath(long nowTimes, long nowExpend, long maxRetryNum, Object... args) throws Throwable {
					return 0;
				}
				public void alarm(String req, Throwable t, Object... args) throws Throwable {
				}
			});
			
			Assert.assertEquals("这是响应报文", res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
