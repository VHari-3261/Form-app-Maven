package com.example.forms_app.repository;
import com.example.forms_app.model.userform;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository 
public class submissionrepository 
{
    private final JdbcTemplate jdbcTemplate;
    
    public submissionrepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate=jdbcTemplate;
    }
    public void save(userform form)
    {
        String sql = "insert into details (name,email) values(?,?)";
        jdbcTemplate.update(sql,form.getName(),form.getEmail());
    }
}
