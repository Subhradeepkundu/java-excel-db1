import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//javax.validation.constraints.NotNull
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JsontoDatabase
{
  // static  int count=1;
    public static void main(String[] args)
    {
        String sn = null;
        String scn = null;
        String add = null;
        String ct = null;
        String cntry = null;
        String pst = null;
        String emle = null;
        long k1 =0;



        JSONParser jsonParser=new JSONParser();
        try
        {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studs", "root", "sysmanage");
            Statement statement = connection.createStatement();

          FileReader reader = new FileReader(".\\jsonfiles\\Kaoan.json");
           //Scanner sc=new Scanner(new FileReader(".\\jsonfiles\\Kaoan.json"));
            //System.out.println("bl"+sc);

//            while (sc.hasNextLine())
//            {

             // String s=sc.nextLine();
           // Object obj = jsonParser.parse(sc.nextLine());
                Object obj = jsonParser.parse(reader);
               System.out.println("ddrr"+obj);



//                JSONObject em = (JSONObject) obj;
//                System.out.println("dddd" + em);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println("bas"+employeeList);

            for (Object emp:employeeList)
            {
                //count++;
                JSONObject empObj=(JSONObject) emp;
                if (empObj == null)
                {
                    System.exit(0);
                }
                if(empObj.get("id")!=null)
                {
                    Long k = (Long)empObj.get("id");
                    System.out.println(k);
                    k1=k;
                }

                if(empObj.get("studentname")!=null)
                 {
                    String studname = (String) empObj.get("studentname");
                    sn=studname;
                 }
                else
                 {
                    System.out.println("student name is null");
                    continue;

//                    try
//                    {
//                        throw new NullArgumentException();
//                    }
//                    catch (NullArgumentException e)
//                    {
//                        System.out.println("Caught the exception");
//                        System.out.println(e.getMessage());
//                    }

               }


                if(empObj.get("schoolname")!=null)
                {
                    String schoolnam = (String) empObj.get("schoolname");
                     scn = schoolnam;
                }
                else
                {
                    System.out.println("schoolname is null");
                    continue;
                }

                if(empObj.get("address")!=null)
                {
                    String addr = (String)empObj.get("address");
                    add=addr;
                }
                else
                {
                    System.out.println("address is null");
                    continue;
                }

                if(empObj.get("city")!=null)
                {
                    String cty = (String) empObj.get("city");
                    ct=cty;
                }
                else
                {
                    System.out.println("city is null");
                    continue;
                }

                if(empObj.get("country")!=null)
                {
                    String cuntry = (String) empObj.get("country");
                    cntry=cuntry;
                }
                else
                {
                    System.out.println("country is null");
                    continue;
                }

                if(empObj.get("postal")!=null)
                {
                    String post = (String) empObj.get("postal");
                    pst=post;
                }
                else
                {
                    System.out.println("postal is null");
                    continue;
                }

                if(empObj.get("email")!=null)
                {
                    String eml = (String) empObj.get("email");
                    emle=eml;
                }
                else
                {
                    System.out.println("email is null");
                    continue;
                }

                String phn = (String) empObj.get("phone");
               String joiningdate = (String) empObj.get("doj");

//               if (empObj.get("doj").=="2021-09-21")
//                {
//
//                    System.out.println("ffff");
//                    UPDATE table_name SET column1 = value1, column2 = value2,...
//                    WHERE condition;
//                }

                String sql = "INSERT INTO students VALUES(" + k1 + ",'" + sn + "','" + scn + "','" + add + "','" + ct + "','" + cntry + "','" + pst + "','" + phn + "','" + emle + "','" + joiningdate + "')";
                System.out.println(sql);
                statement.executeUpdate(sql);
            }

            //Iterate over employee array
         //   employeeList.forEach( emp -> parseEmployeeObject((JSONObject) emp));
          // String k=   emp -> parseEmployeeObject((JSONObject) emp);



                // JSONArray data = (JSONArray)em.get("studentname");



                // }


        }

        catch(FileNotFoundException e)
        {

        }
        catch(IOException e)
        {

        }
        catch(ParseException e)
        {

        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

    }

//    public static void parseEmployeeObject(JSONObject emp)
//    {
//        String l;
//        JSONObject em = (JSONObject) emp.get("student");
//        String studname = (String) em.get("studentname");
//        String schoolnam = (String) em.get("schoolname");
//        String addr = (String) em.get("address");
//        String cty = (String) em.get("city");
//        String cuntry = (String) em.get("country");
//        String post = (String) em.get("postal");
//        String phn = (String) em.get("phone");
//        String eml = (String) em.get("email");
//        String joiningdate = (String) em.get("doj");
//
//        String sql = "INSERT INTO students VALUES(" + count + ",'" + studname + "','" + schoolnam + "','" + addr + "','" + cty + "','" + cuntry + "','" + post + "','" + phn + "','" + eml + "','" + joiningdate + "')";
//
//        System.out.println(sql);
//
//    }

}
