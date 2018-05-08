package com.ryeast.departmentsystem;


import java.util.ArrayList;
import java.util.List;

public class TreeUtil {

  public static  <T extends TreeNode> List<T> makeTree(List<T> list){
    List<T> tree = new ArrayList<T>();
    if(null!=list){
      TreeNode parentNode = new TreeNode();
      for (T node:list) {
        parentNode.setId(node.getParent_id());
        int index = list.indexOf(parentNode);
        if (index != -1) {
          ((TreeNode) list.get(index)).addChild(node);
        }else {
          tree.add(node);
        }
      }
    }
    return tree;
  }

  public static <T extends TreeNode> List<T> getRoot(List<T> tree){
    if(null!=tree&&tree.size()>0){
      tree.get(0);
    }
    return null;
  }

}
