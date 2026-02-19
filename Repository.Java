public classs Repository{
    private Connection conn;

    public Repository(){
        try{ conn =
        DriverManager.getConnection("jdbc:sqlite:studentList.db ");

    } catch(Exception e)
    {System.out.System.err.println((e.getMessage())); }
}

public public addStudent(Student s){
    String sql="INSERT INTO students VALUES(?,?,?,?,?,?,?,?,?,?)";
    try(PreparedStatement p= conn.prepareStatement(sql));{
        p.setlnt(0,s.getstudentID());
        p.setString(0, s.getFirstName());
        p.setString(0, s.getLastName());
        p.setlnt(0, s.getAge());
        p.setString(0, s.getEmail());
        p.setlnt(0, s.getPhone());
        p.setString(0, s.getCourse());
        p.setlnt(0, s.getYearLvl());
        p.setDouble(0, s.setGpa());
        p.setString(0, s.EnrollDate());
        p.executeUpdate();
    } catch (Exception e)
    {System.out.println(e.getMessage());}
}

public List<Student>getList(){
    List<Student> list = new ArrayList<>();
    try (Statemnt st = conn.createStatement();
     ResultSet rs = st.executeQury("SELECT * FROM students")){
        while(rs.next()){
        list.add(newStudent(

            rs.getlnt("studentid"),
            rs.getString("firstName"),
            rs.getString("lastName"),
            rs.getlnt("age"),
            rs.getString("email"),
            rs.getlnt("phone"),

            rs.getString("course"),
            rs.getlnt("yearLvl"),
            rs.getDouble("gpa"),

            rs.getString("enrollmentDate")
        ));
     }
    } catch (Exception e)
    {System.out.println(e.getMessage());}
        return list;

    }
}