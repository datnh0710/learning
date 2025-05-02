package com.DataStructures;

public class DisjSets {
    private int[] s;

    /**
     * Construct the disjoint sets object
     *
     * @param numElements the initial number of disjoint sets
     */
    public DisjSets(int numElements) {
        s = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            s[i] = -1;
        }

    }

    /**
     * Union two disjoint sets
     * for simplicity, we assume root1 and root2 are disjoint
     * and represent set names
     *
     * @param root1 the root of set 1
     * @param root2 the root of set 2
     */
    public void union(int root1, int root2) {
        s[root2] = root1;
    }

    /**
     * Union two disjoint sets using the height heuristic
     * for simplicity, we assume root1 and root2 are distinct
     * and represent set name
     *
     * @param root1 root of set 1
     * @param root2 root of set 2
     */
    public void union1(int root1, int root2) {
        if (s[root2] < s[root1]) { //root2 is deeper than root 1
            s[root1] = root2; // make root2 new root
        } else {
            if (s[root1] == s[root2])
                s[root1]--; // update height if same
            s[root2] = root1; //make root1 new root
        }
    }

    /**
     * Union two disjoint sets using the size heuristic
     * for simplicity, we assume root1 and root2 are distinct
     * and represent set name
     *
     * @param root1
     * @param root2
     */
    public void union2(int root1, int root2) {
        if (s[root1] < s[root2]) {
            s[root1] = root2;
        } else if (s[root2] < s[root1]) {
            s[root2] = root1;
        } else {
            s[root1] += s[root2];
            s[root2] = root1;
        }


    }

    /**
     * perform a find.
     * error checks ommitted again for simplicity.
     *
     * @param x the element being searched for.
     * @return the set containing x
     */
    public int find(int x) {
        if (s[x] < 0)
            return x;
        else
            return find(s[x]);
    }

    /**
     * perform a find.
     * error checks ommitted again for simplicity.
     *
     * @param x the element being searched for.
     * @return the set containing x
     */
    public int find1(int x) {
        if (s[x] < 0)
            return x;
        else
            return s[x] = find1(s[x]);
    }

    public static void main(String[] args) {
        int NumElements = 128;
        int NumInSameSet = 16;
        DisjSets ds = new DisjSets(NumElements);
        int set1, set2;
        for (int i = 1; i < NumInSameSet; i *= 2) {
            for (int j = 0; j + i < NumElements; j += 2 * i) {
                set1 = ds.find1(j);
                set2 = ds.find1(j + i);
                ds.union1(set1, set2);
            }
        }
        for (int i = 0; i < NumElements; i++) {
            System.out.printf("%s", ds.find1(i) + "*");
            if (i % NumInSameSet == NumInSameSet - 1)
                System.out.printf("%n");
        }
        System.out.printf("%n");
    }

}
