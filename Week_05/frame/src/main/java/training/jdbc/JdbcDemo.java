package training.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO
 *
 * @author ping.zhang
 * @date 2021/2/21 1:19
 */
@Component
public class JdbcDemo {

    @Resource(name = "dataSource")
    DataSource dataSource;

    @PostConstruct
    public void crudByJdbc() {
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("select * from student where id = ?");
            preparedStatement.setInt(1, 1);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("id:%d, name:%s", rs.getInt("id"), rs.getString("name")));
            }

            PreparedStatement statement = con.prepareStatement("insert into student values (?,?)");
            statement.setInt(1, 3);
            statement.setString(2, "小张");

            con.setAutoCommit(false);

            con.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            statement.execute();

            con.commit();

            PreparedStatement statement1 = con.prepareStatement("select * from student where id = ?");
            statement1.setInt(1, 3);

            ResultSet rs1 = statement1.executeQuery();
            while (rs1.next()) {
                System.out.println(String.format("验证插入结果 id:%d, name:%s", rs1.getInt("id"), rs1.getString("name")));
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
