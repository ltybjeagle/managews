/**
 * 项目名称：com.base.util.activiti
 * 创建日期：2016-4-4
 * 修改历史：
 *    1、[2016-4-4]创建文件    by liutianyang
 */
package com.base.util.activiti;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liutianyang
 */
public class Node extends GraphElement {

	private String type;
    private boolean active;
    private List<Edge> edges = new ArrayList<Edge>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
