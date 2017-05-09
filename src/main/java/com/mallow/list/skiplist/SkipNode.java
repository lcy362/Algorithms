package com.mallow.list.skiplist;

import lombok.Getter;
import java.util.List;

/**
 * Created by lcy on 2017/5/9.
 */
@Getter
class SkipNode<E extends Comparable<? super E>> {
    private final E value;
    public final SkipNode<E>[] nextNodes; // array of pinter

    @SuppressWarnings("unchecked")
    public SkipNode(int level, E value) {
        nextNodes = new SkipNode[level + 1];
        this.value = value;
    }
}
