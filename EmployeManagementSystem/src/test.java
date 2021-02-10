import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class test {

	public static int nameInt(String s) {
		int x = 0;
		for(int i=0; i<s.length(); i++) {
			int a = (int )s.charAt(i);
			x = x*10 + (a-96); 
		}
		return x;
	}
	
	public static String intName(String s) {
		String res = "";
		System.out.println(s);
		for(int i=0; i<s.length(); i++) {
			int x = Integer.parseInt(String.valueOf(s.charAt(i)) ) ;
			System.out.println(x);
			char ch = (char)(x+96);
			res = res + ch;
		}
		System.out.println(res);
		return res;
	}
	
	
	public static void main(String[] args) {
		int x = nameInt("shubha");
		System.out.println(intName(String.valueOf(x)));

	}

}

//class abcd {
//	
//    public static void abc ()throws ClassNotFoundException{
//
//        ArrayList<employe>al = new ArrayList<employe>();
//        
//        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
//            Statement stm = conn.createStatement();
//            ResultSet rs =  stm.executeQuery("select * from employes");
//            while(rs.next()) {
////            	System.out.println("id : " + rs.getInt(1) + " name : " + rs.getString(2) );
//            	employe emp = new employe();
//            	emp.id = String.valueOf( rs.getInt(1));
//            	emp.Name = rs.getString(2);
//            	al.add(emp);
//            }
//        }catch(SQLException e) {
//        	System.out.println("well, there is an exception \n " + e);
//        }
//
//        JFrame frame = new JFrame("employe management system");
//        frame.setSize(500,300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // header
//        JPanel header = new JPanel();
//        JButton info = new JButton("Info");
//        info.setBackground(Color.gray);
//        header.setBackground(Color.YELLOW);
//        String title = "employe management system";
//        header.add(info);
//        header.add(new JLabel(title));
//
//        // main 
//
//        //input
//        JPanel in = new JPanel();
//        in.setBackground(Color.yellow);
//        JLabel namel = new JLabel("name :");
//        JLabel id = new JLabel("id");
//        JTextField nameT = new JTextField(5);
//        JTextField idT = new JTextField(5);
//        JButton addBtn = new JButton("add");
//        addBtn.setBackground(Color.green);
//        JButton delBtn = new JButton("delete");
//        delBtn.setBackground(Color.red);
//        in.add(namel);
//        in.add(nameT);
//        in.add(id);
//        in.add(idT);
//        in.add(addBtn);
//        in.add(delBtn);
//
//        
//
//
//
//
//
//        //body display
//        JPanel body = new JPanel();
//        body.setBackground(Color.lightGray);
//        JScrollPane scrollPane = new JScrollPane(body);
//        body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
//        for(employe i : al){
//            JLabel nameD = new JLabel();
//            nameD.setText("     Name : "+i.Name + "     ID : "+i.id);
//            body.add(nameD);
//        }
//
//        //addBtn
//        addBtn.addActionListener(new ActionListener() {
//            
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	
//            	for(employe i : al) {
//            		System.out.println(i.id);
//            	}
//            	
//                String Eid = idT.getText();
//                int Eidi = Integer.parseInt(Eid);
//                String Ename = nameT.getText();
//                int flag = 0;
//                for(employe i : al){
//                    if(i.id.equals(Eid)){
//                        body.removeAll();
//                        System.err.println("same id already exist");
//                        JLabel errMsg = new JLabel("same id already exist");
//                        body.add(errMsg);
//                        flag = 1;
//                        break;
//                    }
//                }
//                if(flag==0){
//                	
//                	//sql
//            		try {
//            			Class.forName("com.mysql.cj.jdbc.Driver");
//                		System.out.println("Connecting to database...");
//                		Connection conn = null;
//            			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
//            			Statement stm = conn.createStatement();
//            			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employes(Id,Name) VALUE(?,?)");
//            			pstmt.setInt(1, Eidi);;
//            			pstmt.setString(2, Ename);
//            			pstmt.executeUpdate();
//            			ResultSet rs=stm.executeQuery("select * from employes");
//            			body.removeAll();
//            			while(rs.next()) {
//            				System.out.println(rs.getInt(1) + " " + rs.getString(2));
////            				String s = intName(rs.getString(2));
//            				JLabel nameD = new JLabel();
//                            nameD.setText("     Id : "+ rs.getInt(1) + " " + "     Name : "+ rs.getString(2));
//                            body.add(nameD);
//            			}
//            			System.out.println(conn + " " +stm);
//            		}catch(SQLException se) {
//            			System.out.println("exception : " + se);
//            		}
//            		catch(ClassNotFoundException ce) {
//            			System.out.println(ce);
//            		}
//            		//sql end
//
//                }
//
//                frame.setVisible(false);
//                frame.setVisible(true);
//                
//            }
//        });
//
//
//        //delBtn
//        delBtn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//               
//                int flag = 0;
//                String Ename = nameT.getText();
//                String Eid = idT.getText();
//                int Eidi = Integer.parseInt(Eid);
//                System.out.println(Ename + Eid);
//                
//              //sql
//                body.removeAll();
//        		try {
//        			Class.forName("com.mysql.cj.jdbc.Driver");
//            		System.out.println("Connecting to database...");
//            		Connection conn = null;
//        			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
//        			Statement stm = conn.createStatement();
//        			int x = stm.executeUpdate("DELETE FROM employes WHERE ID = "+Eidi+"");
//        			ResultSet rs=stm.executeQuery("select * from employes");
//        			body.removeAll();
//        			while(rs.next()) {
//        				System.out.println(rs.getInt(1) + " " + rs.getString(2));
//        				JLabel nameD = new JLabel();
//                        nameD.setText("     Id : "+ rs.getInt(1) + " " + "     Name : "+ rs.getString(2));
//                        body.add(nameD);
//        				
//        			}
//        			System.out.println(conn + " " +stm);
//        		}catch(SQLException se) {
//        			System.out.println("exception : " + se);
//        		}
//        		catch(ClassNotFoundException ce) {
//        			System.out.println(ce);
//        		}
//        		
//        		//sql end
//
//                
//                
//                frame.setVisible(false);
//                frame.setVisible(true);
//            }
//        });
//        
//        
//        //info btn
//        info.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		JLabel err = new JLabel ("This is an employe management system, you can add by names and id and delete by id. You wont be able to add same id");
//        		JLabel cinfo = new JLabel("Made by Shubhaprasad Padhy,19410121001");
//        		JButton disbtn = new JButton("Display all");
//        		disbtn.addActionListener(new ActionListener() {
//        			public void actionPerformed(ActionEvent e) {
//        				try {
//                			Class.forName("com.mysql.cj.jdbc.Driver");
//                    		System.out.println("Connecting to database...");
//                    		Connection conn = null;
//                			conn = DriverManager.getConnection("jdbc:mysql://localhost/db","root","Rupel@3696");
//                			Statement stm = conn.createStatement();
//                			ResultSet rs=stm.executeQuery("select * from employes");
//                			body.removeAll();
//                			while(rs.next()) {
//                				System.out.println(rs.getInt(1) + " " + rs.getString(2));
//                				JLabel nameD = new JLabel();
//                                nameD.setText("     Id : "+ rs.getInt(1) + " " + "     Name : "+ rs.getString(2));
//                                body.add(nameD);
//                				
//                			}
//                			System.out.println(conn + " " +stm);
//                		}catch(SQLException se) {
//                			System.out.println("exception : " + se);
//                		}
//                		catch(ClassNotFoundException ce) {
//                			System.out.println(ce);
//                		}
//                		
//                		//sql end
//
//                        
//                        
//                        frame.setVisible(false);
//                        frame.setVisible(true);
//        			}
//        		});
//        		body.removeAll();
//        		body.add(err);
//        		body.add(cinfo);
//        		body.add(disbtn);
//        		frame.setVisible(false);
//        		frame.setVisible(true);
//        		
//        	}
//        });
//
//      
//
//        frame.getContentPane().add(BorderLayout.NORTH, header);
//        frame.getContentPane().add(BorderLayout.SOUTH,in);
//        frame.getContentPane().add(scrollPane);
//        frame.setVisible(true);
//    }
//}
