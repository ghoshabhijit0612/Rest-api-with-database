package com.restApiUsingDb.RestApiUsingDb.service;

import com.restApiUsingDb.RestApiUsingDb.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public StudentService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
        String query = "CREATE TABLE IF NOT EXISTS studentss (id INT PRIMARY KEY, name VARCHAR(255), rollnumber VARCHAR(255), section VARCHAR(255), year VARCHAR(255))";
        jdbcTemplate.update(query);
    }

    public String saveStudent(Student student){
        String query = "insert into studentss(id,name,rollNumber,section,year) values(?,?,?,?,?)";
        int rows = jdbcTemplate.update(query,student.getId(), student.getName(), student.getRollNumber(), student.getSection(), student.getYear());
        return "Successfully inserted";

    }
    public Student getStudent(int id){

        String query = "select * from studentss where id =?";
        Map<String, Object> getObj = jdbcTemplate.queryForMap(query, id);
        Student student = mapToObjConverter(getObj);
        return student;

    }

    public Student updateStudents(Student student, int id) {
        String query = "update studentss SET name = ? , rollNumber = ? ,section = ? , year = ? where id=? ";
        jdbcTemplate.update(query,student.getName(),student.getRollNumber(),student.getSection(),student.getYear(),id);
        return student;


    }


    //get All stduent List
    public List<Student> getAllStudent(){
        String query = "Select * from studentss";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(query);
        List<Student> students = mapToListObjConverter(maps);
//        String s = null;
//        System.out.println(s.length());
        return students;
    }


    public void delete(int id){
        String query = "DELETE FROM studentss WHERE id = ?";
        jdbcTemplate.update(query,id);
        return;
    }
   //List of map to student object converter
    public List<Student> mapToListObjConverter(List<Map<String,Object>> getObj){
            List<Student> list = new ArrayList<>();
            for(Map<String,Object> mp : getObj){
                Student student = mapToObjConverter(mp);
                list.add(student);
            }
            return list;
    }

    //map to studnt obj converter
    public Student mapToObjConverter(Map<String,Object> getObj){
        Student student = new Student();
        student.setId((Integer) getObj.get("id"));
        student.setName((String) getObj.get("name"));
        student.setRollNumber((String) getObj.get("rollNumber"));
        student.setSection((String) getObj.get("section"));
        student.setYear((String) getObj.get("year"));
        return student;
    }
}
