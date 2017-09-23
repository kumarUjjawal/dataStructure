public class HashTable {



    public class HashEntry {
        private String key;
        private int value;

        public HashEntry(String key,int value) {
            this.key = key;
            this.value = Math.abs(value);
        }

        private String getKey() {
            return key;
        }

        private int getValue() {
            return value;
        }


    }

}

