//package test.testHttpclient;
//
//import java.io.IOException;
//import java.io.InterruptedIOException;
//import java.net.SocketTimeoutException;
//import java.net.UnknownHostException;
//import java.nio.charset.Charset;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLException;
//import javax.net.ssl.SSLHandshakeException;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpEntityEnclosingRequest;
//import org.apache.http.HttpRequest;
//import org.apache.http.NoHttpResponseException;
//import org.apache.http.ParseException;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpRequestRetryHandler;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.protocol.HttpClientContext;
//import org.apache.http.config.Registry;
//import org.apache.http.config.RegistryBuilder;
//import org.apache.http.config.SocketConfig;
//import org.apache.http.conn.ConnectTimeoutException;
//import org.apache.http.conn.routing.HttpRoute;
//import org.apache.http.conn.socket.ConnectionSocketFactory;
//import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
//import org.apache.http.conn.socket.PlainConnectionSocketFactory;
//import org.apache.http.conn.ssl.NoopHostnameVerifier;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.pool.PoolStats;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.protocol.HttpContext;
//import org.apache.http.util.EntityUtils;
//import org.apache.log4j.Logger;
//
//public class HttpClientUtil {
//	private static Logger logger = Logger.getLogger(HttpClientUtil.class);
//	private final static int CONNECT_TIMEOUT = 4000;// ���ӳ�ʱ����
//	private final static int SOCKET_TIMEOUT = 10000;// ���䳬ʱ����
//	private final static int REQUESTCONNECT_TIMEOUT = 3000;// ��ȡ����ʱ����
//	private final static int CONNECT_TOTAL = 200;// ���������
//	private final static int CONNECT_ROUTE = 20;// ÿ��·�ɻ�����������
//	private final static String ENCODE_CHARSET = "utf-8";// ��Ӧ���Ľ����ַ���
//	private final static String RESP_CONTENT = "ͨ��ʧ��";
//	private static PoolingHttpClientConnectionManager connManager = null;
//	private static CloseableHttpClient httpClient = null;
//	static {
//		ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
//		LayeredConnectionSocketFactory sslsf = createSSLConnSocketFactory();
//		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
//				.register("http", plainsf).register("https", sslsf).build();
//		connManager = new PoolingHttpClientConnectionManager(registry);
//		// ��������������ӵ�200
//		connManager.setMaxTotal(CONNECT_TOTAL);
//		// ��ÿ��·�ɻ������������ӵ�20
//		connManager.setDefaultMaxPerRoute(CONNECT_ROUTE);
//		// ���ÿ������ӹ���ʱ��,���ÿ�������ʱ���ȼ���Ƿ����ʱ�䳬�����ʱ�䣬����������ͷ�socket���½���
//		connManager.setValidateAfterInactivity(30000);
//		// ����socket��ʱʱ��
//		SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(SOCKET_TIMEOUT).build();
//		connManager.setDefaultSocketConfig(socketConfig);
//		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(REQUESTCONNECT_TIMEOUT)
//				.setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
//		HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
//			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
//				if (executionCount >= 3) {// ����Ѿ�������3�Σ��ͷ���
//					return false;
//				}
//				if (exception instanceof NoHttpResponseException) {// ������������������ӣ���ô������
//					return true;
//				}
//				if (exception instanceof SSLHandshakeException) {// ��Ҫ����SSL�����쳣
//					return false;
//				}
//				if (exception instanceof InterruptedIOException) {// ��ʱ
//					return true;
//				}
//				if (exception instanceof UnknownHostException) {// Ŀ����������ɴ�
//					return false;
//				}
//				if (exception instanceof ConnectTimeoutException) {// ���ӱ��ܾ�
//					return false;
//				}
//				if (exception instanceof SSLException) {// ssl�����쳣
//					return false;
//				}
//				HttpClientContext clientContext = HttpClientContext.adapt(context);
//				HttpRequest request = clientContext.getRequest();
//				// ����������ݵȵģ����ٴγ���
//				if (!(request instanceof HttpEntityEnclosingRequest)) {
//					return true;
//				}
//				return false;
//			}
//		};
//		httpClient = HttpClients.custom().setConnectionManager(connManager).setDefaultRequestConfig(requestConfig)
//				.setRetryHandler(httpRequestRetryHandler).build();
//		if (connManager != null && connManager.getTotalStats() != null) {
//			logger.info("now client pool " + connManager.getTotalStats().toString());
//		}
//	}
//
//	/**
//	 * ����HTTP_GET����
//	 *
//	 * @see 1)�÷������Զ��ر�����,�ͷ���Դ
//	 * @see 2)���������������ӺͶ�ȡ��ʱʱ��,��λΪ����,��ʱ���������쳣ʱ�������Զ�����"ͨ��ʧ��"�ַ���
//	 * @see 3)�������������ʱ,�����Կ�ֱ�Ӵ�������,HttpClient���Զ����뷢��Server,Ӧ��ʱӦ����ʵ��Ч����
//	 *      ������ǰ�Ƿ�ת��
//	 * @see 4)�÷������Զ���ȡ����Ӧ��Ϣͷ��[Content-Type:text/html; charset=GBK]��charsetֵ��Ϊ��Ӧ���ĵ�
//	 *      �����ַ���
//	 * @see ����Ӧ��Ϣͷ����Content-Type����,���ʹ��HttpClient�ڲ�Ĭ�ϵ�ISO-8859-1��Ϊ��Ӧ���ĵĽ����ַ�
//	 *      ��
//	 * @param requestURL
//	 *            �����ַ(������)
//	 * @return Զ��������Ӧ����
//	 */
//	public static String sendGetRequest(String reqURL, String param) {
//		if (null != param) {
//			reqURL += "?" + param;
//		}
//		String respContent = RESP_CONTENT; // ��Ӧ����
//		// reqURL = URLDecoder.decode(reqURL, ENCODE_CHARSET);
//		HttpGet httpget = new HttpGet(reqURL);
//		CloseableHttpResponse response = null;
//		try {
//			response = httpClient.execute(httpget, HttpClientContext.create()); // ִ��GET����
//			HttpEntity entity = response.getEntity(); // ��ȡ��Ӧʵ��
//			if (null != entity) {
//				Charset respCharset = ContentType.getOrDefault(entity).getCharset();
//				respContent = EntityUtils.toString(entity, respCharset);
//				EntityUtils.consume(entity);
//			}
//		} catch (ConnectTimeoutException cte) {
//			logger.error("����ͨ��[" + reqURL + "]ʱ���ӳ�ʱ,��ջ�켣����", cte);
//		} catch (SocketTimeoutException ste) {
//			logger.error("����ͨ��[" + reqURL + "]ʱ��ȡ��ʱ,��ջ�켣����", ste);
//		} catch (ClientProtocolException cpe) {
//			// ���쳣ͨ����Э�������:���繹��HttpGet����ʱ����Э�鲻��(��'http'д��'htp')or��Ӧ���ݲ�����HTTPЭ��Ҫ���
//			logger.error("����ͨ��[" + reqURL + "]ʱЭ���쳣,��ջ�켣����", cpe);
//		} catch (ParseException pe) {
//			logger.error("����ͨ��[" + reqURL + "]ʱ�����쳣,��ջ�켣����", pe);
//		} catch (IOException ioe) {
//			// ���쳣ͨ��������ԭ�������,��HTTP������δ������
//			logger.error("����ͨ��[" + reqURL + "]ʱ�����쳣,��ջ�켣����", ioe);
//		} catch (Exception e) {
//			logger.error("����ͨ��[" + reqURL + "]ʱż���쳣,��ջ�켣����", e);
//		} finally {
//			try {
//				if (response != null)
//					response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			if (httpget != null) {
//				httpget.releaseConnection();
//			}
//		}
//		return respContent;
//	}
//
//	public static String sendPostRequest(String reqURL, String param) {
//		return sendPostRequest(reqURL, param, "");
//	}
//
//	/**
//	 * ����HTTP_POST���� type: Ĭ���Ǳ�����
//	 *
//	 * @see 1)�÷��������Զ����κθ�ʽ�����ݵ�HTTP��������
//	 * @see 2)�÷������Զ��ر�����,�ͷ���Դ
//	 * @see 3)���������������ӺͶ�ȡ��ʱʱ��,��λΪ����,��ʱ���������쳣ʱ�������Զ�����"ͨ��ʧ��"�ַ���
//	 * @see 4)������������ĵ������ַ�ʱ,��ֱ�Ӵ��뱾����,��ָ��������ַ���encodeCharset����,�����ڲ�����
//	 *      ������ת��
//	 * @see 5)�÷����ڽ�����Ӧ����ʱ�����õı���,ȡ����Ӧ��Ϣͷ�е�[Content-Type:text/html; charset=GBK]��
//	 *      charsetֵ
//	 * @see ����Ӧ��Ϣͷ��δָ��Content-Type����,���ʹ��HttpClient�ڲ�Ĭ�ϵ�ISO-8859-1
//	 * @param reqURL
//	 *            �����ַ
//	 * @param reqData
//	 *            �������,���ж��������Ӧƴ��Ϊparam11=value11&22=value22&33=value33����ʽ
//	 * @param encodeCharset
//	 *            �����ַ���,������������ʱ��֮,�˲���Ϊ������(����Ϊ""��null)
//	 * @return Զ��������Ӧ����
//	 */
//	public static String sendPostRequest(String reqURL, String param, String type) {
//		String result = RESP_CONTENT;
//		// ��������ʹ��䳬ʱʱ��
//		HttpPost httpPost = new HttpPost(reqURL);
//		// ����п��ܻᵼ�·���˽��ղ���POST��ȥ�Ĳ���,����������Tomcat6.0.36�е�Servlet,���������ֹ�ָ��CONTENT_TYPEͷ��Ϣ
//		if (type != null && type.length() > 0) {
//			httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json; charset=" + ENCODE_CHARSET);
//		} else {
//			httpPost.setHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=" + ENCODE_CHARSET);
//		}
//		CloseableHttpResponse response = null;
//		try {
//			if (param != null) {
//				StringEntity entity = new StringEntity(param, ENCODE_CHARSET);
//				httpPost.setEntity(entity);
//			}
//			logger.info("��ʼִ������" + reqURL);
//			// reqURL = URLDecoder.decode(reqURL, ENCODE_CHARSET);
//			response = httpClient.execute(httpPost, HttpClientContext.create());
//			HttpEntity entity = response.getEntity();
//			if (null != entity) {
//				result = EntityUtils.toString(entity, ContentType.getOrDefault(entity).getCharset());
//				logger.info("ִ��������ϣ�" + result);
//				EntityUtils.consume(entity);
//			}
//		} catch (ConnectTimeoutException cte) {
//			logger.error("����ͨ��[" + reqURL + "]ʱ���ӳ�ʱ,��ջ�켣����", cte);
//		} catch (SocketTimeoutException ste) {
//			logger.error("����ͨ��[" + reqURL + "]ʱ��ȡ��ʱ,��ջ�켣����", ste);
//		} catch (ClientProtocolException cpe) {
//			logger.error("����ͨ��[" + reqURL + "]ʱЭ���쳣,��ջ�켣����", cpe);
//		} catch (ParseException pe) {
//			logger.error("����ͨ��[" + reqURL + "]ʱ�����쳣,��ջ�켣����", pe);
//		} catch (IOException ioe) {
//			logger.error("����ͨ��[" + reqURL + "]ʱ�����쳣,��ջ�켣����", ioe);
//		} catch (Exception e) {
//			logger.error("����ͨ��[" + reqURL + "]ʱż���쳣,��ջ�켣����", e);
//		} finally {
//			try {
//				if (response != null)
//					response.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			if (httpPost != null) {
//				httpPost.releaseConnection();
//			}
//		}
//		return result;
//	}
//
//	// SSL��socket��������
//	private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
//		SSLConnectionSocketFactory sslsf = null;
//		// ����TrustManager() ���ڽ��javax.net.ssl.SSLPeerUnverifiedException: peer not authenticated
//		X509TrustManager trustManager = new X509TrustManager() {
//			@Override
//			public X509Certificate[] getAcceptedIssuers() {
//				return null;
//			}
//
//			@Override
//			public void checkClientTrusted(X509Certificate[] arg0, String authType) throws CertificateException {
//				// TODO Auto-generated method stub
//			}
//
//			@Override
//			public void checkServerTrusted(X509Certificate[] arg0, String authType) throws CertificateException {
//				// TODO Auto-generated method stub
//			}
//		};
//		SSLContext sslContext;
//		try {
//			sslContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
//			sslContext.init(null, new TrustManager[] { (TrustManager) trustManager }, null);
//			// ����SSLSocketFactory , // ��У������ ,ȡ����ǰ��֤����
//			sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sslsf;
//	}
//
//	public static Map<HttpRoute, PoolStats> getConnManagerStats() {
//		if (connManager != null) {
//			Set<HttpRoute> routeSet = connManager.getRoutes();
//			if (routeSet != null && !routeSet.isEmpty()) {
//				Map<HttpRoute, PoolStats> routeStatsMap = new HashMap<HttpRoute, PoolStats>();
//				for (HttpRoute route : routeSet) {
//					PoolStats stats = connManager.getStats(route);
//					routeStatsMap.put(route, stats);
//				}
//				return routeStatsMap;
//			}
//		}
//		return null;
//	}
//
//	public static PoolStats getConnManagerTotalStats() {
//		if (connManager != null) {
//			return connManager.getTotalStats();
//		}
//		return null;
//	}
//
//	/**
//	 * �ر�ϵͳʱ�ر�httpClient
//	 */
//	public static void releaseHttpClient() {
//		try {
//			httpClient.close();
//		} catch (IOException e) {
//			logger.error("�ر�httpClient�쳣" + e);
//		} finally {
//			if (connManager != null) {
//				connManager.shutdown();
//			}
//		}
//	}
//}