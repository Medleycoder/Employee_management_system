import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {


    JLabel lblUser;
    JLabel lblPass;

    TextField textUser;

    TextField textPass;

    JButton loginBtn;
    Login(){

        getContentPane().setBackground(Color.white);
        this.setLayout(null);

        lblUser = new JLabel("Username");
        lblUser.setBounds(40,30,100,30);
        lblPass = new JLabel("Password");
        lblPass.setBounds(40,90,100,30);


        textUser = new TextField();
        textUser.setBounds(150,30,200,30);
//        textUser.setText("Enter Username");
        textPass = new TextField();
//        textPass.setText("Enter Password");
        textPass.setBounds(150,90,200,30);


        loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(50,140,150,30);
        loginBtn.setBackground(Color.blue);
        loginBtn.setForeground(Color.white);
        loginBtn.addActionListener(this);

        ImageIcon login0 = new ImageIcon(ClassLoader.getSystemResource("image/second.jpg"));
        Image login1 =  login0.getImage().getScaledInstance(300,290,Image.SCALE_DEFAULT); //SETTING THE IMAGE SIze
        ImageIcon login = new ImageIcon(login1);
        JLabel imageLogin = new JLabel(login);
        imageLogin.setBounds(350,0,200,200);
        
        
        

        this.setSize(600,300);
        this.setLocation(450,200);
        this.setTitle("Employee Login");
        this.add(lblUser);
        this.add(textUser);
        this.add(lblPass);
        this.add(textPass);
        this.add(loginBtn);
        this.add(imageLogin);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try{

            if(e.getSource() == loginBtn){
                String username = textUser.getText();
                String password = textPass.getText();
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username ='" + username+"' and password ='" +password +"'";

                ResultSet rs = c.s.executeQuery(query); //Execute

                if(rs.next()){
                    setVisible(false); //Current class invisible when password is correct.
                    new HomeInside();
                }else{
                    JOptionPane.showMessageDialog(null,"INvalid crediential");
                    setVisible(true);
                }
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
