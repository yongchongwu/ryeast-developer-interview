package com.ryeast.departmentsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TreeNode<T extends TreeNode<T>> implements Serializable {

  private Integer id;
  private String name;
  private boolean leaf = true;
  private Integer parent_id;
  private List<T> children = new ArrayList<T>();

  public TreeNode() {
    leaf = true;
    children = new ArrayList();
  }

  public TreeNode(Integer id, String name) {
    this();
    this.id = id;
    this.name = name;
  }

  public TreeNode(Integer id, String name, Integer parent_id) {
    this(id, name);
    this.parent_id = parent_id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isLeaf() {
    return leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  public Integer getParent_id() {
    return parent_id;
  }

  public void setParent_id(Integer parent_id) {
    this.parent_id = parent_id;
  }

  public List<T> getChildren() {
    return children;
  }

  public void setChildren(List<T> children) {
    this.children = children;
  }

  public void addChild(T child) {
    this.children.add(child);
    child.setParent_id(this.id);
    this.leaf = false;
  }

  @Override
  public boolean equals(Object obj) {
    if ((obj instanceof TreeNode)) {
      TreeNode target = (TreeNode) obj;
      return target.getId().equals(getId());
    }
    return false;
  }
}