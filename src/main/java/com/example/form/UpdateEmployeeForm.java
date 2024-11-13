package com.example.form;

/**
 * 従業員一覧画面に対応するフォームクラス
 */
public class UpdateEmployeeForm {

    private String id;
    private String dependentsCoun;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDependentsCoun() {
        return dependentsCoun;
    }
    public void setDependentsCoun(String dependentsCoun) {
        this.dependentsCoun = dependentsCoun;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeForm [id=" + id + ", dependentsCoun=" + dependentsCoun + "]";
    }
}
