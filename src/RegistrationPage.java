import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegistrationPage extends JFrame {
    private JTextField id;
    private JTextField name;
    private JTextField mob;
    private JTextField mail;
    private JTextField pass;
    private JPanel RegPanel;
    private JButton submitButton;
    public RegistrationPage() {

        setContentPane(RegPanel);
        setSize(400, 600);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int id1 = Integer.parseInt(id.getText());
                String name1 = name.getText();
               String mob1 = mob.getText();
               String mail1 = mail.getText();
               String pass1 = pass.getText();

                try {
                    String query = "Insert into User_details values("+id1+",'"+name1+"','"+mob1+"','"+mail1+"','"+pass1+"');";
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Attendance_System", "root", "ZXY7877@Av");
                    Statement st = con.createStatement();
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(RegPanel,"Registration Successful");




                } catch (Exception f) {
                    System.out.println(f);
                    JOptionPane.showMessageDialog(RegPanel,"Please check your Registration details or you may have already registered.");
                }
            }
        });
    }


}
