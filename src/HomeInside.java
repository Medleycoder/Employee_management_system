import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeInside extends JFrame implements ActionListener {

     ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("image/home.jpg"));
    Image home1 =  image.getImage().getScaledInstance(1100,650,Image.SCALE_DEFAULT);
    ImageIcon home = new ImageIcon(home1);
    JLabel imageHome = new JLabel(home);
    JLabel heading = new JLabel("Employee Management Screen");

    JButton addBtn;
    JButton viewBtn;
    JButton updateBtn;
    JButton removeBtn;

    HomeInside(){

        addBtn = new JButton("ADD");
        addBtn.setBounds(620,70,100,30);
        addBtn.setBackground(Color.BLACK);
        addBtn.setForeground(Color.WHITE);
        addBtn.setFocusable(false);
        addBtn.addActionListener(this);

        viewBtn = new JButton("VIEW");
        viewBtn.setBounds(750,70,100,30);
        viewBtn.setBackground(Color.BLACK);
        viewBtn.setForeground(Color.WHITE);
        viewBtn.setFocusable(false);
        viewBtn.addActionListener(this);

        updateBtn = new JButton("UPDATE");
        updateBtn.setBounds(620,120,100,30);
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFocusable(false);
        updateBtn.addActionListener(this);

        removeBtn = new JButton("REMOVE");
        removeBtn.setBounds(750,120,100,30);
        removeBtn.setBackground(Color.BLACK);
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusable(false);
        removeBtn.addActionListener(this);


        heading.setBounds(520,20,450,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        heading.setForeground(Color.black);


        imageHome.setBounds(0,0,1050,500);

        this.setSize(1050,500);
        this.setLocation(300,50);
        this.setTitle("Home Page");


        this.add(addBtn);
        this.add(viewBtn);
        this.add(updateBtn);
        this.add(removeBtn);
        this.add(heading);
        this.add(imageHome);
        this.setLayout(null);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addBtn){

            this.setVisible(false);
            new AddEmployee();
        } else if (e.getSource() == viewBtn) {

            this.setVisible(false);
            new ViewEmployee();
        } else if (e.getSource() == updateBtn) {
            setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }

    }
    public static void main(String[] args) {
        new HomeInside();
    }
}
