package com.adc.da.system.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *

 */
@Data
public class TreeNode implements Serializable {
    private long id;
    private long parentId;
    /**
     * 子节点
     */
    private List<TreeNode> children = new ArrayList<>();

    public void addChild(TreeNode node) {
        children.add(node);
    }
}
