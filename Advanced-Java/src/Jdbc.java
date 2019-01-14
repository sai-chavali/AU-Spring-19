import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Jdbc {
	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
	    Node node = (Node) nodeList.item(0);
	    return node.getNodeValue();
	}
	
	private static Department getDepartment(Node node) {
        Department dept = new Department();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            dept.setName(getTagValue("Name", element));
            dept.setId(Integer.parseInt(getTagValue("Id", element)));
        }
        return dept;
    }
	
	private static Employee getEmployee(Node node) {
        Employee emp = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            emp.setName(getTagValue("Name", element));
            emp.setId(getTagValue("Id", element));
            emp.setSalary(Integer.parseInt(getTagValue("Salary", element)));
            emp.setDepartment(Integer.parseInt(getTagValue("DepartmentId", element)));
        }
        return emp;
    }
	
	public static void main(String args[]) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","hr","hr");    
			Statement stmt=con.createStatement();
			if(args[0].equals("import")) {
				ResultSet rs=stmt.executeQuery("select * from employee");  
				System.out.println("Employee Table");
				System.out.println("ID\t"+"NAME\t"+"SALARY\t"+"DEPARTMENT");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3) +"\t"+rs.getInt(4));  
				}
				rs=stmt.executeQuery("select * from department");
				System.out.println("\nDepartment Table");
				System.out.println("ID"+"\t"+"NAME");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2));  
				}
			}
			else {
				String filePath = "employees.xml";
				PreparedStatement insert_prep_stmt = con.prepareStatement("insert into employee values(?,?,?,?)");
		        File xmlFile = new File(filePath);
		        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder;
		        dBuilder = dbFactory.newDocumentBuilder();
		        Document doc = dBuilder.parse(xmlFile);
		        doc.getDocumentElement().normalize();
		        NodeList nodeList = doc.getElementsByTagName("Employee");
		        for (int i = 0; i < nodeList.getLength(); i++) {
		        	Employee emp = getEmployee(nodeList.item(i));
		        	insert_prep_stmt.setString(1,emp.getId());
		        	insert_prep_stmt.setString(2,emp.getName());
		        	insert_prep_stmt.setInt(3,emp.getSalary());
		        	insert_prep_stmt.setInt(4,emp.getDepartment());
		        	insert_prep_stmt.executeUpdate();
		        }
		        filePath = "depatments.xml";
		        insert_prep_stmt = con.prepareStatement("insert into department values(?,?)");
		        xmlFile = new File(filePath);
		        doc = dBuilder.parse(xmlFile);
		        doc.getDocumentElement().normalize();
		        nodeList = doc.getElementsByTagName("Department");
		        for (int i = 0; i < nodeList.getLength(); i++) {
		        	Department dept = getDepartment(nodeList.item(i));
		        	insert_prep_stmt.setInt(1,dept.getId());
		        	insert_prep_stmt.setString(2,dept.getName());
		        	insert_prep_stmt.executeUpdate();
		        }
		        System.out.println("Successfully inserted the data");
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}