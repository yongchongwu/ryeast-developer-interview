package com.ryeast.departmentsystem;

import java.util.List;

public class DepartmentService {

  /**
   * 重新计算某个部门的Budget
   */
  public void makeBudget(Department department, List<Department> list) {
    Department tmp = new Department();
    tmp.setId(department.getParent_id());
    int index = list.indexOf(tmp);
    if (index != -1) {
      Department parent = list.get(index);
      parent.setBudget(0);
      for (Department node : list) {
        if (node.getParent_id() == parent.getId()) {
          parent.setBudget(
              ((null == parent.getBudget()) ? 0 : parent.getBudget()) + ((null == node.getBudget())
                  ? 0 : node.getBudget()));
        }
      }
      makeBudget(parent, list);
    }
  }

}
