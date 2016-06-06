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
public class Graph {

	private Node initial;

    public Node getInitial() {
        return initial;
    }

    public void setInitial(Node initial) {
        this.initial = initial;
    }

    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<Node>();
        visitNode(initial, nodes);

        return nodes;
    }

    public void visitNode(Node node, List<Node> nodes) {
        nodes.add(node);

        for (Edge edge : node.getEdges()) {
            Node nextNode = edge.getDest();
            visitNode(nextNode, nodes);
        }
    }

    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<Edge>();
        visitEdge(initial, edges);

        return edges;
    }

    public void visitEdge(Node node, List<Edge> edges) {
        for (Edge edge : node.getEdges()) {
            edges.add(edge);

            Node nextNode = edge.getDest();
            visitEdge(nextNode, edges);
        }
    }

    public Node findById(String id) {
        for (Node node : this.getNodes()) {
            if (id.equals(node.getId())) {
                return node;
            }
        }

        return null;
    }
}
