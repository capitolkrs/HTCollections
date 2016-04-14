public class DBconnection{



public ArrayList<HashMap<String, Object>> connectDB2DatabaseGetRowSet(String sqlQuery) {
		ArrayList<HashMap<String, Object>> list = null;
		try {
			Properties prop = new Properties();
			// Load the DB2(R) Universal JDBC Driver with DriverManager
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			prop.load(new FileInputStream("config.properties"));
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			String strURL = (String) prop.get("URL");
			String strUsername = (String) prop.get("Username");
			String strPassword = (String) prop.get("Password");
			Connection con = DriverManager.getConnection(strURL, strUsername, strPassword);
			if (!con.isClosed())
				System.out.println("Successfully connected to MySQL server");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);

			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			list = new ArrayList<HashMap<String, Object>>(50);
			while (rs.next()) {
				HashMap<String, Object> row = new HashMap<String, Object>(columns);
				for (int i = 1; i <= columns; ++i) {
					row.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(row);
			}

			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
