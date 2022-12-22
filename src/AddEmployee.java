import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    
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
    JLabel labelEmployeeId;

    JLabel textEmplId;
    Random num = new Random();

    int ran = num.nextInt(999999);

    JComboBox boxSelection;
    AddEmployee(){

        getContentPane().setBackground(Color.white);
        setLayout(null);

         //HEADING
        label = new JLabel("ADD EMPLOYEE'S");
        label.setBounds(300,20,1200,75);
        label.setFont(new Font("serif",Font.BOLD,60));
        label.setForeground(Color.red);

        //LABELS

        labelName = new JLabel("Name");
        labelName.setBounds(40,130,100,25);
        labelName.setFont(new Font("serif",Font.BOLD,20));

        textName = new TextField();
        textName.setBounds(120,130,150,25);
//        textName.setBounds(50,130,400,25);

        labelFatherName = new JLabel("Father's Name");
        labelFatherName.setBounds(540,130,130,25);
        labelFatherName.setFont(new Font("serif",Font.BOLD,20));

        textFatherName = new TextField();
        textFatherName.setBounds(720,130,180,25);

        labelDob = new JLabel("Date of Birth");
        labelDob.setBounds(40,200,200,25);
        labelDob.setFont(new Font("serif",Font.BOLD,20));

        //JDATECHOOSEPACKAGE
        textDob = new TextField();
        textDob.setBounds(160,200,150,25);

        labelSalary = new JLabel("Salary");
        labelSalary.setBounds(540,200,200,25);
        labelSalary.setFont(new Font("serif",Font.BOLD,20));

        textSalary = new TextField();
        textSalary.setBounds(720,200,180,25);

        labelEmail = new JLabel("Email");
        labelEmail.setBounds(40,270,200,25);
        labelEmail.setFont(new Font("serif",Font.BOLD,20));

        textEmail = new TextField();
        textEmail.setBounds(160,270,200,25);


        labelEdu = new JLabel("Highest Education");
        labelEdu.setBounds(540,270,200,25);
        labelEdu.setFont(new Font("serif",Font.BOLD,20));

        //UL LI IN HTML
        String education[] = {"Bsc","BTech","BCom","MCom","None","Other"};
        boxSelection = new JComboBox(education);
        boxSelection.setBounds(720,270,180,25);

//        textEdu = new TextField();
//        textEdu.setBounds(720,270,180,25);

        labelDesign = new JLabel("Designation");
        labelDesign.setBounds(40,340,200,25);
        labelDesign.setFont(new Font("serif",Font.BOLD,20));

        textDesign = new TextField();
        textDesign.setBounds(160,340,200,25);

        labelAadhar = new JLabel("Aadhar Number");
        labelAadhar.setBounds(540,340,200,25);
        labelAadhar.setFont(new Font("serif",Font.BOLD,20));

        textAadhar = new TextField();
        textAadhar.setBounds(720,340,180,25);

        labelEmployeeId = new JLabel("EmployeeId Number");
        labelEmployeeId.setBounds(40,420,200,25);
        labelEmployeeId.setFont(new Font("serif",Font.BOLD,20));

        textEmplId = new JLabel(""+ ran);
        textEmplId.setBounds(250,420,200,25);
        textEmplId.setFont(new Font("serif",Font.BOLD,20
        ));


        //LABELS ENDS

        //BUTTON
        submit = new JButton("Submit");
        submit.setBounds(160,540,200,25);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        
        submit.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(400,540,200,25);
        back.setBackground(Color.red);
        back.setForeground(Color.white);

        back.addActionListener(this);


//        imageFront.setBounds(0,100,1170,650); //FOR IMAGE BACKGROUND


        this.setSize(1170,750);
        this.setLocation(280,50);
        this.setTitle("ADD EMPLOYEE");

        this.add(textEmplId);
        this.add(labelEmployeeId);
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
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

       try{

           if(e.getSource() == submit){

               String name    = textName.getText();
               String fname   = textFatherName.getText();
               String dob     = textDob.getText();
               String salary  = textSalary.getText();
               String Email   = textEmail.getText();
               String Edu     = (String) boxSelection.getSelectedItem();
               String Design  = textDesign.getText();
               String Aadhar  = textAadhar.getText();
               String empId   = textEmplId.getText();


               if(name.isEmpty() || fname.isEmpty() || dob.isEmpty() || salary.isEmpty() || Email.isEmpty() || Edu.isEmpty() || Design.isEmpty() || Aadhar.isEmpty() || empId.isEmpty()){
                   JOptionPane.showMessageDialog(null,"Field cannt be empty");

               }else {


                   Conn c = new Conn();
                   String query = "INSERT INTO employee(name,fname,dob,salary,email,edu,design,aadhar,empid) VALUES('" + name +
                           "'," +
                           "'" + fname + "','" + dob + "','" + salary + "','" + Email + "','" + Edu + "','" + Design + "','" + Aadhar + "','" + empId +
                           "')";

//               ResultSet rs = c.s.executeQuery(query); //Execute

                   c.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Employee added successfully");
                   setVisible(false);
                   new HomeInside();

               }
           }

           if(e.getSource() == back){
               setVisible(false);
               new HomeInside();
           }

       }catch(Exception se){
           se.printStackTrace();
       }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
