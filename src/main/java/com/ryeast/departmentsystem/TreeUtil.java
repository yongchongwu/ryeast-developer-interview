package com.ryeast.departmentsystem;


import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

  /**
   * 生成树
   * @param list
   * @param <T>
   * @return
   */
  public static <T extends TreeNode> List<T> makeTree(List<T> list) {
    List<T> tree = new ArrayList<T>();
    if (null != list) {
      TreeNode parentNode = new TreeNode();
      for (T node : list) {
        parentNode.setId(node.getParent_id());
        int index = list.indexOf(parentNode);
        if (index != -1) {
          ((TreeNode) list.get(index)).addChild(node);
        } else {
          tree.add(node);
        }
      }
    }
    return tree;
  }

  /**
   * 获得根节点
   * @param tree
   * @param <T>
   * @return
   */
  public static <T extends TreeNode> T getRoot(List<T> tree) {
    if (null != tree && tree.size() > 0) {
      tree.get(0);
    }
    return null;
  }

  /**
   * 输出树结构
   * @param tree
   */
  public static void outputTree(List<Department> tree){
    printTree(tree,0);
  }

  /**
   * 打印树
   * @param tree
   * @param n
   */
  public static void printTree(List<Department> tree,Integer n) {

    for (int i=0;i<tree.size();i++) {

      Department department=tree.get(i);

      if(department.getParent_id()==null){
        System.out.println(department.getName());
      }else {
        System.out.println(getHChr(n)+ "-----" + department.getName());
      }
      if (null != department.getChildren() && department.getChildren().size() > 0) {
        n++;
        printTree(department.getChildren(),n);
        n=1;
      }
    }
  }

  private static String getHChr(int i){
    String str="";
    int n=i*5;
    while (n>0){
      n--;
      str+=" ";
      if(n%5==0){
        str+="|";
      }
    }
    return str;
  }

}
