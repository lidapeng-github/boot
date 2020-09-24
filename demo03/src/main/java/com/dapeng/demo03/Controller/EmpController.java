package com.dapeng.demo03.Controller;


import com.dapeng.demo03.dao.DeptDao;
import com.dapeng.demo03.dao.EmpDao;
import com.dapeng.demo03.pojo.Dept;
import com.dapeng.demo03.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@Controller
public class EmpController {

    @Autowired
    EmpDao empDao;
    @Autowired
    DeptDao deptDao;

@GetMapping("/emps")
    public String list(Model model){
    List<Emp> all = empDao.getAll();
    System.out.println(all);
    model.addAttribute("emps",all);
    return "emp/list";
    }
    @GetMapping("/emp")
    public String toAdd(Model model){
        List<Dept> depts = deptDao.queryAll();
        model.addAttribute("depts",depts);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Emp emp){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        emp.setEmpNo(Integer.parseInt(uuid));

        empDao.add(emp);
        System.out.println(emp);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toAdd(@PathVariable("id") Integer id,Model model){
        Emp emp = empDao.queryById(id);
        model.addAttribute("emp",emp);
        List<Dept> depts = deptDao.queryAll();
        model.addAttribute("depts",depts);
        return "emp/add";
    }
    @PutMapping("/emp")
    public String update(Emp emp){
        System.out.println(emp);
        empDao.update(emp);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
       empDao.delete(id);
        return "redirect:/emps";
    }

    @GetMapping("/examine/{id}")
    public Boolean examine(@PathVariable("id") Integer id){

    if (empDao.queryById(id) !=null){

        return true;
    }
        return false;
    }

}
