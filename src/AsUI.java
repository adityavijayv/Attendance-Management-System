import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class student extends JFrame{
    Container c;
    JLabel name,branch,mno,email,stuid,wlc,intro,bk;
    JTextField name1,mno1,email1,stuid1,branch1;
    JTextArea outdata;
    JPanel a,b;
    JButton submit,clear;

    student(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());


            setTitle("Student Database Management");
            setBounds(450, 0, 600, 800);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);
            setLayout(null);


            c =getContentPane();


            a = new JPanel();
            a.setLayout(null);
            a.setBounds(0,0,600,800);
            a.setVisible(true);
            c.add(a);



            b= new JPanel();
            b.setLayout(null);
            b.setBounds(0,0,600,800);
            c.add(b);
            b.setVisible(true);



            Font font1 = new Font("Ariel",Font.BOLD,20);
            Font font3 = new Font("Ariel",Font.BOLD,30);
            ImageIcon img = new ImageIcon("bk1.jpg");
            bk = new JLabel(img);
            bk.setSize(600,800);
            a.add(bk);






            wlc = new JLabel("WELCOME");
            wlc.setBounds(190,10,300,30);
            wlc.setFont(font3);
           // wlc.setForeground(Color.white);
            // bk.add(wlc);




            intro = new JLabel("Enter Student Details:-");
            intro.setBounds(120,60,600,30);
            intro.setFont(font3);
          //  intro.setForeground(Color.white);
            bk.add(intro);




            name = new JLabel("⦿ Name  ➡");
            name.setBounds(50,150,200,50);
            name.setFont(font1);
           // name.setForeground(Color.white);
            bk.add(name);


            stuid = new JLabel("⦿ Roll No.  ➡");
            stuid.setBounds(50,230,200,50);
            stuid.setFont(font1);
           // stuid.setForeground(Color.white);
            bk.add(stuid);

            branch = new JLabel("⦿ Branch  ➡");
            branch.setBounds(50,310,200,50);
            branch.setFont(font1);
          //  branch.setForeground(Color.white);
            bk.add(branch);



            mno = new JLabel("⦿ Mobile No.  ➡");
            mno.setBounds(50,390,200,50);
            mno.setFont(font1);
          //  mno.setForeground(Color.white);
            bk.add(mno);


            email = new JLabel("⦿ Email ID  ➡");
            email.setBounds(50,470,200,50);
            email.setFont(font1);
          //  email.setForeground(Color.white);
            bk.add(email);








            name1 = new JTextField();
            name1.setBounds(260,150,280,50);
            name1.setFont(font1);
            bk.add(name1);



            stuid1 = new JTextField();
            stuid1.setBounds(260,230,280,50);
            stuid1.setFont(font1);
            bk.add(stuid1);



            branch1 = new JTextField();
            branch1.setBounds(260,310,280,50);
            branch1.setFont(font1);
            bk.add(branch1);





            mno1 = new JTextField();
            mno1.setBounds(260,390,280,50);
            mno1.setFont(font1);
            bk.add(mno1);



            email1 = new JTextField();
            email1.setBounds(260,470,280,50);
            email1.setFont(font1);
            bk.add(email1);


            outdata = new JTextArea();
            outdata.setBounds(50,570,500,70);
            outdata.setFont(font1);
            Border br = BorderFactory.createTitledBorder("Status");
            outdata.setBorder(br);
            bk.add(outdata);


            submit = new JButton("Submit");
            submit.setBounds(150,670,100,50);
            bk.add(submit);


            clear = new JButton("Clear all");
            clear.setBounds(350,670,100,50);
            bk.add(clear);




            setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}




public class AsUI{
    static String name2, stuid2 , branch2, email2;
    static long mno2;



    public static void main(String[] args) {
        try{
            student studbase = new student();












            studbase.submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        name2 = studbase.name1.getText();
                        stuid2 = studbase.stuid1.getText();
                        branch2 = studbase.branch1.getText();
                        email2 = studbase.email1.getText();
                        mno2 = Long.parseLong(studbase.mno1.getText());
                        System.out.println(name2 + stuid2 + branch2 + email2 + mno2);


                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Attendance_System", "root", "ZXY7877@Av");
                        String query = "Insert into User_details values('"+name2+"',"+stuid2+",'"+branch2+"',"+mno2+",'"+email2+"');";
                        Statement st = con.createStatement();
                        st.executeUpdate(query);
                        studbase.outdata.setText("Data updated");

                    }catch (Exception f){
                        System.out.println(f);
                    }
                }
            });




            studbase.clear.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    studbase.name1.setText(null);
                    studbase.stuid1.setText(null);
                    studbase.branch1.setText(null);
                    studbase.mno1.setText(null);
                    studbase.email1.setText(null);
                    studbase.outdata.setText(null);

                }
            });

        }
        catch (Exception f)
        {
            System.out.println(f);
        }
    }
}



