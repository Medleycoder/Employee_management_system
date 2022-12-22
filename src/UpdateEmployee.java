import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmployee extends JFrame implements ActionListener {


    JButton submit;
    JButton back;
    ImageIcon addImage0 = new ImageIcon(ClassLoader.getSystemResource("image/add_employee.jpg"));
    Image addImage1 =  addImage0.getImage().getScaledInstance(1100,650,Image.SCALE_DEFAULT);
    ImageIcon addImage = new ImageIcon(addImage1);
    JLabel imageFront = new JLabel(addImage);

    JLabel label;

    JLabel labelName;

    TextField textName;

    JLabel labelFatherName;

    TextField textFatherName;
    JLabel labelDob;

    TextField textDob;
    JLabel labelSalary;

    TextField textSalary;
    JLabel labelEmail;

    TextField textEmail;
    JLabel labelEdu;

    TextField textEdu;
    JLabel labelDesign;

    TextField textDesign;
    JLabel labelAadhar;

    TextField textAadhar;
//    JLabel labelEmployeeId;
//
//    JLabel textEmplId;
    Random num = new Random();

    int ran = num.nextInt(999999);

    JComboBox boxSelection;

    String empId;
    UpdateEmployee(String empId) {

        this.empId = empId;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        //HEADING
        label = new JLabel("UPDATE EMPLOYEE'S");
        label.setBounds(300, 20, 1200, 75);
        label.setFont(new Font("serif", Font.BOLD, 60));
        label.setForeground(Color.red);

        //LABELS

        labelName = new JLabel("Name");
        labelName.setBounds(40, 130, 100, 25);
        labelName.setFont(new Font("serif", Font.BOLD, 20));

        textName = new TextField();
        textName.setBounds(120, 130, 150, 25);
//        textName.setBounds(50,130,400,25);

        labelFatherName = new JLabel("Father's Name");
        labelFatherName.setBounds(540, 130, 130, 25);
        labelFatherName.setFont(new Font("serif", Font.BOLD, 20));

        textFatherName = new TextField();
        textFatherName.setBounds(720, 130, 180, 25);

        labelDob = new JLabel("Date of Birth");
        labelDob.setBounds(40, 200, 200, 25);
        labelDob.setFont(new Font("serif", Font.BOLD, 20));

        //JDATECHOOSEPACKAGE
        textDob = new TextField();
        textDob.setBounds(160, 200, 150, 25);

        labelSalary = new JLabel("Salary");
        labelSalary.setBounds(540, 200, 200, 25);
        labelSalary.setFont(new Font("serif", Font.BOLD, 20));

        textSalary = new TextField();
        textSalary.setBounds(720, 200, 180, 25);

        labelEmail = new JLabel("Email");
        labelEmail.setBounds(40, 270, 200, 25);
        labelEmail.setFont(new Font("serif", Font.BOLD, 20));

        textEmail = new TextField();
        textEmail.setBounds(160, 270, 200, 25);


        labelEdu = new JLabel("Highest Education");
        labelEdu.setBounds(540, 270, 200, 25);
        labelEdu.setFont(new Font("serif", Font.BOLD, 20));

        //UL LI IN HTML
        String education[] = {"Bsc", "BTech", "BCom", "MCom", "None", "Other"};
        boxSelection = new JComboBox(education);
        boxSelection.setBounds(720, 270, 180, 25);

        textEdu = new TextField();
        textEdu.setBounds(720,270,180,25);

        labelDesign = new JLabel("Designation");
        labelDesign.setBounds(40, 340, 200, 25);
        labelDesign.setFont(new Font("serif", Font.BOLD, 20));

        textDesign = new TextField();
        textDesign.setBounds(160, 340, 200, 25);

        labelAadhar = new JLabel("Aadhar Number");
        labelAadhar.setBounds(540, 340, 200, 25);
        labelAadhar.setFont(new Font("serif", Font.BOLD, 20));

        textAadhar = new TextField();
        textAadhar.setBounds(720, 340, 180, 25);

//


        //LABELS ENDS

        //BUTTON
        submit = new JButton("Submit");
        submit.setBounds(160, 540, 200, 25);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);

        submit.addActionListener(this);


        back = new JButton("BACK");
        back.setBounds(400,540,200,25);
        back.setBackground(Color.red);
        back.setForeground(Color.white);

        back.addActionListener(this);


//        imageFront.setBounds(0,100,1170,650); //FOR IMAGE BACKGROUND


        this.setSize(1170, 750);
        this.setLocation(280, 50);
        this.setTitle("ADD EMPLOYEE");
//
//        this.add(textEmplId);
//        this.add(labelEmployeeId);
        this.add(textAadhar);
        this.add(labelAadhar);
        this.add(textDesign);
        this.add(labelDesign);
//        this.add(textEdu);
        this.add(boxSelection);
        this.add(labelEdu);
        this.add(textEmail);
        this.add(labelEmail);
        this.add(textSalary);
        this.add(labelSalary);
        this.add(textDob);
        this.add(labelDob);
        this.add(textFatherName);
        this.add(labelFatherName);
        this.add(textName);
        this.add(labelName);
        this.add(label);
        this.add(submit);
        this.add(back);
        this.add(imageFront);
        this.setLayout(null);
        this.setVisible(true);


        try{
           Conn c = new Conn();
           String query = "SELECT * FROM employee WHERE empid= '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){

                textName.setText(rs.getString("name"));
                textFatherName.setText(rs.getString("fname"));
                textDob.setText(rs.getString("dob"));
                textSalary.setText(rs.getString("salary"));
                textEmail.setText(rs.getString("email"));
                textEdu.setText(rs.getString("edu"));
                textDesign.setText(rs.getString("design"));
                textAadhar.setText(rs.getString("aadhar"));

            }


        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == submit){
            String name = textName.getText();
            String fname = textFatherName.getText();
            String dob = textDob.getText();
            String salary = textSalary.getText();
            String email = textEmail.getText();
            String edu = textEdu.getText();
            String design = textDesign.getText();
            String aadhar = textAadhar.getText();

            try{

                Conn c= new Conn();
                String query =
                        "UPDATE employee set name='"+name+"',fname = '"+fname+"',dob = '"+dob+"',salary='"+salary+"',email='"+email+"',edu='"+edu+"',design='"+design+"',aadhar='"+aadhar+"' WHERE empid='"+empId+"'";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updateds successfully");
                setVisible(false);
                new HomeInside();

            }catch(Exception en){
                en.printStackTrace();
            }
        }

        if(e.getSource() == back){
            setVisible(false);
            new HomeInside();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
