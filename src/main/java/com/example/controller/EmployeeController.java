package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;

/**
 * 従業員テーブルに対応するコントローラクラス
 * 必要な情報をフォームから受け取り、サービスを通じて処理を行う
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    /**
     * サービスクラスを通じて、従業員一覧を取得する
     * 従業員一覧画面にフォワードする
     * @param model
     * @return　従業員一覧画面
     * @Author 野上
     */
    @GetMapping("/showList")
    public String showList(Model model) {
        List<Employee> employeeList = eService.showList();
        model.addAttribute("employeeList", employeeList);

        return "employee/list";
    }

    /**
     * フォームからidを受け取り、
     * サービスクラスを通じて扶養人数を更新する
     * @param id
     * @param model
     * @param form
     * @return 詳細画面
     */
    @GetMapping(value = "/{id}/showDetail")
    public String showDetail(@PathVariable("id") String id, Model model, UpdateEmployeeForm form) {
        Employee employee = eService.showDetail(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    /**
     * フォームからidを受け取り、
     * サービスクラスを通じて扶養人数を更新する
     */
    @PostMapping("/update")
    public String update(UpdateEmployeeForm form) {
        Employee employee = eService.showDetail(Integer.parseInt(form.getId()));
        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));

        eService.update(employee);
        return "redirect:/employee/showList";
    }
}
