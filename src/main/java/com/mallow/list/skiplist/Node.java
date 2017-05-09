package com.mallow.list.skiplist;

import lombok.Getter;
import java.util.List;

/**
 * Created by lcy on 2017/5/9.
 */
@Getter
public class Node {
    private int value;
    public List<Node> nextNodes;
    public Node(int value) {
        this.value = value;
    }
}
