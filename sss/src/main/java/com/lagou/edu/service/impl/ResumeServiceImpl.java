package com.lagou.edu.service.impl;

import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> queryAll() {

        List<Resume> list = resumeDao.findAll();

        return list;
    }

    @Override
    public Resume getResume(Long id) {

        Optional<Resume> result = resumeDao.findById(id);
        Resume resume = result.get();

        return resume;
    }

    @Override
    public void deleteResume(Long id) {

        resumeDao.deleteById(id);

    }

    @Override
    public Resume saveOrUpdateResume(Resume resume) {

        return resumeDao.save(resume);
    }

}
