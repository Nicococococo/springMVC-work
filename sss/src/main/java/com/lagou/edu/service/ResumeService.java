package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;

import java.util.List;

public interface ResumeService {

    List<Resume> queryAll();

    Resume getResume(Long id);

    void deleteResume(Long id);

    Resume saveOrUpdateResume(Resume resume);

}
