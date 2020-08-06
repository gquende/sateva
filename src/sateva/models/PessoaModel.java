package sateva.models;

import sateva.classes.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PessoaModel extends DataBase {

public Person searchUser(String username){
    open();

    try {

        PreparedStatement stm=con.prepareStatement("select username,password from users where username='"+username+"'");
        ResultSet result=stm.executeQuery();
        System.out.println("Username: "+result.getString(1)+"\nPassword: "+result.getString(2));

        return new Person(result.getString(1),result.getString(2));
    }
    catch (SQLException erro)
    {
        System.out.println("Erro ao tentar aceder a Base de Dados!");

    }finally {
       close();
    }


return null;
}




}
