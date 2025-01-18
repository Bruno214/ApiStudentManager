package com.estudo.mongo.Api_StudentManager.converter;

import com.estudo.mongo.Api_StudentManager.domain.Student;
import com.estudo.mongo.Api_StudentManager.vo.StudentResponseVo;

public class StudentConverter {

    public StudentResponseVo convertStudent(Student student) {
        return new StudentResponseVo(student.getName(), student.getRegistration(), student.getCpf());
    }

}
