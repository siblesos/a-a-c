package com.adc.da.system.util;

import com.adc.da.system.model.dto.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 树工具类
 */
public class TreeUtil {
    /**
     * 两层循环实现
     *
     * @param treeNodes 节点列表
     * @param root 根节点ID
     * @return
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.addChild(it);
                }
            }
        }
        return trees;
    }
}
