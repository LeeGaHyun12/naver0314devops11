package day0401;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex4_Network {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		//자기 컴퓨터의 IP와 컴퓨터이름 알아보자
		InetAddress local=InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 IP 주소: "+local.getHostAddress());
		System.out.println("내 컴퓨터 이름: "+local.getHostName());
		System.out.println("=".repeat(40));
		
		System.out.println("Naver의 서버컴퓨터 IP");
		InetAddress []naverInet=InetAddress.getAllByName("www.naver.com");
		for(InetAddress inet:naverInet)
			System.out.println("Naver IP: "+inet.getHostAddress());
		System.out.println("=".repeat(40));
		
	
		System.out.println("Google의 서버컴퓨터 IP");
		InetAddress []googleInet=InetAddress.getAllByName("www.google.com");
		for(InetAddress inet:googleInet)
			System.out.println("Google IP: "+inet.getHostAddress());
		System.out.println("=".repeat(40));
		
		System.out.println("Nate의 서버컴퓨터 IP");
		InetAddress []nateInet=InetAddress.getAllByName("www.nate.com");
		for(InetAddress inet:nateInet)
			System.out.println("Nate IP: "+inet.getHostAddress());
		System.out.println("=".repeat(40));
	}
}
