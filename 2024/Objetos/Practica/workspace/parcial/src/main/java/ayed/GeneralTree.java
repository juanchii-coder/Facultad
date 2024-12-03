package ayed;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GeneralTree<T> {
    private T data;
    private List<GeneralTree<T>> children;

    public GeneralTree() {
        children = new ArrayList<>();
    }

    public GeneralTree(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this.data = data;
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public boolean isEmpty() {
        return data == null && children.isEmpty();
    }

    public void removeChild(GeneralTree<T> child) {
        children.remove(child);
    }

    public int height() {
        if (isLeaf()) return 0;
        int maxChildHeight = 0;
        for (GeneralTree<T> child : children) {
            maxChildHeight = Math.max(maxChildHeight, child.height());
        }
        return 1 + maxChildHeight;
    }

    public int level(T value) {
        return findLevel(this, value, 0);
    }

    private int findLevel(GeneralTree<T> node, T value, int level) {
        if (Objects.equals(node.data, value)) return level;
        for (GeneralTree<T> child : node.children) {
            int childLevel = findLevel(child, value, level + 1);
            if (childLevel != -1) return childLevel;
        }
        return -1;
    }

    public int width() {
        return getWidth(this);
    }

    private int getWidth(GeneralTree<T> node) {
        if (node.isLeaf()) return 1;
        int width = 0;
        for (GeneralTree<T> child : node.children) {
            width += getWidth(child);
        }
        return width;
    }
}
