package com.briup.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
	/**
	 * 服务网关 沙箱环境都是这个
	 */
	public static String serverUrl = "https://openapi.alipaydev.com/gateway.do";
	/**
	 * 应用id 后期可以替换成自己的id
	 */
	public static String appId = "2021000116693275";
	/**
	 * 用户私钥 后期替换成自己的私钥
	 */
	public static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDSi/VV+kvHi+46Z9Yh3W2SMFn8r/NjdvoUXv9NH23vN7Pm3adQ+CsWGCbXBlG2SaJe1582QePwJ1CKRHi61VvEBwPKo1K1qtCVecuHN0n2436WkpKlZvm0NhrxYQc6Z3GQ43nr+bIZcVRYxI+A1uGkh+f8wsoVztmU8m3VgWcqnjLXzqxcSmxCC0dh4TeYsWe9ZLwIwa2lIsLvut3d39nnx5ZMrrUeY2mGlLL/aQozGCqefek4hKlsOECGyk+jY1JeTyphC2sXymoBonRVOrWvDxW1BhpQ+r9Fy0gxtJa8b6/T/9ehwCde+e83/ufdg9AgC5eBWDhL50r4L8Natsl9AgMBAAECggEBAJRjebRv5Gqt72eQeTWC5s+KblGN/H6UgupKjapgRU28t3k1rM9/KHa47N7NIFfWC67GTvqhc7F1M+lPGruq1bMRspVliExrJ/jBTzVsPR/Y9AXRJbOXINPm8hQ+6yY5c6vG9s3ePKx72BN77RvD1mHsOw9EhcLa9zRnrAs22WwJrcfrZuGemmCZZUbKp6KdkhmuSiTaRGFD/60ga49FZCegyicn9h6tYz8cq1VIcudbQu3oJLjjxIwEtOvh+bCvm58cMwxbmDMJkaEMoLpK5cOSC+IRS2ryfpcka4VmmUHvEZ29mrsgIvaDv1C2qKHni/htJC1Jvd1PGp7fo4SvN6ECgYEA66AIC7uuWZJCHvNg1fs0+Q0sJbRPE2SXVGoqJ65apLtGX+V+3mySPQOLuvSdXJ2WBVCIx2kcfu8K/EnCKxpfrzXNXuM6KuxBThU+4AlpsqmLahitx+qba6+3gD6lFQFRwwgy8Di2gLqx4684CaZFxkXujCsuLZR/neX3saNZnbUCgYEA5MDF5Z6fboYbm6h1j2IY/cxm96YdAmAGDZhCaOR0KCNN+UxEPpFL95hpp4b/WtNHLCpGXqernuMVmFjnxCBSQVXsPJZn2M41J2o9Z3a4/ChLUsaZgP5vdSRoPoaIhbwzj0S1JuaHzVMKuAYRyfR89mowTnVw0WsYxjH4YmPrGakCgYEA3ycs94/ES+iM3qs5Ju9G+ChVi0/9JCy8daImUnZ6OlFzERdU1GqXBVn6WBGbhz9n+ZiQMeuGpWDXUqC4WAIeZN3bpuYlDMm7/6t3ZM8FX8Pa2ZyN2SyEDbTZYYfy6LXbLY7yTzgnADvQhgZIWDs1EdbhWbb7gQeG5ZAKyh4enZECgYB6kRu4A7zzMGIcji+nSu2PF3VYXiYO/rpfkGSM5VOjqf7+g7HRQHLO0FhUDg5GcQwiiug3kWlwccZBYemU+ah5H3u7nu83iI2Md+08wa0uVry9NnJLXokD4CUG03jVB1ks+6iAlmbPSh5lKcNgTWKjeZQ2hdCUNOkKUP4AYf83OQKBgC9RFa7HqvMy/bJe2698yhqOYvI80NxzS0Xsezfi0Y7gRBloaUMSWo6TWo+Fah1c3BK+gQLTK+rPgPwAq4GnwcNMMOhr6iMiwVESwL/VZN6WBMTRWdhaKJBSDB8czzWcFQD+VZEkPsE+zJaKVVJeuJIHIQSyo9RnM9467t2y9f7L";
	/**
	 * 发送数据的格式 目前只能为json 使用servlet去进行支付测试
	 */
	public static String format = "json";
	/**
	 * 设置字符集编码 目前只能为utf-8
	 */
	public static String charset = "utf-8";
	/**
	 * 支付宝公钥 后期替换成自己的支付宝公钥
	 */
	public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnstgkYZBQmNvtInfUxlAJeF1JWdUCDJJdhPH0BPPPLh03V/x/hgVCpd3whPeMZ9C5N8h4nN6+y8/HcB/7CifkzMRiR3YdXsvEqY5Fhf1M8xmM8eOWV8Vcv0DJ+0+0PMoh8xg9AXtn8hXU4+psXi+5kCINmgIXnaQ1OmtykFWZMBuvQoQvV5RYgx48Cvyj/7t/9bhlY9arBU82hqYwlvoN67yCsBccJw5qbgIn9TQ4k8W6oRyNrR91RiX07U1ncmHQqZvFZU7Zu6oDQh5KUJDB2oH/iMmSn5sYN028bLg76nKJBVNKCQ85ukWeP3tKo1B2nYwig7hBa3fVRxtlSDQ+QIDAQAB";
	/**
	 * 支付宝签名 目前是 RSA2
	 */
	public static String signType = "RSA2";
	/**
	 * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数， 必须外网可以正常访问
	 */
	public static String return_url = "http://localhost:8989/estore/user/PaySuccessServlet";

	public static AlipayClient getAlipayClient() {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.serverUrl, AlipayConfig.appId,
				AlipayConfig.privateKey, AlipayConfig.format, AlipayConfig.charset, AlipayConfig.publicKey,
				AlipayConfig.signType);
		return alipayClient;
	}
}
