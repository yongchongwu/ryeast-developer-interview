package com.ryeast.departmentsystem;


/**
 * @author <a href="mailto:hyysguyang@gamil.com">Young Gu</a>
 * @author <a href="mailto:Young.Gu@lifecosys.com">Young Gu</a>
 */
public class Department extends TreeNode {

  private Integer budget;

  public Department() {
    super();
  }

  public Department(Integer id, String name, Integer budget, Integer parent_id) {
    super(id, name, parent_id);
    this.budget = budget;
  }

  public Integer getBudget() {
    return budget;
  }

  public void setBudget(Integer budget) {
    this.budget = budget;
  }
}
