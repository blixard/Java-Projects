import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class signup_be{
    static JFrame frame = new JFrame();
    static final String company_code = "1234";
    signup_be(){
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void header(){
        JPanel header = new JPanel();
        JLabel hn = new JLabel("signup page");
        header.add(hn);
        frame.getContentPane().add(header, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public static void footer(){
        JPanel footer = new JPanel();
        JLabel fn = new JLabel("made by SHUBHAPRASAD PADHY");
        footer.add(fn);
        frame.getContentPane().add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void signupSc(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,0,1,1));
        JPanel r1 = new JPanel();
        r1.setLayout(new GridLayout(0,2,1,1));
        JPanel r1c1 = new JPanel();
        r1c1.setLayout(new GridLayout(9,0,1,1));
        JPanel r1c2 = new JPanel();
        // r1c1.setLayout(new GridLayout(2,3,1,1));
        JPanel r2 = new JPanel();



        // name #1
        JPanel nameP = new JPanel();
        nameP.setLayout(new FlowLayout());
        JLabel nameL = new JLabel("name");
        JTextArea nameT = new JTextArea("enter your name");
        nameP.add(nameL);
        nameP.add(nameT);

        // age #2
        JPanel ageP = new JPanel();
        ageP.setLayout(new FlowLayout());
        JLabel ageL = new JLabel("age");
        JTextArea ageT = new JTextArea("enter your age");
        ageP.add(ageL);
        ageP.add(ageT);

        // ad1 #3
        JPanel ad1P = new JPanel();
        ad1P.setLayout(new FlowLayout());
        JLabel ad1L = new JLabel("adress1");
        JTextArea ad1T = new JTextArea("enter your ad1");
        ad1P.add(ad1L);
        ad1P.add(ad1T);

        // ad2 #4
        JPanel ad2P = new JPanel();
        ad2P.setLayout(new FlowLayout());
        JLabel ad2L = new JLabel("adress2");
        JTextArea ad2T = new JTextArea("enter your ad2");
        ad2P.add(ad2L);
        ad2P.add(ad2T);

        // ad3 #5
        JPanel ad3P = new JPanel();
        ad3P.setLayout(new FlowLayout());
        JLabel ad3L = new JLabel("adress3");
        JTextArea ad3T = new JTextArea("enter your ad3");
        ad3P.add(ad3L);
        ad3P.add(ad3T);

        // degree #6
        JPanel degP = new JPanel();
        degP.setLayout(new FlowLayout());
        JLabel degL = new JLabel("degree");
        JTextArea degT = new JTextArea("degree");
        degP.add(degL);
        degP.add(degT);

        // code #7
        JPanel codeP = new JPanel();
        codeP.setLayout(new FlowLayout());
        JLabel codeL = new JLabel("company code");
        JTextArea codeT = new JTextArea("adminstator code");
        codeP.add(codeL);
        codeP.add(codeT);

        // username #8
        JPanel unameP = new JPanel();
        unameP.setLayout(new FlowLayout());
        JLabel unameL = new JLabel("username");
        JTextArea unameT = new JTextArea("set your username");
        unameP.add(unameL);
        unameP.add(unameT);

        // password #9
        JPanel passP = new JPanel();
        passP.setLayout(new FlowLayout());
        JLabel passL = new JLabel("password");
        JTextArea passT = new JTextArea("set your password");
        passP.add(passL);
        passP.add(passT);

        r1c1.add(unameP);
        r1c1.add(passP);
        r1c1.add(nameP);
        r1c1.add(ageP);
        r1c1.add(ad1P);
        r1c1.add(ad2P);
        r1c1.add(ad3P);
        r1c1.add(degP);
        r1c1.add(codeP);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel r1c2n = new JLabel("your picture",JLabel.CENTER);
        JButton upload_btn = new JButton("upload");
        r1c2.setLayout(new BorderLayout());
        r1c2.setBorder(blackline);
        r1c2.add(r1c2n , BorderLayout.CENTER);
        r1c2.add(upload_btn, BorderLayout.SOUTH);

        r1.add(r1c1);
        r1.add(r1c2);

        JButton signup_btn = new JButton("signup");
        JPanel tAC = new JPanel();
        JLabel r2tc = new JLabel("I have read all terms and condition and agree to it",JLabel.CENTER);
        JCheckBox r2cb = new JCheckBox();
        tAC.add(r2tc);
        tAC.add(r2cb);
        r2.setLayout(new BorderLayout());
        r2.add(tAC,BorderLayout.NORTH);
        r2.add(signup_btn,BorderLayout.SOUTH);

        panel.add(r1);
        panel.add(r2);
        
//        buttons functions
        signup_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String code = codeT.getText();
        		if(!code.equals(company_code)) {
        			System.err.println("company code for administator rights entered is wrong, cant register as an administator");
        		}
        		else if(!r2cb.isSelected()) {
        			System.err.println("accept the terms and condition");
        		}
        		else {
        			//sql
            		try {
            			String aUname = unameT.getText();
            			String aPass = passT.getText();
            			String aName = nameT.getText();
            			String aAge = ageT.getText();
            			int aAgei = Integer.parseInt(aAge);
            			String aAd1 = ad1T.getText();
            			String aAd2 = ad2T.getText();
            			String aAd3 = ad3T.getText();
            			String aDeg = degT.getText();
            			Class.forName("com.mysql.cj.jdbc.Driver");
                		System.out.println("Connecting to database...");
                		Connection conn = null;
            			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
            			Statement stm = conn.createStatement();
            			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO admins(username,password,name,age,ad1,ad2,ad3,deg,isAdmin) VALUE(?,?,?,?,?,?,?,?,?)");
            			pstmt.setString(1, aUname);
            			pstmt.setString(2, aPass);
            			pstmt.setString(3,aName);
            			pstmt.setInt(4, aAgei);
            			pstmt.setString(5, aAd1);
            			pstmt.setString(6, aAd2);
            			pstmt.setString(7, aAd3);
            			pstmt.setString(8, aDeg);
            			pstmt.setBoolean(9, true);
            			pstmt.executeUpdate();
            			ResultSet rs=stm.executeQuery("select * from employes");

            			System.out.println(conn + " " +stm);
            		}catch(SQLException se) {
            			System.out.println("exception : " + se);
            		}
            		catch(ClassNotFoundException ce) {
            			System.out.println(ce);
            		}
            		//sql end
        		}
        	}
        });

        // design
        nameP.setBackground(Color.lightGray);
        unameP.setBackground(Color.lightGray);
        passP.setBackground(Color.lightGray);
        ageP.setBackground(Color.lightGray);
        ad1P.setBackground(Color.lightGray);
        ad2P.setBackground(Color.lightGray);
        ad3P.setBackground(Color.lightGray);
        codeP.setBackground(Color.lightGray);
        degP.setBackground(Color.lightGray);
        r1c1.setBackground(Color.cyan);
        r1c2.setBackground(Color.DARK_GRAY);
        r2.setBackground(Color.cyan);
        upload_btn.setBackground(Color.darkGray);
        upload_btn.setForeground(Color.white);
        signup_btn.setBackground(Color.darkGray);
        signup_btn.setForeground(Color.white);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public void signupPage(){
        header();
        footer();
        signupSc();
    }

}

public class signup_backend {

	public static void main(String[] args) {

		signup_be obj = new signup_be();
		obj.signupPage();
	}

}

//
//class signup_gui{
//  static JFrame frame = new JFrame();
//  signup_gui(){
//      frame.setSize(1280,720);
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setVisible(true);
//  }
//
//  public static void header(){
//      JPanel header = new JPanel();
//      JLabel hn = new JLabel("signup page");
//      header.add(hn);
//      frame.getContentPane().add(header, BorderLayout.NORTH);
//      frame.setVisible(true);
//  }
//
//  public static void footer(){
//      JPanel footer = new JPanel();
//      JLabel fn = new JLabel("made by SHUBHAPRASAD PADHY");
//      footer.add(fn);
//      frame.getContentPane().add(footer, BorderLayout.SOUTH);
//      frame.setVisible(true);
//  }
//
//  public static void signupSc(){
//      JPanel panel = new JPanel();
//      panel.setLayout(new GridLayout(2,0,1,1));
//      JPanel r1 = new JPanel();
//      r1.setLayout(new GridLayout(0,2,1,1));
//      JPanel r1c1 = new JPanel();
//      r1c1.setLayout(new GridLayout(9,0,1,1));
//      JPanel r1c2 = new JPanel();
//      // r1c1.setLayout(new GridLayout(2,3,1,1));
//      JPanel r2 = new JPanel();
//
//
//
//      // name #1
//      JPanel nameP = new JPanel();
//      nameP.setLayout(new FlowLayout());
//      JLabel nameL = new JLabel("name");
//      JTextArea nameT = new JTextArea("enter your name");
//      nameP.add(nameL);
//      nameP.add(nameT);
//
//      // age #2
//      JPanel ageP = new JPanel();
//      ageP.setLayout(new FlowLayout());
//      JLabel ageL = new JLabel("age");
//      JTextArea ageT = new JTextArea("enter your age");
//      ageP.add(ageL);
//      ageP.add(ageT);
//
//      // ad1 #3
//      JPanel ad1P = new JPanel();
//      ad1P.setLayout(new FlowLayout());
//      JLabel ad1L = new JLabel("adress1");
//      JTextArea ad1T = new JTextArea("enter your ad1");
//      ad1P.add(ad1L);
//      ad1P.add(ad1T);
//
//      // ad2 #4
//      JPanel ad2P = new JPanel();
//      ad2P.setLayout(new FlowLayout());
//      JLabel ad2L = new JLabel("adress2");
//      JTextArea ad2T = new JTextArea("enter your ad2");
//      ad2P.add(ad2L);
//      ad2P.add(ad2T);
//
//      // ad3 #5
//      JPanel ad3P = new JPanel();
//      ad3P.setLayout(new FlowLayout());
//      JLabel ad3L = new JLabel("adress3");
//      JTextArea ad3T = new JTextArea("enter your ad3");
//      ad3P.add(ad3L);
//      ad3P.add(ad3T);
//
//      // degree #6
//      JPanel degP = new JPanel();
//      degP.setLayout(new FlowLayout());
//      JLabel degL = new JLabel("degree");
//      JTextArea degT = new JTextArea("degree");
//      degP.add(degL);
//      degP.add(degT);
//
//      // code #7
//      JPanel codeP = new JPanel();
//      codeP.setLayout(new FlowLayout());
//      JLabel codeL = new JLabel("company code");
//      JTextArea codeT = new JTextArea("adminstator code");
//      codeP.add(codeL);
//      codeP.add(codeT);
//
//      // username #8
//      JPanel unameP = new JPanel();
//      unameP.setLayout(new FlowLayout());
//      JLabel unameL = new JLabel("username");
//      JTextArea unameT = new JTextArea("set your username");
//      unameP.add(unameL);
//      unameP.add(unameT);
//
//      // password #9
//      JPanel passP = new JPanel();
//      passP.setLayout(new FlowLayout());
//      JLabel passL = new JLabel("password");
//      JTextArea passT = new JTextArea("set your password");
//      passP.add(passL);
//      passP.add(passT);
//
//      r1c1.add(unameP);
//      r1c1.add(passP);
//      r1c1.add(nameP);
//      r1c1.add(ageP);
//      r1c1.add(ad1P);
//      r1c1.add(ad2P);
//      r1c1.add(ad3P);
//      r1c1.add(degP);
//      r1c1.add(codeP);
//
//      Border blackline = BorderFactory.createLineBorder(Color.black);
//      JLabel r1c2n = new JLabel("your picture",JLabel.CENTER);
//      JButton upload_btn = new JButton("upload");
//      r1c2.setLayout(new BorderLayout());
//      r1c2.setBorder(blackline);
//      r1c2.add(r1c2n , BorderLayout.CENTER);
//      r1c2.add(upload_btn, BorderLayout.SOUTH);
//
//      r1.add(r1c1);
//      r1.add(r1c2);
//
//      JButton signup_btn = new JButton("signup");
//      JPanel tAC = new JPanel();
//      JLabel r2tc = new JLabel("I have read all terms and condition and agree to it",JLabel.CENTER);
//      JCheckBox r2cb = new JCheckBox();
//      tAC.add(r2tc);
//      tAC.add(r2cb);
//      r2.setLayout(new BorderLayout());
//      r2.add(tAC,BorderLayout.NORTH);
//      r2.add(signup_btn,BorderLayout.SOUTH);
//
//      panel.add(r1);
//      panel.add(r2);
//
//      // design
//      nameP.setBackground(Color.lightGray);
//      unameP.setBackground(Color.lightGray);
//      passP.setBackground(Color.lightGray);
//      ageP.setBackground(Color.lightGray);
//      ad1P.setBackground(Color.lightGray);
//      ad2P.setBackground(Color.lightGray);
//      ad3P.setBackground(Color.lightGray);
//      codeP.setBackground(Color.lightGray);
//      degP.setBackground(Color.lightGray);
//      r1c1.setBackground(Color.cyan);
//      r1c2.setBackground(Color.DARK_GRAY);
//      r2.setBackground(Color.cyan);
//      upload_btn.setBackground(Color.darkGray);
//      upload_btn.setForeground(Color.white);
//      signup_btn.setBackground(Color.darkGray);
//      signup_btn.setForeground(Color.white);
//
//      frame.getContentPane().add(panel, BorderLayout.CENTER);
//      frame.setVisible(true);
//
//  }
//
//  public void signupPage(){
//      header();
//      footer();
//      signupSc();
//  }
//
//}



