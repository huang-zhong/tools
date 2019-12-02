package com.xxoo.fast.jPanel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class IPJPanel extends JPanel{
	private JTextField innerIPText;
	private JTextField outerIPText;
	private JTextField textField_1;
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger("IPJPanel");
	private static String chinaz = "http://ip-api.com/json/";
	
	public IPJPanel() {
		JLabel lblip = new JLabel("\u672C\u673AIP");
		lblip.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblip_1 = new JLabel("\u5185\u7F51IP\uFF1A");
		
		innerIPText = new JTextField();
		innerIPText.setColumns(20);
		innerIPText.setBorder(new EmptyBorder(0,0,0,0));
		innerIPText.setOpaque(false);
		Optional<Inet4Address> option = getIpBySocket();
		Inet4Address ip4= option.get();
		String hostAddress = ip4.getHostAddress();
		innerIPText.setText(hostAddress);
		JLabel lblNewLabel = new JLabel("\u5916\u7F51IP\uFF1A");
		
		outerIPText = new JTextField();
		outerIPText.setColumns(20);
		outerIPText.setBorder(new EmptyBorder(0,0,0,0));
		outerIPText.setOpaque(false);
		String inputLine = getV4IP(getSelfIpRequestUrl());
		Map<String,String> info = getIpInfo(inputLine);
		outerIPText.setText(info.get("query"));
		
		JLabel lblip_2 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u8BE2\u7684IP\u5730\u5740");
		
		textField_1 = new JTextField();
		textField_1.setColumns(20);
		
		
		JLabel label = new JLabel("\u67E5\u8BE2\u7ED3\u679C");
		label.setFont(new Font("宋体", Font.BOLD, 12));
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new EmptyBorder(0,0,0,0));
		textArea.setOpaque(false);
		
		JButton btnMd = new JButton("查询");
		btnMd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.info("开始进行查询IP：");
				String sourceStr = textField_1.getText();
				if(StringUtils.isEmpty(sourceStr)) {
					JOptionPane.showInternalMessageDialog(IPJPanel.this, "请输入要查询的IP","查询IP失败",JOptionPane.ERROR_MESSAGE);
				}
				sourceStr = sourceStr.trim();
				String url = getCustomIpRequestUrl(sourceStr);
				log.info("查询的地址："+url);
				String inputLine = getV4IP(url);
				Map<String,String> info = getIpInfo(inputLine);
				String infomation = "IP："+info.get("query") + "\n"
									+"国家代码："+info.get("countryCode") + "\n"
									+"地址："+info.get("location") + "\n"
									+"isp："+info.get("isp") + "\n"
									+"timezone："+info.get("timezone") + "\n"
									+"经度："+info.get("lon") + "\n"
									+"维度："+info.get("lat");
				textArea.setText(infomation);
			}
		});
		
		
		GroupLayout gl_panel = new GroupLayout(this);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(outerIPText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblip)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblip_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(innerIPText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblip_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnMd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label))
					.addContainerGap(156, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblip)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblip_1)
						.addComponent(innerIPText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(outerIPText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblip_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		this.setLayout(gl_panel);
	}
	
	public static void main(String[] args) {
//		try {
//			List<Inet4Address> Inet4AddressList = getLocalIp4AddressFromNetworkInterface();
//			for (Iterator iterator = Inet4AddressList.iterator(); iterator.hasNext();) {
//				Inet4Address inet4Address = (Inet4Address) iterator.next();
//				String hostAddress = inet4Address.getHostAddress();
//				String hostName = inet4Address.getHostName();
//				System.out.println(hostName + " : " + hostAddress);
//			}
//		} catch (SocketException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Optional<Inet4Address> option = getIpBySocket();
//			Inet4Address ip4= option.get();
//			String hostName = ip4.getHostName();
//			String hostAddress = ip4.getHostAddress();
//			String address = ip4.getCanonicalHostName();
//			String d = ip4.getLocalHost().getHostAddress();
//			System.out.println(hostName + " : " + hostAddress + " : " + address+":"+d);
//		} catch (SocketException e) {
//			e.printStackTrace();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String ipv4 = getV4IP(chinaz);
		System.out.println(ipv4);
	}

	public static List<Inet4Address> getLocalIp4AddressFromNetworkInterface() throws SocketException {
	    List<Inet4Address> addresses = new ArrayList<>(1);
	    Enumeration e = NetworkInterface.getNetworkInterfaces();
	    if (e == null) {
	        return addresses;
	    }
	    while (e.hasMoreElements()) {
	        NetworkInterface n = (NetworkInterface) e.nextElement();
	        if (!isValidInterface(n)) {
	            continue;
	        }
	        Enumeration ee = n.getInetAddresses();
	        while (ee.hasMoreElements()) {
	            InetAddress i = (InetAddress) ee.nextElement();
	            if (isValidAddress(i)) {
	                addresses.add((Inet4Address) i);
	            }
	        }
	    }
	    return addresses;
	}

	/**
	 * 过滤回环网卡、点对点网卡、非活动网卡、虚拟网卡并要求网卡名字是eth或ens开头
	 *
	 * @param ni 网卡
	 * @return 如果满足要求则true，否则false
	 */
	private static boolean isValidInterface(NetworkInterface ni) throws SocketException {
	    return !ni.isLoopback() && !ni.isPointToPoint() && ni.isUp() && !ni.isVirtual()
	            && (ni.getName().startsWith("eth") || ni.getName().startsWith("ens"));
	}

	/**
	 * 判断是否是IPv4，并且内网地址并过滤回环地址.
	 */
	private static boolean isValidAddress(InetAddress address) {
	    return address instanceof Inet4Address && address.isSiteLocalAddress() && !address.isLoopbackAddress();
	}
	
	public static Optional<Inet4Address> getLocalIp4Address() throws SocketException {
	    final List<Inet4Address> ipByNi = getLocalIp4AddressFromNetworkInterface();
	    if (ipByNi.isEmpty() || ipByNi.size() > 1) {
	        final Optional<Inet4Address> ipBySocketOpt = getIpBySocket();
	        if (ipBySocketOpt.isPresent()) {
	            return ipBySocketOpt;
	        } else {
	            return ipByNi.isEmpty() ? Optional.empty() : Optional.of(ipByNi.get(0));
	        }
	    }
	    return Optional.of(ipByNi.get(0));
	}
	
	
	private static Optional<Inet4Address> getIpBySocket(){
	    try (final DatagramSocket socket = new DatagramSocket()) {
	        socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
	        if (socket.getLocalAddress() instanceof Inet4Address) {
	            return Optional.of((Inet4Address) socket.getLocalAddress());
	        }
	    } catch (UnknownHostException e) {
	        throw new RuntimeException(e);
	    } catch (SocketException e1) {
			e1.printStackTrace();
		}
	    return Optional.empty();
	}
	
	
	
	public static String getV4IP(String chinaz){
		String ip = "";
//		String chinaz = "http://ip.chinaz.com";
		//"http://ip.taobao.com/service/getIpInfo2.php";
		
		StringBuilder inputLine = new StringBuilder();
		String read = "";
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedReader in = null;
		try {
			url = new URL(chinaz);
			urlConnection = (HttpURLConnection) url.openConnection();
		    in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
			while((read=in.readLine())!=null){
				inputLine.append(read+"\r\n");
			}
			//System.out.println(inputLine.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		log.info(inputLine.toString());
		
//		Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
//		Matcher m = p.matcher(inputLine.toString());
//		if(m.find()){
//			String ipstr = m.group(1);
//			ip = ipstr;
//			//System.out.println(ipstr);
//		}
		return inputLine.toString();
	}	
	
	public Map<String,String> getIpInfo(String inputLine){
		Map<String,String> ipInfoMap = new HashMap<String,String>();
		if(StringUtils.isNoneBlank(inputLine)) {
			JSONObject object =JSON.parseObject(inputLine.toString());
			String status = (String) object.get("status");
			String country = (String)object.get("country");
			String countryCode = (String)object.get("countryCode");
			String region = (String)object.get("region");
			String regionName = (String)object.get("regionName");
			String city = (String)object.get("city");
			String zip = (String)object.get("zip");
			BigDecimal lat = (BigDecimal)object.get("lat");
			BigDecimal lon = (BigDecimal)object.get("lon");
			String timezone = (String)object.get("timezone");
			String isp = (String)object.get("isp");
			String org = (String)object.get("org");
			String as = (String)object.get("as");
			String query = (String)object.get("query");
			log.info("query = " + query);
			ipInfoMap.put("location", country + " " + regionName + " " + city);
			ipInfoMap.put("lat", lat.toString());
			ipInfoMap.put("lon", lon.toString());
			ipInfoMap.put("isp", isp);
			ipInfoMap.put("countryCode", countryCode);
			ipInfoMap.put("timezone", timezone);
			ipInfoMap.put("query", query);
		}
		return ipInfoMap;
	}
	
	public String getSelfIpRequestUrl() {
		return chinaz + "?lang=zh-CN";
	}
	
	public String getCustomIpRequestUrl(String ip) {
		return chinaz + ip + "?lang=zh-CN";
	}
}
