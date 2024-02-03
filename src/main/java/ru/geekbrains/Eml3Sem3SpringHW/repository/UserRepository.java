package ru.geekbrains.Eml3Sem3SpringHW.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.geekbrains.Eml3Sem3SpringHW.domain.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;

    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User(
                    r.getInt("id"),
                    r.getString("name"),
                    r.getInt("age"),
                    r.getString("email")
            );
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User getOne(int id) {
        String sql = "SELECT * FROM userTable WHERE id=?";

        return (User) jdbc.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper(User.class));
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (name,age,email) VALUES (?,?,?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
        return  user;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    public User update(User user) {
        String sql = "UPDATE userTable SET name = ?, age = ?, email = ? WHERE id = ?";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail(), user.getId());
        return user;
    }
}
