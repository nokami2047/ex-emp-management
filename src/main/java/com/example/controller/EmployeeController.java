package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Employee;
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
     */
    @GetMapping("/showList")
    public String showList(Model model) {
        List<Employee> employeeList = eService.showList();
        model.addAttribute("employeeList", employeeList);

        return "employee/list";
    }
}
