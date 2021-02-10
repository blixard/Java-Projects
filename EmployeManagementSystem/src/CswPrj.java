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

class employe{
    String Name = "";
    String id = "";
}

public class CswPrj {
	
	public static void statusEmp(int id, String name , int age, String ad1, String ad2, String ad3 , String deg, String dept ) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
//        r2.setBackground(Color.cyan);
        upload_btn.setBackground(Color.darkGray);
        upload_btn.setForeground(Color.white);
        signup_btn.setBackground(Color.darkGray);
        signup_btn.setForeground(Color.white);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
	}
	
    public static void main (String [] args)throws ClassNotFoundException{

        ArrayList<employe>al = new ArrayList<employe>();
        
//        sql start
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
            Statement stm = conn.createStatement();
            ResultSet rs =  stm.executeQuery("select * from employes");
            while(rs.next()) {
//            	System.out.println("id : " + rs.getInt(1) + " name : " + rs.getString(2) );
            	employe emp = new employe();
            	emp.id = String.valueOf( rs.getInt(1));
            	emp.Name = rs.getString(2);
            	al.add(emp);
            }
        }catch(SQLException e) {
        	System.out.println("well, there is an exception \n " + e);
        }
//        sql end

        JFrame frame = new JFrame("employe management system");
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // header
        JPanel header = new JPanel();
        JButton info = new JButton("Info");
        info.setBackground(Color.gray);
        header.setBackground(Color.YELLOW);
        String title = "employe management system";
        header.add(info);
        header.add(new JLabel(title));

        // main 

        //input
        JPanel in = new JPanel();
        in.setBackground(Color.yellow);
        JLabel namel = new JLabel("name :");
        JLabel id = new JLabel("id");
        JTextField nameT = new JTextField(5);
        JTextField idT = new JTextField(5);
        JButton addBtn = new JButton("add");
        addBtn.setBackground(Color.green);
        JButton delBtn = new JButton("delete");
        delBtn.setBackground(Color.red);
        in.add(namel);
        in.add(nameT);
        in.add(id);
        in.add(idT);
        in.add(addBtn);
        in.add(delBtn);

        





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
              status_btn.addActionListener(new ActionListener() {
              	public void actionPerformed(ActionEvent e) {
              		statusEmp(eId, eName, age , eAd1 , eAd2 , eAd3, eDeg, eDept);
              	}
              });
          }
      }catch(SQLException e) {
      	System.out.println("well, there is an exception \n " + e);
      }
//      sql end

        //addBtn
        addBtn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	for(employe i : al) {
            		System.out.println(i.id);
            	}
            	
                String Eid = idT.getText();
                int Eidi = Integer.parseInt(Eid);
                String Ename = nameT.getText();
                int flag = 0;
              //sql
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
            		System.out.println("Connecting to database...");
            		Connection conn = null;
        			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
        			Statement stm = conn.createStatement();
        			ResultSet rs=stm.executeQuery("select * from employes");
        			body.removeAll();
        			while(rs.next()) {
        				
                            if(rs.getInt(1) == Eidi){
                                body.removeAll();
                                System.err.println("same id already exist");
                                JLabel errMsg = new JLabel("same id already exist");
                                body.add(errMsg);
                                flag = 1;
                                break;
                            }
                        }
        			}
        		catch(Exception se) {
        			System.out.println("exception : " + se);
        		}
        		System.out.println(flag);
        	
        		//sql end
                
                if(flag==0){
                	
                	//sql
            		try {
            			Class.forName("com.mysql.cj.jdbc.Driver");
                		System.out.println("Connecting to database...");
                		Connection conn = null;
            			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
            			Statement stm = conn.createStatement();
            			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employes(Id,Name) VALUE(?,?)");
            			pstmt.setInt(1, Eidi);;
            			pstmt.setString(2, Ename);
            			pstmt.executeUpdate();
            			ResultSet rs=stm.executeQuery("select * from employes");
            			body.removeAll();
            			while(rs.next()) {
            				System.out.println(rs.getInt(1) + " " + rs.getString(2));
//            				String s = intName(rs.getString(2));
                            JPanel empList = new JPanel();
                            JLabel nameD = new JLabel();
                            JButton status_btn = new JButton("status");
                            nameD.setText("     Id : "+ rs.getInt(1) + " " + "     Name : "+ rs.getString(2));
                            empList.add(nameD);
                            empList.add(status_btn);
                            body.add(empList);
            			}
            			System.out.println(conn + " " +stm);
            		}catch(SQLException se) {
            			System.out.println("exception : " + se);
            		}
            		catch(ClassNotFoundException ce) {
            			System.out.println(ce);
            		}
            		//sql end

                }

                frame.setVisible(false);
                frame.setVisible(true);
                
            }
        });


        //delBtn
        delBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               
                int flag = 0;
                String Ename = nameT.getText();
                String Eid = idT.getText();
                int Eidi = Integer.parseInt(Eid);
                System.out.println(Ename + Eid);
                
              //sql
                body.removeAll();
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
            		System.out.println("Connecting to database...");
            		Connection conn = null;
        			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
        			Statement stm = conn.createStatement();
        			int x = stm.executeUpdate("DELETE FROM employes WHERE ID = "+Eidi+"");
        			ResultSet rs=stm.executeQuery("select * from employes");
        			body.removeAll();
        			while(rs.next()) {
        				System.out.println(rs.getInt(1) + " " + rs.getString(2));
        				JLabel nameD = new JLabel();
                        nameD.setText("     Id : "+ rs.getInt(1) + " " + "     Name : "+ rs.getString(2));
                        body.add(nameD);
        				
        			}
        			System.out.println(conn + " " +stm);
        		}catch(SQLException se) {
        			System.out.println("exception : " + se);
        		}
        		catch(ClassNotFoundException ce) {
        			System.out.println(ce);
        		}
        		
        		//sql end

                
                
                frame.setVisible(false);
                frame.setVisible(true);
            }
        });
        
        
        //info btn
        info.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JLabel err = new JLabel ("This is an employe management system, you can add by names and id and delete by id. You wont be able to add same id");
        		JLabel cinfo = new JLabel("Made by Shubhaprasad Padhy,19410121001");
        		JButton disbtn = new JButton("Display all");
        		disbtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				try {
                			Class.forName("com.mysql.cj.jdbc.Driver");
                    		System.out.println("Connecting to database...");
                    		Connection conn = null;
                			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
                			Statement stm = conn.createStatement();
                			ResultSet rs=stm.executeQuery("select * from employes");
                			body.removeAll();
                			while(rs.next()) {
                				System.out.println(rs.getInt(1) + " " + rs.getString(2));
                				JLabel nameD = new JLabel();
                                nameD.setText("     Id : "+ rs.getInt(1) + " " + "     Name : "+ rs.getString(2));
                                body.add(nameD);
                				
                			}
                			System.out.println(conn + " " +stm);
                		}catch(SQLException se) {
                			System.out.println("exception : " + se);
                		}
                		catch(ClassNotFoundException ce) {
                			System.out.println(ce);
                		}
                		
                		//sql end

                        
                        
                        frame.setVisible(false);
                        frame.setVisible(true);
        			}
        		});
        		body.removeAll();
        		body.add(err);
        		body.add(cinfo);
        		body.add(disbtn);
        		frame.setVisible(false);
        		frame.setVisible(true);
        		
        	}
        });

      

        frame.getContentPane().add(BorderLayout.NORTH, header);
        frame.getContentPane().add(BorderLayout.SOUTH,in);
        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }
}


////sql start
//try {
//
//  Class.forName("com.mysql.cj.jdbc.Driver");
//  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
//  Statement stm = conn.createStatement();
//  ResultSet rs =  stm.executeQuery("select * from employes");
//  while(rs.next()) {
////  	System.out.println("id : " + rs.getInt(1) + " name : " + rs.getString(2) );
//	  int eId = rs.getInt(1);
//	  String eName = rs.getString(2);
//	  int age = rs.getInt(3);
//	  String eAd1 = rs.getString(4);
//	  String eAd2 = rs.getString(5);
//	  String eAd3 = rs.getString(6);
//	  String eDeg = rs.getString(7);
//	  String eDept = rs.getString(8);
//	  JPanel empList = new JPanel();
//      JLabel nameD = new JLabel();
//      JButton status_btn = new JButton("status");
//      nameD.setText("     Name : "+ eName  + "     ID : "+ eId);
//      empList.add(nameD);
//      empList.add(status_btn);
//      body.add(empList);
//      status_btn.addActionListener(new ActionListener() {
//      	public void actionPerformed(ActionEvent e) {
//      		statusEmp(eId, eName, age , eAd1 , eAd2 , eAd3, eDeg, eDept);
//      	}
//      });
//  }
//}catch(SQLException e) {
//	System.out.println("well, there is an exception \n " + e);
//}
//sql end
