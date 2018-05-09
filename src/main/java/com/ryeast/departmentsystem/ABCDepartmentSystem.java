package com.ryeast.departmentsystem;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    deploy = new Department(8, "Deploy", 0, 6);
    development = new Department(9, "Development", 85, 6);

    Department deploy1 = new Department(10, "Deploy--1", 20, 8);
    Department deploy2 = new Department(11, "Deploy--2", 5, 8);

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

    list.add(deploy1);
    list.add(deploy2);

    DepartmentService service = new DepartmentService();
    //重新计算Budget
    for (Department department : list) {
      service.makeBudget(department, list);
    }

    //以Budget的值升序排序
    Collections.sort(list, new Comparator<Department>() {
      public int compare(Department o1, Department o2) {
        return (null == o1.getBudget() ? 0 : o1.getBudget()) - (null == o2.getBudget() ? 0
            : o2.getBudget());
      }
    });

    //构建树形结构
    List<Department> tree = TreeUtil.makeTree(list);

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
    TreeUtil.outputTree(tree);

  }

  private static void assertCondition(boolean condition) {
    if (!condition) {
      throw new RuntimeException(
          "Seems your department budget is not correct, please fix it first.");
    }
  }

}
