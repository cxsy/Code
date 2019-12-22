package com.zhiguo.LangTest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * LFU
 */
class Node implements Comparable {
    int val, cnt;

    Node(int val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Node) {
            Node oo = (Node) o;
            return oo.cnt == this.cnt ? this.val - oo.val : this.cnt - oo.cnt;
        }
        return 0;
    }
}

public class LFU {

    int capacity;
    TreeSet<Node> set;
    Map<Integer, Node> map;

    LFU(int cap) {
        this.capacity = cap;
        this.set = new TreeSet<>();
        this.map = new HashMap<>();
    }

    public void push(int val) {
        if (!this.map.containsKey(val)) {
            if (this.set.size() == this.capacity) {
                Node n = this.set.iterator().next();
                this.set.remove(n);
                this.map.remove(n.val);
            }
            Node n = new Node(val, 1);
            this.map.put(val, n);
            this.set.add(n);
        } else {
            Node n = this.map.get(val);
            this.set.remove(n);
            n.cnt++;
            this.set.add(n);
        }
    }

    public void show() {
        this.set.stream().forEach(x -> System.out.println(x.val + " " + x.cnt));
    }

    public static void main(String[] args) {
        LFU lfu = new LFU(2);
        int[] arr = { 1, 1, 1, 2, 3, 2, 2, 2, 1 };
        for (int i : arr) {
            lfu.push(i);
        }
        lfu.show();
    }
}