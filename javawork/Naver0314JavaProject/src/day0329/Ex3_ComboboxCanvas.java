package day0329;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex3_ComboboxCanvas extends JFrame{

	JComboBox<String> combo;
	String []comboLabel= {"선","원","사각형","이미지"};
			
	}
	class Draw extends Canvas{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
		}
	}
	public Ex3_ComboboxCanvas(String title) {
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
		JPanel p=new JPanel();
		combo=new JComboBox<String>(comboLabel);
		p.add(combo);
		this.add("North",p);
		
		this.add("Center",draw);;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3_ComboboxCanvas a=new Ex3_ComboboxCanvas("기본창");
		
	}

}
