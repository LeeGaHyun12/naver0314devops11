package day0329;

import java.awt.Color;

import javax.swing.JFrame;

public class Ex4_SwingTable extends JFrame{
	public Ex4_SwingTable(String title) {
		super(title);
		this.setLocation(100,100);//시작위치
		this.setSize(300,300);//창크기 
		//this.getContentPane().setBackground(new Color(212,160,186)); //배경색 변경
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임 종료 
		this.initDesign();//각종 컴포넌트 생성
		this.setVisible(true);
	}

	private void initDesign() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4_SwingTable a=new Ex4_SwingTable("기본창");
		

}
}
