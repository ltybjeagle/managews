/**
 * 项目名称：com.base.util.activiti
 * 创建日期：2016-4-4
 * 修改历史：
 *    1、[2016-4-4]创建文件    by liutianyang
 */
package com.base.util.activiti;

/**
 * 
 * @author liutianyang
 */
public class Edge extends GraphElement {

	private Node src;
    private Node dest;

    public Node getSrc() {
        return src;
    }

    public void setSrc(Node src) {
        this.src = src;
    }

    public Node getDest() {
        return dest;
    }

    public void setDest(Node dest) {
        this.dest = dest;
    }
}
