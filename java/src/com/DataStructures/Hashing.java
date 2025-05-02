package com.DataStructures;

public class Hashing {
    public static void main(String[] args) {
        hashString1();
        hashString2();
        hashString3();

    }

    public static void hashString1() {
        System.out.printf("%d%n", hash("nhtad1007", 1024));
        System.out.printf("%d%n", hash("datnh0710", 1024));
        System.out.printf("%d%n", hash("datnh071", 1024));
        System.out.printf("%d%n", hash("datnh07", 1024));
        System.out.printf("-----------%n");
    }

    public static void hashString2() {
        System.out.printf("%d%n", hash1("nhtad1007", 1024));
        System.out.printf("%d%n", hash1("datnh0710", 1024));
        System.out.printf("%d%n", hash1("datnh071", 1024));
        System.out.printf("%d%n", hash1("datnh07", 1024));
        System.out.printf("-----------%n");
    }

    public static void hashString3() {
        System.out.printf("%d%n", hash2("nhtad1007", 1024));
        System.out.printf("%d%n", hash2("datnh0710", 1024));
        System.out.printf("%d%n", hash2("datnh071", 1024));
        System.out.printf("%d%n", hash2("datnh07", 1024));
        System.out.printf("-----------%n");
    }

    /**
     * hashing function for String, it is simple hashing function
     * add up all characters and mod with tablesize
     *
     * @param key
     * @param tableSize
     * @return hashing number
     */
    private static int hash(String key, int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal += key.charAt(i);
        }
        return hashVal % tableSize;
    }

    /**
     * hashing function
     * use beginning 3 characters of key and mod with tableSize
     *
     * @param key
     * @param tableSize
     * @return hashing number
     */
    private static int hash1(String key, int tableSize) {
        return (key.charAt(0) + 27 * key.charAt(1) + 729 * key.charAt(2)) % tableSize;
    }

    /**
     * a hash rountine for String objects
     *
     * @param key       the String to hash
     * @param tableSize size of the hash table
     * @return the hash value
     */
    private static int hash2(String key, int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }
        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize;
        return hashVal;
    }

    public final class String1 {
        private int hash = 0;

        public int lenght() {
            return 10;
        }

        public char charAt(int idx) {
            return '0';
        }

        public int hashCode() {
            if (hash != 0) {
                return hash;
            }
            for (int i = 0; i < lenght(); i++) {
                hash = hash * 31 + charAt(i);

            }
            return hash;
        }
    }
}
