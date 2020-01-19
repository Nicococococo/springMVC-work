package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping
    public String resume(HttpServletRequest request) {
        return "resume";
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Resume> queryAll() {
        return resumeService.queryAll();
    }

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public Resume getResume(@PathVariable Long id) {
        return resumeService.getResume(id);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteResume(@PathVariable Long id){
        resumeService.deleteResume(id);
    }

    /**
     * 保存和修改
     * @param resume
     * @return
     */
    @RequestMapping("/saveOrUpdateResume")
    @ResponseBody
    public Resume saveOrUpdateResume(@RequestBody Resume resume){
        return resumeService.saveOrUpdateResume(resume);
    }

}
