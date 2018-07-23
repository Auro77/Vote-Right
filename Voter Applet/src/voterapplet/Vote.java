package voterapplet;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Aurobind Iyer
 */

public class Vote extends Applet implements ActionListener
{
	Label name,age;
	TextField text,text1;
	Button b,b1;
	int d;
	String d1,part;
	CheckboxGroup party;
	Checkbox p1,p2,p3,p4;
	
	
	public void init()
	{
		setSize(800,650);
		name=new Label("ENTER YOUR NAME :");
		text=new TextField(10);
		age=new Label("ENTER YOUR AGE :");
		text1=new TextField();
		b=new Button("VOTE");
		b1=new Button("vote");
		
		party = new CheckboxGroup();
		p1=new Checkbox("CONGRESS",party,true);
		p2=new Checkbox("BJP",party,false);
		p3=new Checkbox("AAP",party,false);
		p4=new Checkbox("NCP",party,false);
		add(name);
		add(text);
		add(age);
		add(text1);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(b);
		b.addActionListener(this);
	}
	
	public void paint(Graphics g)
	{
		name.setBounds(20,20,150,100);
		text.setBounds(170,50, 150,30);
		age.setBounds(20,75, 150, 100);
		text1.setBounds(170,110,150,30);
		p1.setBounds(20,210,150,30);
		p2.setBounds(20,235,150,30);
		p3.setBounds(20,260,150,30);
		p4.setBounds(20,290,150,30);
		b.setBounds(20,320,150,30);
		
		g.drawString("PLEASE SELECT ONE OF THE PARTIES : ",20 ,190 );
		
		if(d1==null && d==0){
			g.setColor(Color.blue);
			g.drawString("PLEASE ENTER NAME AND AGE", 20, 380);
		    g.setColor(Color.black);
		}
		
		if(d1.length()==0 && d==0){
		    g.setColor(Color.blue);
			g.drawString("PLEASE ENTER VALID NAME AND AGE", 20, 400);
			g.setColor(Color.black);
		}
		else 
			if(d1.length()==0){
				g.setColor(Color.red);
				g.drawString("PLEASE ENTER VALID", 20,400);
				g.setColor(Color.black);
			}
			else
				if(d==0){
					g.setColor(Color.red);
					g.drawString("PLEASE ENTER VALID AGE", 20, 400);
					g.setColor(Color.black);
				}
				else 
					if(d<18){
						g.setColor(Color.red);	
						g.drawString("Sorry u cannot vote this time", 20, 420);
					}	
					else{
						g.drawString(d+" is permissible age so proceed", 20,400);
						g.drawString("Name : "+d1,20 ,420);
						g.drawString("Age : "+d,20 , 440);
						g.drawString("Voted for : "+part,20 ,460);
						g.drawString("Thank You for voting "+d1, 20, 480);
					}
	}
	
	public void actionPerformed(ActionEvent e){
		d=Integer.parseInt(text1.getText());
		d1=text.getText();
		part=party.getSelectedCheckbox().getLabel();
		repaint();
	}
	
}
