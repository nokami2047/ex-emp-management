package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;

/**
 * employeesテーブルを操作するサービスクラス
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository eRepository = new EmployeeRepository();

    /**
     * リポジトリを通じて全件検索を行う
     * @return 全従業員の一覧
     */
    public List<Employee> showList() {
        List<Employee> employeesList = eRepository.findAll();
        return employeesList;
    }

    /**
     * リポジトリを通じて従業員情報を取得する
     * @param id
     * @return　従業員情報
     */
    public Employee showDetail(Integer id) {
        Employee employee = eRepository.load(id);
        return employee;
    }
}
