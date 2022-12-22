import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {

    JButton clickFront;
    JLabel label;
    Splash(){

        getContentPane().setBackground(Color.WHITE); //GET ACCESS OF FULL PANEL

        label = new JLabel("Employee Management System");
        label.setBounds(180,20,1200,75);
        label.setFont(new Font("serif",Font.BOLD,60));
        label.setForeground(Color.red);

        ImageIcon front0 = new ImageIcon(ClassLoader.getSystemResource("image/front.jpg"));
        Image front1 =  front0.getImage().getScaledInstance(1100,650,Image.SCALE_DEFAULT);
        ImageIcon front = new ImageIcon(front1);
        JLabel imageFront = new JLabel(front);
        imageFront.setBounds(50,100,1050,500);


        clickFront = new JButton("CLICK HERE TO CONTINUE");

        clickFront.setBounds(400,500,400,50);
        clickFront.setBackground(Color.black);
        clickFront.setForeground(Color.WHITE);
        clickFront.setFocusable(false);
        clickFront.addActionListener(this);


//        clickFront.setFocusable(false);

    this.setSize(1170,650);
    this.setLocation(300,50);
    this.setTitle("Employee Management System");

    this.add(label);
    this.add(imageFront);
    this.add(clickFront);
    this.setLayout(null);


    this.setVisible(true);


        while(true){
            label.setVisible(true);
            clickFront.setFocusable(true);

            try{
                Thread.sleep(500);
            }catch(Exception e){

            }
            label.setVisible(false);
            clickFront.setFocusable(false);

            try{
                Thread.sleep(500);
            }catch(Exception e){

            }

        }
    }





    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == clickFront){
            setVisible(false);
            new Login();
        }
    }


}
