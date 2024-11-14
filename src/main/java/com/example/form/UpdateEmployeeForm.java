package com.example.form;

/**
 * 従業員一覧画面に対応するフォームクラス
 * @Author 野上
 */
public class UpdateEmployeeForm {

    private String id;
    private String dependentsCount;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDependentsCount() {
        return dependentsCount;
    }
    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
    }
    
}
