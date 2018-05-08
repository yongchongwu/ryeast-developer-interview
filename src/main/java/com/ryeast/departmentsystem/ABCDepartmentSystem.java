package com.ryeast.departmentsystem;


import java.util.ArrayList;
import java.util.List;

/**
 * This is the main entry for department system, our system support unlimited hierarchy
 * departments.
 *
 * Currently, for simplicity, we have hard-coded the department data to nine item, you need to
 * output the tree structure to console.
 */
public class ABCDepartmentSystem {

  /**
   * The main method should output this structure:
   *
   * CEO office  ----- Sales
   * |
   * ----- HR
   * |
   * ----- Support
   * |
   * ----- R&D ----- QA
   * |         |
   * |         ----- Deploy
   * |         |
   * |         ----- Development
   * |
   * ----- Finance
   */
  public static void main(String[] args) {

    Department ceo = null;

    Department finance = null;
    Department hr = null;
    Department support = null;
    Department sales = null;
    Department rd = null;

    Department qa = null;
    Department deploy = null;
    Department development = null;

    //Add your code here to ensure the correct department budget.
    ceo = new Department(1, "CEO office", 0, null);

    finance = new Department(2, "Finance", 246, 1);
    hr = new Department(3, "HR", 79, 1);
    support = new Department(4, "Support", 106, 1);
    sales = new Department(5, "Sales", 61, 1);
    rd = new Department(6, "R&D", 0, 1);

    qa = new Department(7, "QA", 10, 6);
    deploy = new Department(8, "Deploy", 25, 6);
    development = new Department(9, "Development", 85, 6);

    List<Department> list = new ArrayList<Department>();
    list.add(ceo);
    list.add(finance);
    list.add(hr);
    list.add(support);
    list.add(sales);
    list.add(rd);
    list.add(qa);
    list.add(deploy);
    list.add(development);
    
    //构建树形结构
    List<Department> tree = TreeUtil.makeTree(list);
    //重新计算Budget
    makeBudget(tree);

    //Please ensure the the assert pass.
    assertCondition(ceo.getBudget() == 612);

    assertCondition(sales.getBudget() == 61);
    assertCondition(hr.getBudget() == 79);
    assertCondition(support.getBudget() == 106);
    assertCondition(finance.getBudget() == 246);

    assertCondition(rd.getBudget() == 120);
    assertCondition(deploy.getBudget() == 25);
    assertCondition(qa.getBudget() == 10);
    assertCondition(development.getBudget() == 85);

    //Add your code here to completed the test.


  }

  private static void makeBudget(List<Department> tree){
    for (Department department : tree) {
      sumBudget(department, department.getChildren());
    }
  }

  private static void sumBudget(Department department, List<Department> children) {
    for (Department child : children) {
      if (null!=child.getChildren()&&child.getChildren().size() > 0) {
        sumBudget(child, child.getChildren());
      }
      department.setBudget(nvlBudget(department.getBudget()) + nvlBudget(child.getBudget()));
    }
  }

  private static Integer nvlBudget(Integer budget){
    return (null==budget)?0:budget;
  }


  private static void assertCondition(boolean condition) {
    if (!condition) {
      throw new RuntimeException(
          "Seems your department budget is not correct, please fix it first.");
    }
  }


}
