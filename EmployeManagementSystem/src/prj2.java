import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

class del_emp{
	static JFrame frame = new JFrame("delete employe by id");
	public del_emp() {
		frame.setSize(1280,720);
        frame.setVisible(true);
	}
	public static void del() {
		frame.setSize(1280,720);
        frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,0,1,1) );
		
		JPanel idP = new JPanel();
		JLabel idL = new JLabel("ID" ,JLabel.CENTER);
		JTextArea idT = new JTextArea("enter the id " );
		JButton del_btn = new JButton("delete");
		idP.add(idL);
		idP.add(idT);
		JLabel errMsg = new JLabel("enter the id of employe you want to delete",JLabel.CENTER);
		panel.setBackground(Color.cyan);
		errMsg.setForeground(Color.red);
		panel.add(idP);
		panel.add(errMsg);
		panel.add(del_btn);
		
		
//		button function
		
		del_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 0;
				String idS = idT.getText();
				int id = 0;
				try {
					id = Integer.parseInt(idS);
				}catch(Exception err) {
					errMsg.setText("you need to enter a number");
					flag = 1;
				}
				//sql
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
            		System.out.println("Connecting to database...");
            		Connection conn = null;
        			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
        			Statement stm = conn.createStatement();
        			int x = stm.executeUpdate("DELETE FROM employes WHERE ID = "+id+"");
        				if(flag ==0 || x == 0) {
        					errMsg.setText("the id you enter doesnt exist ");
        				}
        				if(x==1) {
        					errMsg.setText("employe deleted");
        				}
        			}
        		catch(SQLException se) {
        			System.out.println("exception : " + se);
        		}
        		catch(ClassNotFoundException ce) {
        			System.out.println(ce);
        		}
        		//sql end
				
			}
		});
		
//		design
		del_btn.setBackground(Color.DARK_GRAY);
		del_btn.setForeground(Color.white);
		idP.setBackground(Color.yellow);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public static void deploy() {
		del();
	}
}

class search_emp{
	
	public static void statusEmp(int id, String name , int age, String ad1, String ad2, String ad3 , String deg, String dept ) {
		JFrame frame = new JFrame();
		frame.setSize(1280,720);
		frame.setVisible(true);
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,0,1,1));
        JPanel r1 = new JPanel();
        r1.setLayout(new GridLayout(0,2,1,1));
        JPanel r1c1 = new JPanel();
        r1c1.setLayout(new GridLayout(7,0,1,1));
        JPanel r1c2 = new JPanel();
        // r1c1.setLayout(new GridLayout(2,3,1,1));
//        JPanel r2 = new JPanel();



        // name #1
        JPanel nameP = new JPanel();
        nameP.setLayout(new FlowLayout());
        JLabel nameL = new JLabel("name : ");
        JLabel nameT = new JLabel(name);
        nameP.add(nameL);
        nameP.add(nameT);

        // age #2
        String s = String.valueOf(age);
        JPanel ageP = new JPanel();
        ageP.setLayout(new FlowLayout());
        JLabel ageL = new JLabel("age : ");
        JLabel ageT = new JLabel(s);
        ageP.add(ageL);
        ageP.add(ageT);

        // ad1 #3
        JPanel ad1P = new JPanel();
        ad1P.setLayout(new FlowLayout());
        JLabel ad1L = new JLabel("adress1 : ");
        JLabel ad1T = new JLabel(ad1);
        ad1P.add(ad1L);
        ad1P.add(ad1T);

        // ad2 #4
        JPanel ad2P = new JPanel();
        ad2P.setLayout(new FlowLayout());
        JLabel ad2L = new JLabel("adress2 : "  );
        JLabel ad2T = new JLabel(ad2);
        ad2P.add(ad2L);
        ad2P.add(ad2T);

        // ad3 #5
        JPanel ad3P = new JPanel();
        ad3P.setLayout(new FlowLayout());
        JLabel ad3L = new JLabel("adress3 : ");
        JLabel ad3T = new JLabel(ad3);
        ad3P.add(ad3L);
        ad3P.add(ad3T);

        // degree #6
        JPanel degP = new JPanel();
        degP.setLayout(new FlowLayout());
        JLabel degL = new JLabel("degree : ");
        JLabel degT = new JLabel(deg);
        degP.add(degL);
        degP.add(degT);

        // code #7
        JPanel codeP = new JPanel();
        codeP.setLayout(new FlowLayout());
        JLabel codeL = new JLabel("department : ");
        JLabel codeT = new JLabel(dept);
        codeP.add(codeL);
        codeP.add(codeT);


        r1c1.add(nameP);
        r1c1.add(ageP);
        r1c1.add(ad1P);
        r1c1.add(ad2P);
        r1c1.add(ad3P);
        r1c1.add(degP);
        r1c1.add(codeP);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel r1c2n = new JLabel("your picture",JLabel.CENTER);
        r1c2.setLayout(new BorderLayout());
        r1c2.setBorder(blackline);
        r1c2.add(r1c2n , BorderLayout.CENTER);

        r1.add(r1c1);
        r1.add(r1c2);

        JButton signup_btn = new JButton("signup");
        JPanel tAC = new JPanel();
        JLabel r2tc = new JLabel("I have read all terms and condition and agree to it",JLabel.CENTER);
        JCheckBox r2cb = new JCheckBox();
        tAC.add(r2tc);
        tAC.add(r2cb);
//        r2.setLayout(new BorderLayout());
//        r2.add(tAC,BorderLayout.NORTH);
//        r2.add(signup_btn,BorderLayout.SOUTH);
//
        panel.add(r1);
//        panel.add(r2);

        // design
        nameP.setBackground(Color.lightGray);
        ageP.setBackground(Color.lightGray);
        ad1P.setBackground(Color.lightGray);
        ad2P.setBackground(Color.lightGray);
        ad3P.setBackground(Color.lightGray);
        codeP.setBackground(Color.lightGray);
        degP.setBackground(Color.lightGray);
        r1c1.setBackground(Color.cyan);
        r1c2.setBackground(Color.DARK_GRAY);
        r1c2.setForeground(Color.white);
        r1c2n.setForeground(Color.white);
//        r2.setBackground(Color.cyan);
        signup_btn.setBackground(Color.darkGray);
        signup_btn.setForeground(Color.white);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
	}
	
	static JFrame frame = new JFrame("search emp");
	public search_emp() {
		frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	public static void search() {
		frame.setSize(1280,720);
        frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,0,1,1) );
		
		JPanel idP = new JPanel();
		JLabel idL = new JLabel("ID" ,JLabel.CENTER);
		JTextArea idT = new JTextArea("enter the id of the employe you want to search" );
		JButton search_btn = new JButton("search");
		idP.add(idL);
		idP.add(idT);
		JLabel errMsg = new JLabel("Make sure the id you enter is of a registered employe",JLabel.CENTER);
		panel.setBackground(Color.cyan);
		errMsg.setForeground(Color.red);
		panel.add(idP);
		panel.add(errMsg);
		panel.add(search_btn);
		
		
//		button function
		
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 0;
				String idS = idT.getText();
				int id = 0;
				try {
					id = Integer.parseInt(idS);
				}catch(Exception err) {
					errMsg.setText("you need to enter a number");
					flag = 1;
				}
				//sql
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
            		System.out.println("Connecting to database...");
            		Connection conn = null;
        			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
        			Statement stm = conn.createStatement();
        			ResultSet rs = stm.executeQuery("select * from employes");
        			while(rs.next()) {
        				if(rs.getInt(1)==id) {
        					System.out.println("got it");
        					flag = 1;
        					int eId = rs.getInt(1);
        					String eName = rs.getString(2);
        					int age = rs.getInt(3);
        					String eAd1 = rs.getString(4);
        					String eAd2 = rs.getString(5);
        					String eAd3 = rs.getString(6);
        					String eDeg = rs.getString(7);
        					String eDept = rs.getString(8);
        					statusEmp(eId, eName, age , eAd1 , eAd2 , eAd3, eDeg, eDept);
        					break;
        				}
        				if(flag ==0) {
        					errMsg.setText("the id you enter doesnt exist ");
        				}
        			}
        		}catch(SQLException se) {
        			System.out.println("exception : " + se);
        		}
        		catch(ClassNotFoundException ce) {
        			System.out.println(ce);
        		}
        		//sql end
				
			}
		});
		
//		design
		search_btn.setBackground(Color.DARK_GRAY);
		search_btn.setForeground(Color.white);
		idP.setBackground(Color.yellow);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public static void deploy() {
		search();
	}
}

class add_emp{
    static JFrame frame = new JFrame("add employes");
    static JLabel hn = new JLabel("add employes");
    add_emp(){
        frame.setSize(1280,720);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void header(){
        JPanel header = new JPanel();
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
        panel.setLayout(new GridLayout(1,0,1,1));
        JPanel r1 = new JPanel();
        r1.setLayout(new GridLayout(0,2,1,1));
        JPanel r1c1 = new JPanel();
        r1c1.setLayout(new GridLayout(9,0,1,1));
        JPanel r1c2 = new JPanel();
        // r1c1.setLayout(new GridLayout(2,3,1,1));



        // id #0
        JPanel idP = new JPanel();
        idP.setLayout(new FlowLayout());
        JLabel idL = new JLabel("id");
        JTextArea idT = new JTextArea("id");
        idP.add(idL);
        idP.add(idT);
        
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
        JPanel deptP = new JPanel();
        deptP.setLayout(new FlowLayout());
        JLabel deptL = new JLabel("department");
        JTextArea deptT = new JTextArea("dept");
        deptP.add(deptL);
        deptP.add(deptT);


        r1c1.add(idP);
        r1c1.add(nameP);
        r1c1.add(ageP);
        r1c1.add(ad1P);
        r1c1.add(ad2P);
        r1c1.add(ad3P);
        r1c1.add(degP);
        r1c1.add(deptP);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel r1c2n = new JLabel("your picture",JLabel.CENTER);
        JButton upload_btn = new JButton("upload");
        r1c2.setLayout(new BorderLayout());
        r1c2.setBorder(blackline);
        r1c2.add(r1c2n , BorderLayout.CENTER);
        r1c2.add(upload_btn, BorderLayout.SOUTH);

        r1.add(r1c1);
        r1.add(r1c2);

        JButton signup_btn = new JButton("add employe");
        JPanel tAC = new JPanel();
        JLabel r2tc = new JLabel("I have read all terms and condition and agree to it",JLabel.CENTER);
        JCheckBox r2cb = new JCheckBox();
        tAC.add(r2tc);
        tAC.add(r2cb);
        r1c1.add(signup_btn);
        panel.add(r1);
        
//        buttons functions
        signup_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int flag = 0;

        			//sql
            		try {

            			String aIdS = idT.getText();
            			int aId = Integer.parseInt(aIdS);
            			String aName = nameT.getText();
            			String aAge = ageT.getText();
            			int aAgei = Integer.parseInt(aAge);
            			String aAd1 = ad1T.getText();
            			String aAd2 = ad2T.getText();
            			String aAd3 = ad3T.getText();
            			String aDeg = degT.getText();
            			String aDept = deptT.getText();
            			Class.forName("com.mysql.cj.jdbc.Driver");
                		System.out.println("Connecting to database...");
                		Connection conn = null;
            			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
            			Statement stm = conn.createStatement();
            			ResultSet rs = stm.executeQuery("select * from employes");
            			while(rs.next()) {
            				if(rs.getInt(1)==aId) {
            					System.out.println("same id already exist");
            					hn.setText("same id already exist");
            					flag = 1;
            				}
            			}
            			
            			if(flag==0) {
            				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employes(id,name,age,ad1,ad2,ad3,deg,dept) VALUE(?,?,?,?,?,?,?,?)");
                			pstmt.setInt(1, aId);
                			pstmt.setString(2,aName);
                			pstmt.setInt(3, aAgei);
                			pstmt.setString(4, aAd1);
                			pstmt.setString(5, aAd2);
                			pstmt.setString(6, aAd3);
                			pstmt.setString(7, aDeg);
                			pstmt.setString(8, aDept);
                			pstmt.executeUpdate();
                			System.out.println("employe added sucessfully");
                			frame.removeAll();
                			JLabel s = new JLabel("succefully added", JLabel.CENTER);
                			frame.getContentPane().add(s);
                			frame.setVisible(true);
                			frame.dispose();
                			System.out.println(conn + " " +stm);
            			}
            			
            		}catch(SQLException se) {
            			System.out.println("exception : " + se);
            		}
            		catch(ClassNotFoundException ce) {
            			System.out.println(ce);
            		}
            		//sql end
        		
        	}
        });

        // design
        r1c1.setBackground(Color.cyan);
        r1c2.setBackground(Color.DARK_GRAY);
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

class Menu{
	static JFrame frame = new JFrame("menu");
	public Menu() {
		frame.setSize(1280,720);
		frame.setVisible(true);
	}
	public static void menu_main() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,0,1,1));
		JLabel adminInfo = new JLabel("administrator :- name : shubha username : rupel" , JLabel.CENTER);
		JButton add_btn = new JButton("add employe");
		JButton delete_btn = new JButton("delete employe");
		JButton search_btn = new JButton("search employe");
		JButton display_btn = new JButton("display all employes");
		
		panel.add(adminInfo);
		panel.add(add_btn);
		panel.add(delete_btn);
		panel.add(search_btn);
		panel.add(display_btn);
		
//		button functions: 
//		add_btn
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_emp obj = new add_emp();
				obj.signupPage();
			}
		});
		
//		delete_btn
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				del_emp.deploy();
			}
		});
		
//		search_btn
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_emp.deploy();
			}
		});
		
//		display_btn
		display_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empScreen.deployF();
			}
		});
		
//		design
		add_btn.setBackground(Color.DARK_GRAY);
		add_btn.setForeground(Color.green);
		delete_btn.setBackground(Color.DARK_GRAY);
		delete_btn.setForeground(Color.red);
		search_btn.setBackground(Color.DARK_GRAY);
		search_btn.setForeground(Color.white);
		display_btn.setBackground(Color.DARK_GRAY);
		display_btn.setForeground(Color.yellow);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public void deploy() {
		menu_main();
	}
}



class empScreen{
	public static void statusEmp(int id, String name , int age, String ad1, String ad2, String ad3 , String deg, String dept ) {
		JFrame frame = new JFrame();
		frame.setSize(1280,720);
		frame.setVisible(true);
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,0,1,1));
        JPanel r1 = new JPanel();
        r1.setLayout(new GridLayout(0,2,1,1));
        JPanel r1c1 = new JPanel();
        r1c1.setLayout(new GridLayout(7,0,1,1));
        JPanel r1c2 = new JPanel();
        // r1c1.setLayout(new GridLayout(2,3,1,1));
//        JPanel r2 = new JPanel();



        // name #1
        JPanel nameP = new JPanel();
        nameP.setLayout(new FlowLayout());
        JLabel nameL = new JLabel("name : ");
        JLabel nameT = new JLabel(name);
        nameP.add(nameL);
        nameP.add(nameT);

        // age #2
        String s = String.valueOf(age);
        JPanel ageP = new JPanel();
        ageP.setLayout(new FlowLayout());
        JLabel ageL = new JLabel("age : ");
        JLabel ageT = new JLabel(s);
        ageP.add(ageL);
        ageP.add(ageT);

        // ad1 #3
        JPanel ad1P = new JPanel();
        ad1P.setLayout(new FlowLayout());
        JLabel ad1L = new JLabel("adress1 : ");
        JLabel ad1T = new JLabel(ad1);
        ad1P.add(ad1L);
        ad1P.add(ad1T);

        // ad2 #4
        JPanel ad2P = new JPanel();
        ad2P.setLayout(new FlowLayout());
        JLabel ad2L = new JLabel("adress2 : "  );
        JLabel ad2T = new JLabel(ad2);
        ad2P.add(ad2L);
        ad2P.add(ad2T);

        // ad3 #5
        JPanel ad3P = new JPanel();
        ad3P.setLayout(new FlowLayout());
        JLabel ad3L = new JLabel("adress3 : ");
        JLabel ad3T = new JLabel(ad3);
        ad3P.add(ad3L);
        ad3P.add(ad3T);

        // degree #6
        JPanel degP = new JPanel();
        degP.setLayout(new FlowLayout());
        JLabel degL = new JLabel("degree : ");
        JLabel degT = new JLabel(deg);
        degP.add(degL);
        degP.add(degT);

        // code #7
        JPanel codeP = new JPanel();
        codeP.setLayout(new FlowLayout());
        JLabel codeL = new JLabel("department : ");
        JLabel codeT = new JLabel(dept);
        codeP.add(codeL);
        codeP.add(codeT);


        r1c1.add(nameP);
        r1c1.add(ageP);
        r1c1.add(ad1P);
        r1c1.add(ad2P);
        r1c1.add(ad3P);
        r1c1.add(degP);
        r1c1.add(codeP);

        Border blackline = BorderFactory.createLineBorder(Color.black);
        JLabel r1c2n = new JLabel("your picture",JLabel.CENTER);
        r1c2.setLayout(new BorderLayout());
        r1c2.setBorder(blackline);
        r1c2.add(r1c2n , BorderLayout.CENTER);

        r1.add(r1c1);
        r1.add(r1c2);
        panel.add(r1);

        // design
        nameP.setBackground(Color.lightGray);
        ageP.setBackground(Color.lightGray);
        ad1P.setBackground(Color.lightGray);
        ad2P.setBackground(Color.lightGray);
        ad3P.setBackground(Color.lightGray);
        codeP.setBackground(Color.lightGray);
        degP.setBackground(Color.lightGray);
        r1c1.setBackground(Color.cyan);
        r1c2.setBackground(Color.DARK_GRAY);
        r1c2.setForeground(Color.white);
        r1c2n.setForeground(Color.white);
//        r2.setBackground(Color.cyan);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
	}
	
	public static void deployF() {
		
        JFrame frame = new JFrame("employe management system");
        frame.setSize(1280,720);
		
        //body display
        JPanel body = new JPanel();
        body.setBackground(Color.lightGray);
        JScrollPane scrollPane = new JScrollPane(body);
        body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
        
//      sql start
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
          Statement stm = conn.createStatement();
          ResultSet rs =  stm.executeQuery("select * from employes");
          while(rs.next()) {
//          	System.out.println("id : " + rs.getInt(1) + " name : " + rs.getString(2) );
        	  int eId = rs.getInt(1);
        	  String eName = rs.getString(2);
        	  int age = rs.getInt(3);
        	  String eAd1 = rs.getString(4);
        	  String eAd2 = rs.getString(5);
        	  String eAd3 = rs.getString(6);
        	  String eDeg = rs.getString(7);
        	  String eDept = rs.getString(8);
        	  JPanel empList = new JPanel();
              JLabel nameD = new JLabel();
              JButton status_btn = new JButton("status");
              nameD.setText("     Name : "+ eName  + "     ID : "+ eId);
              empList.add(nameD);
              empList.add(status_btn);
              body.add(empList);
//              design
              empList.setBackground(Color.DARK_GRAY);
              empList.setForeground(Color.white);
              nameD.setForeground(Color.white);
              status_btn.setBackground(Color.black);
              status_btn.setForeground(Color.GREEN);              
              status_btn.addActionListener(new ActionListener() {
              	public void actionPerformed(ActionEvent e) {
              		statusEmp(eId, eName, age , eAd1 , eAd2 , eAd3, eDeg, eDept);
              	}
              });
          }
      }catch(Exception e) {
      	System.out.println("well, there is an exception \n " + e);
      }
//      sql end

      frame.getContentPane().add(scrollPane);
      frame.setVisible(true);
	}
}




class signup_gui{
    static JFrame frame = new JFrame();
    static final String company_code = "1234";
    signup_gui(){
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

class Locksc_gui{

    static JFrame frame = new JFrame();
    static JButton login_btn = new JButton("login");
    static JTextArea name_inp = new JTextArea("Enter your username");
    static JTextArea pass_inp = new JTextArea("Enter your password");
    static JLabel myMsg= new JLabel(); 

    Locksc_gui(){
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void header(){
        JPanel header = new JPanel();
        JLabel hn = new JLabel("login page");
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

    public static void locksc(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,0,0,0) );

        //username
        JPanel nameP = new JPanel();
        nameP.setLayout(new FlowLayout());
        JLabel name = new JLabel("Username");
        nameP.add(name);
        nameP.add(name_inp);

        //password
        JPanel passP = new JPanel();
        passP.setLayout(new FlowLayout());
        JLabel pass = new JLabel("password");
        passP.add(pass);
        passP.add(pass_inp);
        
        //buttons
        //login button
        
        // signup button
        JButton signup_btn = new JButton("signup");
        signup_btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                signup_gui obj = new signup_gui();
                obj.signupPage();
            }
        });

        JPanel row2 = new JPanel();
        JLabel rgn = new JLabel("not an administator ?");
        row2.add(rgn);
        row2.add(signup_btn);

        JPanel row3 =  new JPanel();
        JLabel r3n = new JLabel("if you are a registered emplyed , use your name in username and id in password.");
        JLabel r3n2 = new JLabel("Only adminstator can register an employe, you can sign up as administator if you have the company code.");
        row3.add(r3n);
        row3.add(r3n2);
        row3.add(myMsg);

        JPanel passAndName = new JPanel();
        passAndName.add(nameP);
        passAndName.add(passP);
        passAndName.add(login_btn);

        // panel adding the components
        panel.add(passAndName);
        panel.add(row2);
        panel.add(row3);

        //design
        passAndName.setBackground(Color.yellow);
        row2.setBackground(Color.yellow);
        row3.setBackground(Color.CYAN);
        login_btn.setBackground(Color.DARK_GRAY);
        login_btn.setForeground(Color.white);
        signup_btn.setBackground(Color.DARK_GRAY);
        signup_btn.setForeground(Color.white);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void loginPage(){
        locksc();
        header();
        footer();
    }

}

public class prj2 {
    public static void main (String [] args){

            	//sql
    	try{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Connecting to database...");
    		Connection conn = null;
    			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
    			Statement stm = conn.createStatement();
//    			int x = stm.executeUpdate("insert into employes value(2,'rupel')");
    			ResultSet rs=stm.executeQuery("select * from admins");
    			while(rs.next()) {
    				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "+rs.getString(3)+ " "+ rs.getString(4) + " " + rs.getString(5) + " "+rs.getString(6)+  " " + rs.getString(7) + " "+rs.getString(8) + " "+ rs.getString(9) +" "+  rs.getBoolean(10));
    			}
    			System.out.println(conn + " " +stm);
    	
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
		
		//sql end

        Locksc_gui obj = new Locksc_gui();
        obj.loginPage();
        obj.login_btn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	int flag = 0;
            	String name = Locksc_gui.name_inp.getText();
            	String pass = Locksc_gui.pass_inp.getText();
//            	sql start
              	try{
            		Class.forName("com.mysql.cj.jdbc.Driver");
            		System.out.println("Connecting to database...");
            		Connection conn = null;
            			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
            			Statement stm = conn.createStatement();
            			ResultSet rs=stm.executeQuery("select * from admins");
            			while(rs.next()) {
            				if(name.equals(rs.getString(2)) && pass.equals(rs.getString(3)) ) {
            					System.out.println("true");
            					Menu m = new Menu();
            					m.deploy();
            					flag = 1;
            					Locksc_gui.myMsg.setText("login sucessful as administator");
            					break;
            				}
            			}
            			ResultSet rs2 = stm.executeQuery("select * from employes");
            			while(rs2.next()) {
            				int x = rs2.getInt(1);
            				String passS = String.valueOf(x);
            				if(name.equals(rs2.getString(2)) && pass.equals(passS)) {
            					System.out.println("true");
            					empScreen.deployF();
            					flag = 1;
            					Locksc_gui.myMsg.setText("login sucessful as employe");
            					break;
            				}
            			}
            	}catch(Exception exp) {
            		System.out.println(exp);
            	}
//              	sql end
              	
              	if(flag == 0) {
              		System.out.println("login failed");
              		Locksc_gui.myMsg.setText("Login failed. Username or password incorrect");
              	}
            	
            }
        });
    }
}

