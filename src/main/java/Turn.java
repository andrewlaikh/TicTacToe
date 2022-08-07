public enum Turn {
    X("X",1),
    O("O",-1);

        private final String representation;
        private final int value;

        Turn(String representation, int value) {
            this.representation = representation;
            this.value = value;
        }

        public String returnString() {
            return this.representation;
        }

        public int returnVal() {
            return this.value;
    }
}
